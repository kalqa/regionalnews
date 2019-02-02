package com.regionalnews.regionalnews.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleArticleModel {

    @JsonProperty("author")
    private String author;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("publishedAt")
    private String date;

    private String sourceName;

    @JsonIgnore
    private SourceModel sourceModel;

    @JsonProperty("url")
    private String articleUrl;

    @JsonProperty("urlToImage")
    private String imageUrl;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonGetter("sourceName")
    protected String getSourceName() {
        if (sourceModel != null) {
            sourceName = sourceModel.getSourceName();
        }
        return sourceName;
    }

    @JsonSetter("sourceName")
    protected void setSourceName(String sourceName) {
        if (sourceName != null) {
            sourceModel = new SourceModel();
            sourceModel.setSourceName(sourceName);
        }
        this.sourceName = sourceName;
    }
    public SourceModel getSourceModel() {
        return sourceModel;
    }
    public void setSourceModel(SourceModel sourceModel) {
        this.sourceModel = sourceModel;
    }
}
