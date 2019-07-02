package com.aurora.news.aggregator.restclient.newsapi;

import com.aurora.news.aggregator.restclient.ResponseReader;
import com.aurora.news.aggregator.restclient.RestClient;
import com.aurora.news.properties.PropertyException;
import com.aurora.news.properties.PropertyReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Optional;


@Slf4j
public class NewsApiRestClient implements RestClient<NewsApiResponse> {

    @Override
    public Optional<NewsApiResponse> get(URL url) {
        Optional<NewsApiResponse> newsApiResponseOptional = Optional.empty();
        HttpURLConnection httpURLConnection = null;

        try {
            PropertyReader propertyReader = new PropertyReader();
            String apiKey = propertyReader.GetProperty("newsApi.properties", "api_key");

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("X-Api-Key", apiKey);
            httpURLConnection.setRequestProperty("Accept", "application/json");

            int responseCode = httpURLConnection.getResponseCode();

            switch (responseCode) {
                case 200:
                    newsApiResponseOptional = parseOkResponse(url, httpURLConnection);
                    break;

                default:
                    parseErrorResponse(url, httpURLConnection, responseCode);
            }
        } catch (PropertyException propertyException) {
            log.error("Can't read property file");
            propertyException.printStackTrace();
        } catch (ProtocolException protocolException) {
            log.warn("Can't set GET method - url: " + url);
            protocolException.printStackTrace();
        } catch (IOException ioException) {
            log.warn("Can't establish connection - url: " + url);
            ioException.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }

        return newsApiResponseOptional;
    }

    private Optional<NewsApiResponse> parseOkResponse(URL url, HttpURLConnection httpURLConnection) {
        Optional<NewsApiResponse> newsApiResponseOptional = Optional.empty();
        try {
            String jsonStr = ResponseReader.read(httpURLConnection.getInputStream());
            newsApiResponseOptional = Optional.of(new ObjectMapper().readValue(jsonStr, NewsApiResponse.class));
        } catch (IOException e) {
            log.warn("Error during response parsing - url: " + url);
            e.printStackTrace();
        }
        return newsApiResponseOptional;
    }

    private void parseErrorResponse(URL url, HttpURLConnection httpURLConnection, int responseCode) {
        try {
            String jsonStr = ResponseReader.read(httpURLConnection.getErrorStream());
            NewsApiErrorResponse newsApiErrorResponse = new ObjectMapper().readValue(jsonStr, NewsApiErrorResponse.class);
            log.warn("Error response - url: " + url);
            log.warn("Error code: " + newsApiErrorResponse.getCode());
            log.warn("Error message: " + newsApiErrorResponse.getMessage());
        } catch (IOException e) {
            log.warn("Error during response parsing - url: " + url);
            e.printStackTrace();
        }

    }

}
