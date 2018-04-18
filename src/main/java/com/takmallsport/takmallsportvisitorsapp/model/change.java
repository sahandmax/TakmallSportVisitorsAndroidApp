package com.takmallsport.takmallsportvisitorsapp.model;

public class change {
    public final static String TABLE_NAME = "change";

    public final static String COLUMN_SKU = "sku";
    public final static String COLUMN_TYPE = "type";
    public final static String COLUMN_VALUE = "value";
    public final static String COLUMN_REPORT = "report";

    String sku;
    String type;
    String value;
    String report;

    public change(String sku, String type, String value, String report) {
        this.sku = sku;
        this.type = type;
        this.value = value;
        this.report = report;
    }

    public String getSku() {
        return sku;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public String getReport() {
        return report;
    }

}
