package com.aurora.news.aggregator.validator.newsapi;

import com.aurora.news.aggregator.article.newsapi.NewsApiArticle;
import com.aurora.news.aggregator.validator.ArticleValidator;


public class NewsApiArticleValidator implements ArticleValidator<NewsApiArticle> {

    @Override
    public boolean isArticleRegular(NewsApiArticle newsApiArticle) {
        boolean result = true;
        if (newsApiArticle.getSource().getName() == null ||
                newsApiArticle.getTitle() == null ||
                newsApiArticle.getDescription() == null ||
                newsApiArticle.getUrl() == null ||
                newsApiArticle.getPublishedAt() == null
                ) {
            result = false;
        }

        return result;
    }

}
