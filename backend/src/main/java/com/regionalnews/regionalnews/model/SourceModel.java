package com.regionalnews.regionalnews.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceModel {

    @JsonProperty("name")
    private String sourceName;

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @Override
    public String toString() {
        return "SourceModel{" +
                "sourceName='" + sourceName + '\'' +
                '}';
    }
}