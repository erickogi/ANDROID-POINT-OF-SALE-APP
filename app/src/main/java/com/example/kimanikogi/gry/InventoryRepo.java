package com.example.kimanikogi.gry;

/**
 * Created by kimani kogi on 10/2/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by Tan on 3/14/2016.
 */


public class InventoryRepo {
    private DBHelper dbHelper;

    public InventoryRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Inventory inventory) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Inventory.KEY_quantity, inventory.quantity);
        values.put(Inventory.KEY_sell,inventory.sell);
        values.put(Inventory.KEY_buy,inventory.buy);
        values.put(Inventory.KEY_name, inventory.name);

        // Inserting Row
        long inventory_Id = db.insert(Inventory.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) inventory_Id;
    }
    public Cursor  getStudentList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                Inventory.KEY_ROWID + "," +
                Inventory.KEY_ID + "," +
                Inventory.KEY_name + "," +
                Inventory.KEY_quantity + "," +
                Inventory.KEY_sell + "," +
                Inventory.KEY_buy +
                " FROM " + Inventory.TABLE;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }


    public Cursor  getStudentListByKeyword(String search) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                Inventory.KEY_ROWID + "," +
                Inventory.KEY_ID + "," +
                Inventory.KEY_name + "," +
                Inventory.KEY_quantity + "," +
                Inventory.KEY_sell + "," +
                Inventory.KEY_buy +
                " FROM " + Inventory.TABLE +
                " WHERE " +  Inventory.KEY_name + "  LIKE  '%" +search + "%' "
                ;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }

    public Inventory getStudentById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT " +
               Inventory.KEY_ID + "," +
                Inventory.KEY_name + "," +
                Inventory.KEY_quantity + "," +
                Inventory.KEY_sell + "," +
                Inventory.KEY_buy +
                " FROM " + Inventory.TABLE
                + " WHERE " +
                Inventory.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Inventory inventory = new Inventory();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                inventory.inventory_ID =cursor.getInt(cursor.getColumnIndex(Inventory.KEY_ID));
                inventory.name =cursor.getString(cursor.getColumnIndex(Inventory.KEY_name));
                inventory.quantity  =cursor.getInt(cursor.getColumnIndex(Inventory.KEY_quantity));
                inventory.sell  =cursor.getDouble(cursor.getColumnIndex(Inventory.KEY_sell));
                inventory.buy =cursor.getDouble(cursor.getColumnIndex(Inventory.KEY_buy));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return inventory;
    }




}