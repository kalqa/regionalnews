package com.regionalnews.regionalnews.model;

import java.util.List;
import java.util.Optional;

public final class NewsModelBuilder {

    private List<ArticleModel> articleModels;
    private Optional<String> country = Optional.empty();
    private Optional<String> category = Optional.empty();

    private NewsModelBuilder() {
    }

    public static NewsModelBuilder builder() {
        return new NewsModelBuilder();
    }

    public NewsModelBuilder withArticleModels(List<ArticleModel> articleModels) {
        this.articleModels = articleModels;
        return this;
    }

    public NewsModelBuilder withCountry(String country) {
        this.country = Optional.ofNullable(country);
        return this;
    }
    public NewsModelBuilder withCategory(String category) {
        this.category = Optional.ofNullable(category);
        return this;
    }

    public NewsModel build() {
        NewsModel newsModel = new NewsModel();
        newsModel.setArticleModels(articleModels);
        newsModel.setCountry(country.get());
        newsModel.setCategory(category.get());
        return newsModel;
    }
}
