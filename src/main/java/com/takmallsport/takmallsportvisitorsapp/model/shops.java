package com.takmallsport.takmallsportvisitorsapp.model;

import java.io.Serializable;

/**
 * Created by sahand on 4/9/18.
 */

public class shops implements Serializable {
    public final static String TABLE_NAME = "shops";

    public final static String COLUMN_ADDRESS = "address";
    public final static String COLUMN_TELEPHONE = "telephone";
    public final static String COLUMN_NAME = "name";

    private String address;
    private String telephone;
    private String name;

    public shops(String address, String telephone, String name) {
        this.address = address;
        this.telephone = telephone;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

}
