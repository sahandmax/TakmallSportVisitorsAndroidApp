package com.takmallsport.takmallsportvisitorsapp.model;

/**
 * Created by sahand on 4/9/18.
 */

public class color {
    public final static String TABLE_NAME = "color";

    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_ID = "name";
    private String name;
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
