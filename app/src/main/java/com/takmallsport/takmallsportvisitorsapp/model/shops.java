package com.takmallsport.takmallsportvisitorsapp.model;

/**
 * Created by sahand on 4/9/18.
 */

public class shops {

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
