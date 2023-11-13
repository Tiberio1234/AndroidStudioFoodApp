package com.example.myfooapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailedDailyModel {

    int image;
    String name;
    String description;
    String rating;
    String price;
    String timing;
    String type;

    public DetailedDailyModel(int image, String name, String description, String rating, String price, String timing) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.timing = timing;
    }


    public DetailedDailyModel(ResultSet resultSet) throws SQLException {
        this.image = resultSet.getInt("id");
        this.name = resultSet.getString("name");
        this.description = resultSet.getString("description");
        this.rating = resultSet.getString("rating");
        this.price = resultSet.getString("price");
        this.timing = resultSet.getString("timing");
        this.type = resultSet.getString("type");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
