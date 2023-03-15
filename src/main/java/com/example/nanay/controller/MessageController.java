package com.example.nanay.controller;

import com.example.nanay.weather.weatherAPI;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static java.lang.String.valueOf;

@RestController
@RequestMapping("v1")
public class MessageController {
    @GetMapping("current/{city}")
    public String currentWeather(@PathVariable String city) throws IOException {
        double celsius = weatherAPI.collectTemp(city) - 273.15;

        JSONObject json = new JSONObject();

        json.put("city", city);
        json.put("unit", "celsius");
        json.put("temperature", valueOf((int)celsius));

        return json.toString();
    }

    @GetMapping("forecast/{city}")
    public String timestampWeather(@PathVariable String city, @PathVariable int timestamp) throws IOException {
        double celsius = weatherAPI.collectTemp(city) - 273.15;

        JSONObject json = new JSONObject();

        json.put("city", city);
        json.put("unit", "celsius");
        json.put("temperature", valueOf((int)celsius));

        return json.toString();
    }
}
