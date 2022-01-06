package com.satrioarda.zkystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class int_diamond extends AppCompatActivity {

    TextView txtnama, txtharga, txtdeskripsi;
    ImageView imgfoto;
    String nama, harga, deskripsi;


    public static final String session = "session";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Detail Produk: ");

        nama = getIntent().getStringExtra("nama");
        harga = getIntent().getStringExtra("harga");
        deskripsi = getIntent().getStringExtra("deskripsi");

        setTitle("Detail Produk: " + nama);
        imgfoto = findViewById(R.id.imgfoto);
        imgfoto.setImageResource(getIntent().getIntExtra("gambar", 0));
        txtnama = findViewById(R.id.txtnama);
        txtnama.setText(nama);
        txtharga = findViewById(R.id.txtharga);
        txtharga.setText("Harga:" + harga);
        txtdeskripsi = findViewById(R.id.txtdeskripsi);
        txtdeskripsi.setText(deskripsi);
    }
}