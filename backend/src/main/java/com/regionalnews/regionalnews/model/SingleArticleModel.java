package com.regionalnews.regionalnews.model;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleArticleModel {

    @JsonProperty("author")
    private String author;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    private String date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;

    @JsonProperty("source")
    private void getSourceName(Map<String, String> brand) {
        this.sourceName = brand.get("name");
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

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

    @JsonProperty(value = "date", access = Access.READ_ONLY)
    public String getDate() {
        return date;
    }

    @JsonProperty(value = "publishedAt", access = JsonProperty.Access.WRITE_ONLY)
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty(value = "articleUrl", access = Access.READ_ONLY)
    public String getArticleUrl() {
        return articleUrl;
    }

    @JsonProperty(value = "url", access = JsonProperty.Access.WRITE_ONLY)
    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    @JsonProperty(value = "imageUrl", access = Access.READ_ONLY)
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty(value = "urlToImage", access = JsonProperty.Access.WRITE_ONLY)
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "SingleArticleModel{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
