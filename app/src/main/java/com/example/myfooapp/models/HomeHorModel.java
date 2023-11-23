package com.example.myfooapp.models;

public class HomeHorModel {

    int image;
    String name;
    String duration;
    String price;

    public HomeHorModel(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public HomeHorModel(int image, String name, String duration, String price) {
        this.image = image;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
