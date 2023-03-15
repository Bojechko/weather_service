package com.example.nanay.weather;

import com.example.nanay.utils.utils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class weatherAPI {

    public static Double collectTemp(String city) throws IOException {
        String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + utils.key);
        if (!output.isEmpty()) { // Нет ошибки и такой город есть
            JSONObject obj = new JSONObject(output);
            // Обрабатываем JSON и устанавливаем данные в текстовые надписи
            return obj.getJSONObject("main").getDouble("temp");
        }
        return 0.0;
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
