package com.example.nanay.controller;

import com.example.nanay.gRPCClient.GRPCClient;
import com.example.nanay.weather.WeatherAPI;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

import static java.lang.String.valueOf;

@RestController
@RequestMapping("v1")
public class MessageController {
    @GetMapping("current/{login}/{city}")
    public String currentWeather(@PathVariable String login, @PathVariable String city) throws IOException, InterruptedException {
        if(!GRPCClient.makeRequest(login)) {
            return "Неверный логин";
        }

        double celsius = WeatherAPI.collectTemp(city) - 273.15;

        JSONObject json = new JSONObject();

        json.put("city", city);
        json.put("unit", "celsius");
        json.put("temperature", valueOf((int)celsius));

        if (celsius == -563.15){
            return "Неверный город";
        }
        return json.toString();
    }

    @GetMapping("forecast/{city}/{date}")
    public String timestampWeather(@PathVariable String city, @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws IOException {

        long timestamp = date.getTime() / 1000;
        double celsius = WeatherAPI.collectTemp(city, timestamp) - 273.15;

        JSONObject json = new JSONObject();

        json.put("city", city);
        json.put("unit", "celsius");
        json.put("temperature", valueOf((int)celsius));

        if (celsius == -563.15){
            return "Неверный город или дата";
        }
        return json.toString();
    }
}
