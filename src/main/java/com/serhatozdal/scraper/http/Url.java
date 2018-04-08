package com.serhatozdal.scraper.http;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Base64;

/**
 * @author serhatozdal
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

        public String downloadFileAsBase64(String fileUrl) {
        String base64File = null;
        try {
            URL url = new URL(fileUrl);

            // download file as bytes
            BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
            ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            WritableByteChannel writableByteChannel = Channels.newChannel(outputStream);
            ByteBuffer byteBuffer = ByteBuffer.allocate(32000);
            while (readableByteChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                writableByteChannel.write(byteBuffer);
                byteBuffer.clear();
            }
            base64File = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return base64File;
    }
}
