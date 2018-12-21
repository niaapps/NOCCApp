package com.niaapplications.noccapp;



public class Event {
    public    String location;
    public    String name;
    public    String description;
    public    String pictureURL;
    public    String webURL;


    public Event(){

        this.name=name;
        this.description=description;
        this.location = location;
        this.pictureURL = pictureURL;
        this.webURL= webURL;

    }

    public String getLocation(){ return location;}

    public void setLocation(String businessPhoto){this.location = location;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }
}
