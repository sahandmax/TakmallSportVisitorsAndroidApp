package com.takmallsport.takmallsportvisitorsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sahand on 4/9/18.
 */

public class color {
    public final static String TABLE_NAME = "color";

    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_ID = "name";
    @SerializedName("color_name")
    private String name;
    @SerializedName("color_id")
    private String id;
    public color(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
}
