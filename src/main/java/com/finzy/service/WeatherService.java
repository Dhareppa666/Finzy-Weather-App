package com.finzy.service;

import com.finzy.model.forcast.ForecastResponse;
import com.finzy.model.weather.WeatherResponse;
import com.finzy.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService implements WeatherServiceInterface {

    @Autowired
    private WeatherRepository weatherRepo;

    /**
     *  For Every 3 hours adding all the cities weather to the DB.
     * @param newWeatherResponse response from the Server.
     * @return return the weather response back to the client.
     */
    @Override
    public WeatherResponse addWeatherInfo(WeatherResponse newWeatherResponse) {
        weatherRepo.save(newWeatherResponse);
        return newWeatherResponse;
    }

    @Override
    public ForecastResponse addForecastDetails(ForecastResponse newForecastResp) {
        List<WeatherResponse> list = newForecastResp.getList();
        for (WeatherResponse weatherResponse : list)
            weatherRepo.save(weatherResponse);
        return newForecastResp;
    }

    @Override
    public List<WeatherResponse> getAllWeatherInfo() {
        return weatherRepo.findAll();
    }

    @Override
    public WeatherResponse getWeatherInfoById(Long id) {
        return null;
    }

}
