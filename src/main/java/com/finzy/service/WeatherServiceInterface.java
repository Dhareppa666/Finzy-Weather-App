package com.finzy.service;

import com.finzy.entity.WeatherModel;
import com.finzy.model.forcast.ForecastResponse;
import com.finzy.model.weather.WeatherResponse;

import java.util.List;

public interface WeatherServiceInterface {

    WeatherResponse addWeatherInfo(WeatherResponse newWeatherResp);

    ForecastResponse addForecastDetails(ForecastResponse newForecastResp);

    List<WeatherResponse> getAllWeatherInfo();

    WeatherResponse getWeatherInfoById(Long id);

}
