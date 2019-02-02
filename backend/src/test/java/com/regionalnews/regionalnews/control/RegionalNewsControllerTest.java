package com.regionalnews.regionalnews.control;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;

public class RegionalNewsControllerTest {

    @Test
    public void getNews() throws URISyntaxException, MalformedURLException {
        /*UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https").host("newsapi.org").path("v2/top-headlines").
                        queryParam("country", "pl").
                        queryParam("category", "technology").
                        build();
*/
        URIBuilder uri = new URIBuilder()
                .setPath("https://newsapi.org/v2/top-headlines")
                .addParameter("country", "pl")
                .addParameter("category", "technology");

        assertEquals("https://newsapi.org/v2/top-headlines?country=pl&category=technology", uri.build().toURL().toString());
    }
}