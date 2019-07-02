package com.aurora.news.aggregator.restclient.newsapi;

import com.aurora.news.aggregator.article.newsapi.NewsApiArticle;
import com.aurora.news.aggregator.restclient.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class NewsApiResponse extends Response {

    private String status;
    private Integer totalResults;
    private List<NewsApiArticle> articles;
}
