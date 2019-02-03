package com.regionalnews.regionalnews.control;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.regionalnews.regionalnews.model.NewsModel;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegionalNewsControllerTest {

    private static final String HTTPS = "https";
    private static final String NEWSAPI_ORG = "newsapi.org";
    private static final String V_2_TOP_HEADLINES = "v2/top-headlines";

    RegionalNewsService regionalNewsService = new RegionalNewsService();

    @Test
    public void isBuildingCorrectUri() throws URISyntaxException, MalformedURLException {
        URIBuilder uri = new URIBuilder()
                .setScheme(HTTPS)
                .setHost(NEWSAPI_ORG)
                .setPath(V_2_TOP_HEADLINES)
                .addParameter("country", "pl")
                .addParameter("category", "technology");

        assertEquals("https://newsapi.org/v2/top-headlines?country=pl&category=technology", uri.build().toURL().toString());
    }

    @Test
    public void buildsCorrectUri() {
        NewsModel news = regionalNewsService.getNews("pl", "technology");

        assertEquals("technology", news.getCategory().get());
        assertEquals("pl", news.getCountry().get());
    }
}