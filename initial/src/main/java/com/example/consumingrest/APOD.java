package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APOD {

    private String date;
    private String explanation;
    private String hdurl;
    private String title;

    public APOD() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        String output = "";

        output =
                "Title: " + this.getTitle() + "\n" +
                "Date: " + this.getDate() + "\n" +
                "Explanation: " + this.getExplanation() + "\n" +
                "HD URL: " + this.getHdurl();

        return output;
    }
}
