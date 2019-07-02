package com.aurora.news.aggregator.collector.newsapi;

import com.aurora.news.aggregator.article.newsapi.NewsApiArticle;
import com.aurora.news.aggregator.collector.Collector;
import com.aurora.news.aggregator.restclient.RestClient;
import com.aurora.news.aggregator.restclient.newsapi.NewsApiResponse;
import com.aurora.news.aggregator.urlgenerator.UrlGenerator;
import com.aurora.news.aggregator.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
public class NewsApiCollector implements Collector<NewsApiArticle> {

    private final UrlGenerator newsApiUrlGenerator;
    private final RestClient<NewsApiResponse> newsApiRestClient;
    private final ArticleValidator<NewsApiArticle> newsApiArticleValidator;

    public NewsApiCollector(UrlGenerator newsApiUrlGenerator,
                            RestClient<NewsApiResponse> newsApiRestClient,
                            ArticleValidator<NewsApiArticle> newsApiArticleValidator) {
        this.newsApiUrlGenerator = newsApiUrlGenerator;
        this.newsApiRestClient = newsApiRestClient;
        this.newsApiArticleValidator = newsApiArticleValidator;
    }

    @Override
    public List<NewsApiArticle> collect() {
        List<URL> urlList = newsApiUrlGenerator.generate();
        List<NewsApiArticle> newsApiArticles = new ArrayList<>();

        for (URL url : urlList) {
            Optional<NewsApiResponse> newsApiOkResponseOptional = newsApiRestClient.get(url);
            newsApiOkResponseOptional.ifPresent(
                    newsApiOkResponse -> newsApiArticles.addAll(
                            newsApiOkResponse.getArticles().stream()
                                    .filter(newsApiArticleValidator::isArticleRegular)
                                    .collect(Collectors.toList())));
        }

        return newsApiArticles;
    }

}
