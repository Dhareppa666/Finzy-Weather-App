package com.finzy.model.forcast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.finzy.model.weather.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cod",
        "cnt",
        "list",
        "city"
})
public class ForecastResponse {

    @JsonProperty("cod")
    private Long cod;

    @JsonProperty("cnt")
    private Integer count;

    @JsonProperty("list")
    private List<WeatherResponse> list = null;

    @JsonProperty("city")
    private City city;

    @JsonProperty("cod")
    public Long getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(Long cod) {
        this.cod = cod;
    }

    @JsonProperty("cnt")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("cnt")
    public void setCount(Integer count) {
        this.count = count;
    }


    @JsonProperty("list")
    public List<WeatherResponse> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(List<WeatherResponse> list) {
        this.list = list;
    }

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

}
