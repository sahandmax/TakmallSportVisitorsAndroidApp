package com.takmallsport.takmallsportvisitorsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sahand on 4/9/18.
 */

public class size {
    public final static String TABLE_NAME = "size";

    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_ID = "id";
    @SerializedName("size_name")
    private String name;
    @SerializedName("size_id")
    private String id;

    public size(String name, String id) {
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
