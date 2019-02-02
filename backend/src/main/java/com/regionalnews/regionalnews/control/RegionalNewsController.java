package com.regionalnews.regionalnews.control;

import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.regionalnews.regionalnews.model.NewsModel;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionalNewsController {

    @GetMapping(value = "/news/{country}/{category}", produces = "application/json")
    public NewsModel getNews(@PathVariable String country, @PathVariable String category) throws IOException, URISyntaxException {

        URIBuilder uri = new URIBuilder()
                .setScheme("https")
                .setHost("newsapi.org")
                .setPath("v2/top-headlines")
                .addParameter("country", country)
                .addParameter("category", category)
                .addParameter("apiKey", "573ac286382040ffae3c074e6b1885b5");

        ObjectMapper mapper = new ObjectMapper();

        NewsModel newsModel = mapper.readValue(uri.build().toURL(), new TypeReference<NewsModel>() {});
        newsModel.setCategory(category);
        newsModel.setCountry(country);

        return newsModel;
    }
}