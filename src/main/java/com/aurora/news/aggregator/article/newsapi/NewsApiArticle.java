package com.aurora.news.aggregator.article.newsapi;

import com.aurora.news.aggregator.article.Article;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class NewsApiArticle extends Article {

    private String author;          //optional
    private NewsApiSource source;
    private String title;
    private String description;
    private String url;
    private String urlToImage;          //optional
    private Date publishedAt;
    private String content;

    @Getter
    @Setter
    public class NewsApiSource {

        private String id;          //optional
        private String name;
    }

}
