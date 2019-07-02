package com.aurora.news.aggregator;

import com.aurora.news.aggregator.article.newsapi.NewsApiArticle;
import com.aurora.news.aggregator.collector.newsapi.NewsApiCollector;
import com.aurora.news.aggregator.restclient.newsapi.NewsApiRestClient;
import com.aurora.news.aggregator.urlgenerator.newsapi.NewsApiUrlGenerator;
import com.aurora.news.aggregator.validator.newsapi.NewsApiArticleValidator;

import java.util.List;


public class AggregatorTests {

    public static void main(String[] args) {
        List<NewsApiArticle> rasta = new NewsApiCollector(new NewsApiUrlGenerator(), new NewsApiRestClient(), new NewsApiArticleValidator()).collect();
        int s = 23;
    }

}
