package com.aurora.news.aggregator.restclient.newsapi;

import com.aurora.news.aggregator.restclient.Response;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NewsApiErrorResponse extends Response {

    private String status;
    private String code;
    private String message;

}
