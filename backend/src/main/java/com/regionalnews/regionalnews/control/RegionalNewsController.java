package com.regionalnews.regionalnews.control;

import javax.ws.rs.core.MediaType;

import com.regionalnews.regionalnews.model.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RegionalNewsController {

    private static final String GET_NEWS_PATH = "/news/{country}/{category}";

    @Autowired
    RegionalNewsService regionalNewsService;

    @GetMapping(value = GET_NEWS_PATH, produces = MediaType.APPLICATION_JSON)
    public NewsModel getNews(@PathVariable String country, @PathVariable String category) {
        return regionalNewsService.getNews(country, category);
    }
}