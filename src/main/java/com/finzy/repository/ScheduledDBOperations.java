package com.finzy.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finzy.model.forcast.ForecastResponse;
import com.finzy.model.weather.WeatherResponse;
import com.finzy.service.WeatherServiceInterface;
import com.finzy.utils.GenerateUrl;
import com.finzy.utils.ResponseDataTypes;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

@Service
@Log4j2
public class ScheduledDBOperations {

    private Map<String, CountryService> countries = new HashMap<>();

    @Value("${property.country_configuration}")
    private String configPath;

    @Autowired
    private GenerateUrl generateUrl;

    @Autowired
    private WeatherServiceInterface weatherServiceInterface;

    @PostConstruct
    public void init() throws IOException {
        File file = ResourceUtils.getFile(configPath);
        CountryService[] cs = new ObjectMapper().readValue(file, CountryService[].class);
        for (CountryService country : cs) {
            countries.put(country.getName(), country);
            log.debug("Loaded {} into Country map.", country.getName());
        }
    }

    public Integer getCountryId(String countryName) {
        return countries.get(countryName).getId();
    }

    @Scheduled(fixedRate = 10000L)
    public void scheduleAction2() throws URISyntaxException {
        log.info("Test scheduled Action");
    }

    @Scheduled(cron = "${cron.expression}")
    public void scheduleAction() throws URISyntaxException {
        log.info("Scheduled Action");
        updateDB();
    }

    private void updateDB() throws URISyntaxException {
        RestTemplate restClient = new RestTemplate();
        log.info("DB Operation Started.");
        if (weatherServiceInterface.getAllWeatherInfo().isEmpty()) {
            for (Map.Entry<String, CountryService> entry : countries.entrySet()) {
                URI uri = generateUrl.constructUrl(ResponseDataTypes.FORECAST, entry.getKey()); // create URI based on responseDataTypes
                ForecastResponse response = restClient.getForObject(uri, ForecastResponse.class); // RestClient to exchange the data from the server.
                // There is some in Consistency In Forecasts and Weather Response Data. So for patch up the data adding the below method.
                setCountryName(response, entry.getKey());
                weatherServiceInterface.addForecastDetails(response); // Insert the data into MongoDB.
            }
        } else {
            for (Map.Entry<String, CountryService> entry : countries.entrySet()) {
                URI uri = generateUrl.constructUrl(ResponseDataTypes.WEATHER, entry.getKey()); // create URI based on responseDataTypes
                WeatherResponse response = restClient.getForObject(uri, WeatherResponse.class); // RestClient to exchange the data from the server.
                weatherServiceInterface.addWeatherInfo(response); // Insert the data into MongoDB.
            }
        }
        log.info("DB Operation Ended.");
    }

    private void setCountryName(ForecastResponse response, String key) {
        if (nonNull(response)) {
            List<WeatherResponse> list = response.getList();
            for (WeatherResponse weatherResponse : list)
                weatherResponse.setName(key);
        }
    }
}
