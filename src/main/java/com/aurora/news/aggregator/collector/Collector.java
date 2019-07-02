package com.aurora.news.aggregator.collector;

import com.aurora.news.aggregator.article.Article;

import java.util.List;


public interface Collector<T extends Article> {

    List<T> collect();
}
