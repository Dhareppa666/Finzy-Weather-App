package com.finzy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Document(collection = "employee")
public class WeatherModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
