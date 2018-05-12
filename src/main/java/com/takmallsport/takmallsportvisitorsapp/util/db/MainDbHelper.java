package com.takmallsport.takmallsportvisitorsapp.util.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import com.takmallsport.takmallsportvisitorsapp.model.relations;
import com.takmallsport.takmallsportvisitorsapp.model.shops;
import com.takmallsport.takmallsportvisitorsapp.model.color;
import com.takmallsport.takmallsportvisitorsapp.model.size;
import com.takmallsport.takmallsportvisitorsapp.model.sku;
import com.takmallsport.takmallsportvisitorsapp.model.variation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sahand on 4/9/18.
 */

public class MainDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = Environment.getExternalStorageDirectory() + File.separator + "/" + "data.db";

    public MainDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<shops> getShopList() {
        ArrayList<shops> shops = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + com.takmallsport.takmallsportvisitorsapp.model.shops.TABLE_NAME ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                shops shop = new shops(cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.shops.COLUMN_ADDRESS)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.shops.COLUMN_TELEPHONE)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.shops.COLUMN_NAME)));
                shops.add(shop);
            } while (cursor.moveToNext());
        }
        db.close();
        return shops;
    }

    public shops getShopFromRelation(relations relation) {
        String selectQuery = "SELECT * FROM " + com.takmallsport.takmallsportvisitorsapp.model.shops.TABLE_NAME
                + " WHERE " +shops.COLUMN_NAME +" = '"+relation.getShopname()+"' ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
                shops shop = new shops(cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.shops.COLUMN_ADDRESS)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.shops.COLUMN_TELEPHONE)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.shops.COLUMN_NAME)));

        db.close();
        return shop;
    }

    public ArrayList<relations> getRelationsFromShop (shops shop) {
        ArrayList<relations> relations = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + com.takmallsport.takmallsportvisitorsapp.model.relations.TABLE_NAME +
                " WHERE " + com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_SHOPNAME + " = '" +
                shop.getName() + "' AND " + com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_STOCK
                + " = 'true'";
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                com.takmallsport.takmallsportvisitorsapp.model.relations relation = new relations(
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_SKU)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_CODE)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_SHOPNAME)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_PRICE)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_STOCK))
                );
                relations.add(relation);
            } while (cursor.moveToNext());
        }
        db.close();
        return relations;
    }
    public ArrayList<variation> getVariationList (relations relation) {
        ArrayList<variation> variations = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + sku.TABLE_NAME + " WHERE " +
                sku.COLUMN_SKU + " = '" + relation.getSku() + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                color color = new color(cursor.getString(cursor.getColumnIndex(sku.COLUMN_COLOR_NAME)),
                        cursor.getString(cursor.getColumnIndex(sku.COLUMN_COLOR_ID)));
                size size = new size(cursor.getString(cursor.getColumnIndex(sku.COLUMN_SIZE_NAME)),
                        cursor.getString(cursor.getColumnIndex(sku.COLUMN_SIZE_ID)));

                variation variation = new variation(size,color,true);
                variations.add(variation);
            } while (cursor.moveToNext());
        }
        db.close();
        return variations;
    }

    public void DeleteVariation(String input_sku , variation variation) {
        String query = "DELETE FROM "+ sku.TABLE_NAME +" WHERE " + sku.COLUMN_SKU + " = '"
                +input_sku+"' " + sku.COLUMN_COLOR_ID + " = '"+variation.getColor().getId()+"' "
                + sku.COLUMN_SIZE_ID + " = '"+variation.getSize().getId()+"' ";

        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery(query,null);


        db.close();
    }

    public relations getRelationBySKU(String sku) {
        ArrayList<relations> relations = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + com.takmallsport.takmallsportvisitorsapp.model.relations.TABLE_NAME +
                " WHERE " + com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_SKU + " = '" +
                sku + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
                return new relations(
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_SKU)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_CODE)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_SHOPNAME)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_PRICE)),
                        cursor.getString(cursor.getColumnIndex(com.takmallsport.takmallsportvisitorsapp.model.relations.COLUMN_STOCK)));
        return null;
    }
}
