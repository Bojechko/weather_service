package com.example.nanay.weather;

import com.example.nanay.utils.Utils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class WeatherAPI {

    public static Double collectTemp(String city) throws IOException {
        String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + Utils.key);
        if (!output.isEmpty()) {
            JSONObject obj = new JSONObject(output);

            return obj.getJSONObject("main").getDouble("temp");
        }
        return -290.0;
    }

    public static Double collectTemp(String city, long timestamp) throws IOException {
        double lat = collectLatLon(city).get(0);
        double lon = collectLatLon(city).get(1);
        String output = getUrlContent("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat
                + "&lon=" + lon
                + "&appid=" + Utils.key);
        if (!output.isEmpty()) {
            JSONObject obj = new JSONObject(output);

            JSONArray arr = obj.getJSONArray("list");

            for (int i = 0; i < arr.length(); i++)
            {
                int dt = arr.getJSONObject(i).getInt("dt");
                if (dt == timestamp){
                    return arr.getJSONObject(i).getJSONObject("main").getDouble("temp");
                }
            }
        }
        return -290.0;
    }

    private static List<Double> collectLatLon(String city) throws IOException {
        List<Double> latLon = new ArrayList<Double>() ;
        String output = getUrlContent("http://api.openweathermap.org/geo/1.0/direct?q=" + city + "&limit=1&appid=" + Utils.key);
        if (!output.isEmpty()) {

            JSONArray jsonArray = new JSONArray(output);
            latLon.add(jsonArray.getJSONObject(0).getDouble("lat"));
            latLon.add(jsonArray.getJSONObject(0).getDouble("lon"));
            return latLon;
        }
        return latLon;
    }

    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            System.out.println("Такой город был не найден!");
        }
        return content.toString();
    }

    private String getAuthHeader(String requestUrl) {
        return null;
    }

}
