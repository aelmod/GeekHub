package com.github.aelmod.geekhub.homework5.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aelmod-notebook on 24.11.2016.
 */
public class GetTextFromExample {
    public static String getText() throws Exception {
        URL url = new URL("https://gist.githubusercontent.com/pistriak/3c42490bbe2de0dd7934a98d3f09514d/raw/9c2f2155ec3c5b47325bd974f2f3b7567f478afd/example.txt");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            System.out.println("Some error with gist.githubusercontent.com" + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        bufferedReader.close();
        return response.toString();
    }
}
