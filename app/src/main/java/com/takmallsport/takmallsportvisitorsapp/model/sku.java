package com.takmallsport.takmallsportvisitorsapp.model;

/**
 * Created by sahand on 4/9/18.
 */

public class sku {
    private String size_name;
    private String size_id;
    private String color_name;
    private String color_id;
    private String sku;

    public sku(String size_name, String size_id, String color_name, String color_id, String sku) {
        this.size_name = size_name;
        this.size_id = size_id;
        this.color_name = color_name;
        this.color_id = color_id;
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public String getSize_name() {
        return size_name;
    }

    public String getSize_id() {
        return size_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public String getColor_id() {
        return color_id;
    }
}
