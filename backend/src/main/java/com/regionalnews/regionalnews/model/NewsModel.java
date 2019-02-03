package com.regionalnews.regionalnews.model;

import java.util.List;
import java.util.Optional;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsModel {

    private static final String ARTICLES = "articles";

    @JsonProperty(ARTICLES)
    private List<ArticleModel> articleModels;

    private Optional<String> country = Optional.empty();

    private Optional<String> category = Optional.empty();

    public List<ArticleModel> getArticleModels() {
        return articleModels;
    }

    public void setArticleModels(List<ArticleModel> articleModels) {
        this.articleModels = articleModels;
    }

    public Optional<String> getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = Optional.ofNullable(country);
    }

    public Optional<String> getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = Optional.ofNullable(category);
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "articleModels=" + articleModels +
                ", country=" + country +
                ", category=" + category +
                '}';
    }
}