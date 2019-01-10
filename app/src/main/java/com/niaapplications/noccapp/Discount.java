package com.niaapplications.noccapp;


public class Discount {
    public    String businessID;
    public    String name;
    public    String description;
    public    String businessPhoto;
    // public String webURL;


    public Discount(){
        }


    public Discount(String name, String description, String businessID /*String webURL*/){

        this.name=name;
        this.description=description;
        this.businessID = businessID;
        // this.webURL = webURL;

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
/* For when DB is updated, just uncomment
*   public String getWebURL(){
*
*   return webURL;
*   }
*
* public void setWebURL(String webURL){
* this.webURL = webURL;
* }
*
* */


}