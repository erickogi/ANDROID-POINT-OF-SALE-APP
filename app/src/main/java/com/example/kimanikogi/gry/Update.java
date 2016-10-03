package com.example.kimanikogi.gry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Update extends AppCompatActivity {
int itemid;
    String itemname="we";
    Double itemquantity;
    Double itembp;
    Double itemsp;
    EditText u;
    EditText qw;
    EditText bpe;
    EditText spe;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        EditText u=(EditText)findViewById(R.id.nameedt);
        EditText qw=(EditText)findViewById(R.id.quaedt);
        EditText bpe=(EditText)findViewById(R.id.bpedt);
        EditText spe=(EditText)findViewById(R.id.spedt);
        EditText idqe=(EditText)findViewById(R.id.ide);
     String nn=getid();
        String U=getIntent().getExtras().getString("name");
        u.setText(U);
        String D=getIntent().getExtras().getString("qua");
        qw.setText(D);
        String F=getIntent().getExtras().getString("bup");
        bpe.setText(F);
        String G=getIntent().getExtras().getString("sep");
        spe.setText(G);
        String H=getIntent().getExtras().getString("id");
        idqe.setText(H);

    }
    public void Setid(int ID,String namem,Double quantiti,Double bps,Double sps){
     itemname=namem;
    }
    public String getid(){

        return itemname;
    }

}
