package com.example.kimanikogi.gry;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kimani kogi on 10/2/2017.
 */

public class CustomAdapter extends CursorAdapter {
    TextView txtId,txtName,txtEmail,txtbuy;
    private LayoutInflater mInflater;

    public CustomAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View   view    =    mInflater.inflate(R.layout.item, parent, false);
        ViewHolder holder  =   new ViewHolder();
        holder.txtId    =   (TextView)  view.findViewById(R.id.txtId);
        holder.txtName    =   (TextView)  view.findViewById(R.id.txtName);
        holder.txtEmail   =   (TextView)  view.findViewById(R.id.txtEmail);
        holder.txtbuy   =   (TextView)  view.findViewById(R.id.txtbuy);
        holder.txtsell   =   (TextView)  view.findViewById(R.id.txtsell);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // If you want to have zebra lines color effect uncomment below code
       // if(cursor.getPosition()%2==1) {
        //    view.setBackgroundResource(R.drawable.item_list_backgroundcolor);
      //  } else {
      //      view.setBackgroundResource(R.drawable.item_list_backgroundcolor2);
      //  }

        ViewHolder holder  =   (ViewHolder)    view.getTag();
        holder.txtId.setText(cursor.getString(cursor.getColumnIndex(Inventory.KEY_ID)));
        holder.txtName.setText(cursor.getString(cursor.getColumnIndex(Inventory.KEY_name)));
        holder.txtEmail.setText(cursor.getString(cursor.getColumnIndex(Inventory.KEY_quantity)));
        holder.txtbuy.setText(cursor.getString(cursor.getColumnIndex(Inventory.KEY_buy)));
        holder.txtsell.setText(cursor.getString(cursor.getColumnIndex(Inventory.KEY_sell)));
      //  holder.txtEmail.setText(cursor.getString(cursor.getColumnIndex(Inventory.KEY_quantity)));

    }

    static class ViewHolder {
        TextView txtId;
        TextView txtName;
        TextView txtEmail;
        TextView txtbuy;
        TextView txtsell;
    }
}