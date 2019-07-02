package com.aurora.news.aggregator.article.mapper;

import com.aurora.news.aggregator.article.newsapi.NewsApiArticle;
import com.aurora.news.aggregator.article.verum.VerumArticle;


public class NewsApiToVerumMapper {

    public VerumArticle fromNewsApiToVerumArticle(NewsApiArticle newsApiArticle) {
        return new VerumArticle();
    }

}
