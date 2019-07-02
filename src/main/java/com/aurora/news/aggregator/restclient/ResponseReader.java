package com.aurora.news.aggregator.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ResponseReader {

    public static String read(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
        StringBuilder stringBuilder = new StringBuilder();
        int cp;
        while ((cp = bufferedReader.read()) != -1) {
            stringBuilder.append((char) cp);
        }
        return stringBuilder.toString();
    }

}
