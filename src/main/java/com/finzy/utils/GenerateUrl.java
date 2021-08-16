package com.finzy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class GenerateUrl {

    @Value("${finzy.application.id}")
    private String appId;

    private final String forecastUrl = "https://api.openweathermap.org/data/2.5/forecast";

    private final String weatherUrl = "https://api.openweathermap.org/data/2.5/weather";

    public URI constructUrl(ResponseDataTypes dataTypes, String cityName) throws URISyntaxException {
        if (dataTypes.getValue().equals(ResponseDataTypes.FORECAST.getValue()))
            return new URI(this.forecastUrl.concat("?").concat(constructParamsByCityName(cityName).concat(concatAppId())));
        return new URI(this.weatherUrl.concat("?").concat(constructParamsByCityName(cityName).concat(concatAppId())));
    }

    private String constructParamsByCityName(String cityName) {
        return "q=" + cityName;
    }

    private String constructParamsByCityId(String cityName) {
        return "id=" + cityName;
    }

    private String concatAppId() {
        return "&appid=" + this.appId;
    }

}
