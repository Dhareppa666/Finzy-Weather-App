package com.finzy.controller;

import com.finzy.model.forcast.ForecastResponse;
import com.finzy.model.weather.WeatherResponse;
import com.finzy.service.WeatherServiceInterface;
import com.finzy.utils.GenerateUrl;
import com.finzy.utils.ResponseDataTypes;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Log4j2
@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    private WeatherServiceInterface weatherServiceInterface;

    @Autowired
    private GenerateUrl generateUrl;

//    private final RestTemplate restClient;
//
//    @Autowired
//    public WeatherController(RestTemplate restTemplate) {
//        this.restClient = restTemplate;
//    }

    @GetMapping("/LB_CHECK")
    public String home() {
        log.info("LB Check Request Received and Response Sent Back..!");
        return "OPERATIONAL";
    }

    @GetMapping(value = "/city/{cityname}")
    public ResponseEntity<List<WeatherResponse>> getAllWeatherInfo(@PathVariable("cityname") String cityName) throws URISyntaxException {

        RestTemplate restClient = new RestTemplate();
        URI uri = generateUrl.constructUrl(ResponseDataTypes.FORECAST, cityName);
        log.info(uri);
        //ForecastResponse forecastResponse = restClient.getForObject(uri, ForecastResponse.class);

        List<WeatherResponse> allWeatherInfo = weatherServiceInterface.getAllWeatherInfo();
        log.info("There are {} Records in DB.", allWeatherInfo.size());
        List<WeatherResponse> filteredData = new ArrayList<>();
        for (WeatherResponse weatherResponse : allWeatherInfo) {
            if(nonNull(weatherResponse.getName()) && weatherResponse.getName().equals(cityName))
                filteredData.add(weatherResponse);
        }

        return new ResponseEntity<>(filteredData, HttpStatus.OK);
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Host", "Finzy-Application");
        return headers;
    }
}
