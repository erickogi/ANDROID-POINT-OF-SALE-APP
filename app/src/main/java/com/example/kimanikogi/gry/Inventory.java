package com.example.kimanikogi.gry;

/**
 * Created by kimani kogi on 10/2/2017.
 */

public class Inventory {
    // Labels table name
    public static final String TABLE = "Inventory";

    // Labels Table Columns names
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_quantity = "quantity";
    public static final String KEY_sell = "sell";
    public static final String KEY_buy = "buy";

    // property help us to keep data
    public int inventory_ID;
    public String name;
    public Double sell;
    public Double buy;
    public int quantity;
}