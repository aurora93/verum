package com.aurora.news.aggregator.urlgenerator.newsapi;

import com.aurora.news.aggregator.urlgenerator.UrlGenerator;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
public class NewsApiUrlGenerator implements UrlGenerator {

    private List<String> urlStrList = Arrays.asList("https://newsapi.org/v2/top-headlines?category=business");

    @Override
    public List<URL> generate() {
        List<URL> urlList = new ArrayList<>();

        for (String strUrl : urlStrList) {
            try {
                urlList.add(new URL(strUrl));
            } catch (MalformedURLException e) {
                e.printStackTrace();
                log.warn("Wrong URL format" + e.getMessage());
            }
        }

        return urlList;
    }
}
