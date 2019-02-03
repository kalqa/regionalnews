package com.regionalnews.regionalnews.control;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.regionalnews.regionalnews.model.NewsModel;
import com.regionalnews.regionalnews.model.NewsModelBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("RegionalNewsService")
public class RegionalNewsService {

    private static final String COUNTRY = "country";
    private static final String CATEGORY = "category";
    private static final String HTTPS = "https";
    private static final String NEWSAPI_ORG = "newsapi.org";
    private static final String V_2_TOP_HEADLINES = "v2/top-headlines";
    private static final String COULD_NOT_MAP_ERROR = "Could not map json to model";
    private static final String API_KEY = "apiKey";
    private static final String API_KEY_VALUE = "573ac286382040ffae3c074e6b1885b5"; // could be hidden in headers

    private static final Logger LOGGER = LoggerFactory.getLogger(RegionalNewsController.class);

    public NewsModel getNews(String country, String category) {
        URIBuilder uri = buildUri(country, category);
        NewsModel newsModel = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            newsModel = mapper.readValue(uri.build().toURL(), new TypeReference<NewsModel>() {});
            newsModel.setCategory(category);
            newsModel.setCountry(country);
        } catch (Exception e) {
            LOGGER.error(COULD_NOT_MAP_ERROR, e);
        }

        if (newsModel != null) {
            return newsModel;
        }

        return NewsModelBuilder.builder()
                .withCategory(category)
                .withCountry(country)
                .build();
    }

    private URIBuilder buildUri(String country, String category) {
        return new URIBuilder()
                .setScheme(HTTPS)
                .setHost(NEWSAPI_ORG)
                .setPath(V_2_TOP_HEADLINES)
                .addParameter(COUNTRY, country)
                .addParameter(CATEGORY, category)
                .addParameter(API_KEY, API_KEY_VALUE);
    }
}
