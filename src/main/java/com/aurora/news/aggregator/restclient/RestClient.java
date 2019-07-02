package com.aurora.news.aggregator.restclient;

import java.net.URL;
import java.util.Optional;


public interface RestClient<T extends Response> {

    Optional<T> get(URL url);

}
