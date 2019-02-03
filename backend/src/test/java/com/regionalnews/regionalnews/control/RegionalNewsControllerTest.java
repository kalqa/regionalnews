package com.regionalnews.regionalnews.control;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.regionalnews.regionalnews.model.NewsModel;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;

public class RegionalNewsControllerTest {

    RegionalNewsService regionalNewsService = new RegionalNewsService();

    @Test
    public void isBuildingCorrectUri() throws URISyntaxException, MalformedURLException {
        URIBuilder uri = new URIBuilder()
                .setPath("https://newsapi.org/v2/top-headlines")
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