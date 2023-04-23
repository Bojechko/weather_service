package com.example.nanay.controller;

import com.example.nanay.weather.WeatherAPI;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Date;

import static java.lang.String.valueOf;

@RestController
@RequestMapping("v1")
public class MessageController {

    @PutMapping("/redis/{city}")
    public void putToRedis(@PathVariable String city) throws IOException {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set(city, String.valueOf(WeatherAPI.collectTemp(city) - 273.15));
        jedis.close();
    }

    @GetMapping("/redis/{city}")
    public String getFromRedis(@PathVariable String city) {
        Jedis jedis = new Jedis("localhost", 6379);
        String cachedResponse = jedis.get(city);
        jedis.close();
        return cachedResponse;
    }

    @GetMapping("current/{city}")
    public String currentWeather(@PathVariable String city) throws IOException {
        double celsius = WeatherAPI.collectTemp(city) - 273.15;

        JSONObject json = new JSONObject();

        json.put("city", city);
        json.put("unit", "celsius");
        json.put("temperature", valueOf((int)celsius));

        System.out.println("for log in compose");

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
