package com.niaapplications.noccapp;


public class Discount {
    public    String businessID;
    public    String name;
    public    String description;
    public    String businessPhoto;


    public Discount(){

        this.name=name;
        this.description=description;
        this.businessID = businessID;

    }

    public String getBusinessPhoto(){ return businessPhoto;}

    public void setBusinessPhoto(String businessPhoto){this.businessPhoto = businessPhoto;}

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



}