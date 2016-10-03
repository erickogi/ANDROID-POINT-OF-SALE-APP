package com.example.kimanikogi.gry;

/**
 * Created by kimani kogi on 10/2/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "inventory.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_STUDENT = "CREATE TABLE " + Inventory.TABLE  + "("
                + Inventory.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Inventory.KEY_name + " TEXT, "
                + Inventory.KEY_quantity + " INTEGER, "
                + Inventory.KEY_sell + " DOUBLE ,"
                + Inventory.KEY_buy + " DOUBLE )";

        db.execSQL(CREATE_TABLE_STUDENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Inventory.TABLE);

        // Create tables again
        onCreate(db);

    }

}
