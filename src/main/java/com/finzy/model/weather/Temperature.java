
package com.finzy.model.weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "feels_like",
    "temp_min",
    "temp_max",
    "pressure",
    "humidity"
})
public class Temperature {

    @JsonProperty("temp")
    private Float temp;
    @JsonProperty("feels_like")
    private Float feelisLike;
    @JsonProperty("temp_min")
    private Float tempMin;
    @JsonProperty("temp_max")
    private Float tempMax;
    @JsonProperty("pressure")
    private Float pressure;
    @JsonProperty("humidity")
    private Float himidity;

    @JsonProperty("temp")
    public Float getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Float temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public Float getFeelisLike() {
        return feelisLike;
    }

    @JsonProperty("feels_like")
    public void setFeelisLike(Float feelisLike) {
        this.feelisLike = feelisLike;
    }

    @JsonProperty("temp_min")
    public Float getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_min")
    public void setTempMin(Float tempMin) {
        this.tempMin = tempMin;
    }

    @JsonProperty("temp_max")
    public Float getTempMax() {
        return tempMax;
    }

    @JsonProperty("temp_max")
    public void setTempMax(Float tempMax) {
        this.tempMax = tempMax;
    }

    @JsonProperty("pressure")
    public Float getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("humidity")
    public Float getHimidity() {
        return himidity;
    }

    @JsonProperty("humidity")
    public void setHimidity(Float himidity) {
        this.himidity = himidity;
    }
}
