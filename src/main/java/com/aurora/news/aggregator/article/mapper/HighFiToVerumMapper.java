package com.aurora.news.aggregator.article.mapper;

import com.aurora.news.aggregator.article.highfi.HighFiArticle;
import com.aurora.news.aggregator.article.verum.VerumArticle;


public class HighFiToVerumMapper {

    public VerumArticle fromHighFiToVerumArticle(HighFiArticle highFiArticle) {
        return new VerumArticle();
    }

}
