package com.finzy.model.weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "coord",
        "weather",
        "main",
        "wind",
        "timezone",
        "id",
        "name",
        "cod",
        "dt_txt"
})
@Document(collection = "WeatherInfo")
public class WeatherResponse {

    @Id
    public String db_id;

    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("weather")
    private java.util.List<Weather> weather = null;
    @JsonProperty("main")
    private Temperature temperature;
    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("timezone")
    private Long timezone;
    @JsonProperty("id")
    private Long country_id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Long cod;

    @JsonProperty("dt_txt")
    private String date;

    @JsonProperty("coord")
    public Coord getCoord() {
        return coord;
    }
    @JsonProperty("coord")
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @JsonProperty("weather")
    public List<Weather> getWeather() {
        return weather;
    }
    @JsonProperty("weather")
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("main")
    public Temperature getTemperature() {
        return temperature;
    }
    @JsonProperty("main")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }
    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonProperty("timezone")
    public Long getTimezone() {
        return timezone;
    }
    @JsonProperty("timezone")
    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("id")
    public Long getCountry_id() {
        return country_id;
    }
    @JsonProperty("id")
    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("cod")
    public Long getCod() {
        return cod;
    }
    @JsonProperty("cod")
    public void setCod(Long cod) {
        this.cod = cod;
    }

    @JsonProperty("dt_txt")
    public String getDate() {
        return date;
    }

    @JsonProperty("dt_txt")
    public void setDate(String date) {
        this.date = date;
    }
}
