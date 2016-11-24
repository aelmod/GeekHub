package com.github.aelmod.geekhub.homework5.task2;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by aelmod-notebook on 24.11.2016.
 */

public class Translator {
    final static String YT_API_KEY = "trnsl.1.1.20161121T181914Z.d351ea37544769c1.dae9472f644e06b7b062ddb52113c29be0193179";

    public void translate(String text) throws Exception {
        URL url = new URL("https://translate.yandex.net/api/v1.5/tr/translate?");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Content-Type", " application/x-www-form-urlencoded");

        String urlParameters = "key=" + YT_API_KEY + "&text=" + text + "&lang=en-ru";

        httpsURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(urlParameters);
        dataOutputStream.flush();
        dataOutputStream.close();

        int responseCode = httpsURLConnection.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpsURLConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        if (responseCode != 200) {
            throw new Exception("Error from Yandex: " + response);
        }
        System.out.println("Original text: " + text);
        XMLParser.parse(response.toString());
    }
}
