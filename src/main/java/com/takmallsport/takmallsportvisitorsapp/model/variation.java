package com.takmallsport.takmallsportvisitorsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sahand on 4/20/18.
 */

public class variation {
    // Variation is an extra model
    @SerializedName("size_data")
    size size;
    @SerializedName("color_data")
    color color;
    @SerializedName("stock")
    boolean stock;

    public variation(com.takmallsport.takmallsportvisitorsapp.model.size size, com.takmallsport.takmallsportvisitorsapp.model.color color, boolean stock) {
        this.size = size;
        this.color = color;
        this.stock = stock;
    }

    public com.takmallsport.takmallsportvisitorsapp.model.size getSize() {
        return size;
    }

    public com.takmallsport.takmallsportvisitorsapp.model.color getColor() {
        return color;
    }


    public boolean isStock() {
        return stock;
    }


    public void setSize(com.takmallsport.takmallsportvisitorsapp.model.size size) {
        this.size = size;
    }

    public void setColor(com.takmallsport.takmallsportvisitorsapp.model.color color) {
        this.color = color;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }



}
