package com.example.niwesh.walmartapplication;

/**
 * Created by Niwesh on 4/7/2018.
 */

public class Product {

        String Title;
        double price;
        String color;
        String image;
        String itemid;
        String desc;  // Description of the product

    public Product(String title, double price, String color, String image, String itemid, String desc) {
        Title = title;
        this.price = price;
        this.color = color;
        this.image = image;
        this.itemid = itemid;
        this.desc = desc;
    }

    public String getTitle() {
        return Title;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getImage() {
        return image;
    }

    public String getItemid() {
        return itemid;
    }

    public String getDesc() {
        return desc;
    }
}
