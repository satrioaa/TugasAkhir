package com.satrioarda.zkystore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recDiamond;
    private ArrayList<com.satrioarda.zkystore.Diamond> listDiamond;
    SharedPreferences pref;
    EditText etusername, etid, etjumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etusername = findViewById(R.id.etusername);
        etid = findViewById(R.id.etid);
        etjumlah = findViewById(R.id.etjumlah);

        pref = this.getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        recDiamond = findViewById(R.id.rec_diamond);
        initData();

        recDiamond.setAdapter(new com.satrioarda.zkystore.MenuAdapter(listDiamond,this));
        recDiamond.setLayoutManager(new LinearLayoutManager(this));
    }

    public void order(View view) {

        String username = etusername.getText().toString();
        String idserver = etid.getText().toString();
        String jumlah   = etjumlah.getText().toString();


        pref.edit().putString(getString(R.string.username_key), username).apply();
        pref.edit().putString(getString(R.string.idserver_key), idserver).apply();
        pref.edit().putString(getString(R.string.jumlah_key), jumlah).apply();
        Toast.makeText(MainActivity.this,"Orderanmu telah dicatat", Toast.LENGTH_SHORT).show();

    }

    private void initData(){
        this.listDiamond = new ArrayList<>();
        listDiamond.add(new com.satrioarda.zkystore.Diamond("86 Diamonds",
                "Rp. 19.600",
                "86 Diamonds Mobile Legends : Bang - bang. Pengiriman Via ID / Server. Murah, Cepat dan Legal.",
                R.drawable.dm));

        listDiamond.add(new com.satrioarda.zkystore.Diamond("109 Diamonds",
                " Rp. 25.900",
                "109 Diamonds Mobile Legends : Bang - bang. Pengiriman Via ID / Server. Murah, Cepat dan Legal.",
                R.drawable.dm));

        listDiamond.add(new com.satrioarda.zkystore.Diamond("172 Diamonds",
                "Rp. 39.200",
                "172 Diamonds Mobile Legends : Bang - bang. Pengiriman Via ID / Server. Murah, Cepat dan Legal.",
                R.drawable.dm));

        listDiamond.add(new com.satrioarda.zkystore.Diamond("257 Diamonds",
                "Rp. 58.800",
                "257 Diamonds Mobile Legends : Bang - bang. Pengiriman Via ID / Server. Murah, Cepat dan Legal.",
                R.drawable.dm)) ;
    }

}