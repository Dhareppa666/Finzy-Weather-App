package com.finzy.repository;

import com.finzy.model.weather.WeatherResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends MongoRepository<WeatherResponse, String> {
}
