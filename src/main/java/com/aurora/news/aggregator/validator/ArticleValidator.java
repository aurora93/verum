package com.aurora.news.aggregator.validator;

import com.aurora.news.aggregator.article.Article;


public interface ArticleValidator<T extends Article> {

    boolean isArticleRegular(T article);
}
