package com.example.kimanikogi.gry;

import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
//import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView n;
    private CustomAdapter customAdapter;
    ListView listView;
    Cursor cursor;
    InventoryRepo inventoryRepo ;
    private final static String TAG= Main2Activity.class.getName().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inventoryRepo = new InventoryRepo(this);
        cursor=inventoryRepo.getStudentList();
        customAdapter = new CustomAdapter(Main2Activity.this,  cursor, 0);

        listView = (ListView) findViewById(R.id.lstStudent);
        listView.setAdapter(customAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ListView list1 = (ListView) findViewById(R.id.lstStudent);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              TextView n= (TextView)view.findViewById(R.id.txtId);
                TextView m=(TextView)view.findViewById(R.id.txtEmail);
                TextView o=(TextView)view.findViewById(R.id.txtName);
                TextView P=(TextView)view.findViewById(R.id.txtbuy);
                TextView q=(TextView)view.findViewById(R.id.txtsell);
                 String name=o.getText().toString();
                String idd=n.getText().toString();
               int id1=Integer.parseInt(idd);
                String bp=P.getText().toString();
                Double bpp=Double.parseDouble(bp);
                String sp=q.getText().toString();
                Double spp=Double.parseDouble(sp);
                String qu=m.getText().toString();
                Double quu=Double.parseDouble(qu);
                Update b= new Update();
                b.Setid(id1,name,quu,bpp,spp);
                Toast.makeText(Main2Activity.this,name +" name ",Toast.LENGTH_LONG).show();
                Intent two=new Intent(Main2Activity.this, Update.class);
               //nnnned to bundle the extra in order to move to next class
                two.putExtra("n",name);
                two.putExtra("id",id1);
                two.putExtra("qua",quu);
                two.putExtra("bup",bpp);
                two.putExtra("sep",spp);
                startActivity(two);
               // b.Setid(id1,name,quu,bpp,spp);

            }


        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add=new Intent(Main2Activity.this, ADD.class);
                startActivity(add);
            }
        });
        if(cursor==null) insertDummy();
    }



    private void insertDummy(){
        Inventory inventory= new Inventory();
        inventory.buy=30.0;
        inventory.sell=54.0;
        inventory.quantity=19;
        inventory.name="RICE";
        inventoryRepo .insert(inventory);

        inventoryRepo  = new InventoryRepo(this);
        inventory.buy=30.0;
        inventory.sell=60.0;
        inventory.quantity=10;
        inventory.name="tti";
        inventoryRepo .insert(inventory);

        inventoryRepo  = new InventoryRepo(this);
        inventory.buy=30.0;
        inventory.sell=50.0;
        inventory.quantity=69;
        inventory.name="PIPES";
        inventoryRepo .insert(inventory);

        inventoryRepo  = new InventoryRepo(this);
        inventory.buy=20.0;
        inventory.sell=39.0;
        inventory.quantity=50;
        inventory.name="Cement";
        inventoryRepo .insert(inventory);


    }
    @Override
    public void onResume(){
        super.onResume();

    }

    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String s) {
                    Log.d(TAG, "onQueryTextSubmit ");
                    cursor=inventoryRepo.getStudentListByKeyword(s);
                    if (cursor==null){
                        Toast.makeText(Main2Activity.this,"No records found!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(Main2Activity.this, cursor.getCount() + " records found!",Toast.LENGTH_LONG).show();
                    }
                    customAdapter.swapCursor(cursor);

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    Log.d(TAG, "onQueryTextChange ");
                    cursor=inventoryRepo.getStudentListByKeyword(s);
                    if (cursor!=null){
                        customAdapter.swapCursor(cursor);
                    }
                    return false;
                }

            });

        }

        return true;

    }

}
