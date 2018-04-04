package com.serhatozdal.scraper.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author msozdal
 */
public class Url {

    public String fetchHtml(String htmlUrl) {
        StringBuffer html = new StringBuffer();

        try {
            URL url = new URL(htmlUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/64.0.3282.167 Chrome/64.0.3282.167 Safari/537.36";
            connection.setRequestProperty("User-Agent", userAgent);
            connection.setRequestProperty("Accept-Language", "tr-TR,en-US");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        html.append(line.trim());
                    }

                }

            }

            connection.disconnect();

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return html.toString();
    }

}
