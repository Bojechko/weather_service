package com.example.nanay.controller;

import com.example.nanay.weather.WeatherAPI;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisClusterCommands;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.valueOf;

@RestController
@RequestMapping("v1")
public class MessageController {

    @PutMapping("/redis/{city}")
    public void putToRedis(@PathVariable String city) throws IOException {
       /* Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("localhost", 6373));
        nodes.add(new HostAndPort("localhost", 6374));
        nodes.add(new HostAndPort("localhost", 6375));
        nodes.add(new HostAndPort("localhost", 6376));
        nodes.add(new HostAndPort("localhost", 6377));
        nodes.add(new HostAndPort("localhost", 6378));

        JedisCluster jedis = new JedisCluster(nodes);
        jedis.set(city, String.valueOf(WeatherAPI.collectTemp(city) - 273.15));
        jedis.close();*/
        RedisClusterClient redisClient = RedisClusterClient.create("redis://173.20.0.31:6373");
        ClusterTopologyRefreshOptions topologyRefreshOptions = ClusterTopologyRefreshOptions.builder()
                .enableAllAdaptiveRefreshTriggers()
                .build();

        redisClient.setOptions(ClusterClientOptions.builder()
                .topologyRefreshOptions(topologyRefreshOptions)
                .build());

        StatefulRedisClusterConnection<String, String> connection = redisClient.connect();

        RedisClusterCommands<String, String> syncCommands = connection.sync();

        syncCommands.set(city, String.valueOf(WeatherAPI.collectTemp(city) - 273.15));

        connection.close();
    }

    @GetMapping("/redis/{city}")
    public String getFromRedis(@PathVariable String city) throws IOException {
       /* /Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("localhost", 6373));
        nodes.add(new HostAndPort("173.20.0.32", 6374));
        nodes.add(new HostAndPort("173.20.0.33", 6375));
        nodes.add(new HostAndPort("173.20.0.34", 6376));
        nodes.add(new HostAndPort("173.20.0.35", 6377));
        nodes.add(new HostAndPort("173.20.0.36", 6378));

        JedisCluster jedis = new JedisCluster(nodes);

        String cachedResponse = jedis.get(city);
        jedis.close();*/

        RedisClusterClient redisClient = RedisClusterClient.create("redis://173.20.0.31:6373");

        ClusterTopologyRefreshOptions topologyRefreshOptions = ClusterTopologyRefreshOptions.builder()
                .enableAllAdaptiveRefreshTriggers()
                .build();

        redisClient.setOptions(ClusterClientOptions.builder()
                .topologyRefreshOptions(topologyRefreshOptions)
                .build());
        
        StatefulRedisClusterConnection<String, String> connection = redisClient.connect();

        RedisClusterCommands<String, String> syncCommands = connection.sync();

        String cachedResponse = syncCommands.get(city);

        connection.close();

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
