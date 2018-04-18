package com.takmallsport.takmallsportvisitorsapp.util.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.model.change;

import java.io.File;

public class VisitorDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = Environment.getExternalStorageDirectory() + File.separator + "/" + "change.db";
    private static final String DEFINE_TYPE_TEXT = " TEXT";
    public VisitorDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SqlQuery = "CREATE TABLE IF NOT EXISTS " + change.TABLE_NAME + " (" + change.COLUMN_SKU
                + DEFINE_TYPE_TEXT + "," + change.COLUMN_TYPE + DEFINE_TYPE_TEXT + "," +
                change.COLUMN_VALUE + DEFINE_TYPE_TEXT + "," + change.COLUMN_REPORT + DEFINE_TYPE_TEXT + ")";
        sqLiteDatabase.execSQL(SqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void InsertProductWithNoStock(String sku,Context context) {
        String SqlQuery = "INSERT INTO " + change.TABLE_NAME + " VALUES ('"+sku+"','product','no-stock','"+context.getString(R.string.change_sku_to_out_of_stock).replace("%SKU%",sku)+"')";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SqlQuery);
        db.close();
    }

//    public void InsertVariationWithNoStock(String sku,Context context) {
//
//        String SqlQuery = "INSERT INTO " + change.TABLE_NAME + " VALUES ('"+sku+"','variation','no-stock','"+context.getString(R.string.change_sku_to_out_of_stock).replace("%SKU%",sku)+"')";
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL(SqlQuery);
//        db.close();
//    }

}
