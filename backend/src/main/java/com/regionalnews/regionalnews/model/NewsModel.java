package com.regionalnews.regionalnews.model;

import java.util.List;
import java.util.Optional;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsModel {

    @JsonProperty("articles")
    private List<SingleArticleModel> singleArticleModels;

    private Optional<String> country = Optional.empty();

    private Optional<String> category = Optional.empty();

    public List<SingleArticleModel> getSingleArticleModels() {
        return singleArticleModels;
    }
    public void setSingleArticleModels(List<SingleArticleModel> singleArticleModels) {
        this.singleArticleModels = singleArticleModels;
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
        ;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "singleArticleModels=" + singleArticleModels +
                ", country=" + country +
                ", category=" + category +
                '}';
    }
}