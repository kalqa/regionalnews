package com.regionalnews.regionalnews.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleModel {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String AUTHOR = "author";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String SOURCE = "source";
    private static final String DATE = "date";
    private static final String PUBLISHED_AT = "publishedAt";
    private static final String ARTICLE_URL = "articleUrl";
    private static final String URL = "url";
    private static final String IMAGE_URL = "imageUrl";
    private static final String URL_TO_IMAGE = "urlToImage";

    @JsonProperty(AUTHOR)
    private String author;

    @JsonProperty(TITLE)
    private String title;

    @JsonProperty(DESCRIPTION)
    private String description;

    private String date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;

    @JsonProperty(SOURCE)
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

    @JsonProperty(value = DATE, access = Access.READ_ONLY)
    public String getDate() throws ParseException {
        return formatDate(date);
    }

    @JsonProperty(value = PUBLISHED_AT, access = JsonProperty.Access.WRITE_ONLY)
    public void setDate(String date) {
        this.date = date;
    }

    private String formatDate(String date) throws ParseException {
        Date dateFormat = new SimpleDateFormat(DATE_FORMAT).parse(date);
        DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(dateFormat);
    }

    @JsonProperty(value = ARTICLE_URL, access = Access.READ_ONLY)
    public String getArticleUrl() {
        return articleUrl;
    }

    @JsonProperty(value = URL, access = JsonProperty.Access.WRITE_ONLY)
    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    @JsonProperty(value = IMAGE_URL, access = Access.READ_ONLY)
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty(value = URL_TO_IMAGE, access = JsonProperty.Access.WRITE_ONLY)
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
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
