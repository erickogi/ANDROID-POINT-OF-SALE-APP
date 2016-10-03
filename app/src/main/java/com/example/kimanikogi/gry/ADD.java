package com.example.kimanikogi.gry;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.kimanikogi.gry.R.id.nameedtx;
import static com.example.kimanikogi.gry.R.id.nametxt;

public class ADD extends AppCompatActivity {

Button addbtn;
    EditText r;
    EditText s;
    EditText t;
    EditText u;
    InventoryRepo inventoryRepo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        EditText r= (EditText) findViewById(R.id.nameedtx);
        EditText s= (EditText) findViewById(R.id.quantityedtx);
        EditText t= (EditText) findViewById(R.id.bpedtx);
        EditText u= (EditText) findViewById(R.id.spedtx);
        Button fab = (Button) findViewById(R.id.addbtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               add();
            }
        });
    }
    public void add(){
        try {
            EditText r= (EditText) findViewById(R.id.nameedtx);
            EditText s= (EditText) findViewById(R.id.quantityedtx);
            EditText t= (EditText) findViewById(R.id.bpedtx);
            EditText u= (EditText) findViewById(R.id.spedtx);
            Button fab = (Button) findViewById(R.id.addbtn);
            String h = r.getText().toString();
            int b = Integer.parseInt(s.getText().toString());
            Double c = Double.parseDouble(t.getText().toString());
            Double d = Double.parseDouble(u.getText().toString());

            inventoryRepo = new InventoryRepo(this);
            Inventory inventory = new Inventory();
            inventory.buy = c;
            inventory.sell = d;
            inventory.quantity = b;
            inventory.name = h;
            inventoryRepo.insert(inventory);

            Toast.makeText(ADD.this,"INSERTED ",Toast.LENGTH_SHORT).show();
            r.setText("");
            s.setText("");
            t.setText("");
            u.setText("");

        }
        catch (Exception c){
            c.printStackTrace();
            displayExceptionMessage(c.getMessage());
            Toast.makeText(ADD.this,"ERROR",Toast.LENGTH_SHORT).show();
        }
    }
public  void displayExceptionMessage(String msg){

    Toast.makeText(ADD.this,msg,Toast.LENGTH_LONG).show();
}
}
