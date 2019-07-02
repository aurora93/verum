package com.aurora.news.aggregator.article.verum;

import com.aurora.news.aggregator.article.Article;

import java.net.URL;
import java.util.Date;


public class VerumArticle extends Article {

    private Long id;
    private String author;      //optional
    private String source;
    private String title;
    private String description;
    private URL url;
    private URL urlToImage;     //optional
    private Date publishedAt;

}
