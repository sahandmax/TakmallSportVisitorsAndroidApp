package com.takmallsport.takmallsportvisitorsapp.model;

/**
 * Created by sahand on 4/9/18.
 */

public class relations {
    public final static String TABLE_NAME = "relations";

    public final static String COLUMN_SKU = "sku";
    public final static String COLUMN_CODE = "code";
    public final static String COLUMN_SHOPNAME = "shopname";
    public final static String COLUMN_PRICE = "price";
    public final static String COLUMN_STOCK = "stock";

    private String sku;
    private String code;
    private String shopname;
    private String price;
    private String stock;

    public relations (String sku , String code , String shopname , String price , String stock) {
        this.sku = sku;
        this.code = code;
        this.shopname = shopname;
        this.price = price;
        this.stock = stock;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }


}
