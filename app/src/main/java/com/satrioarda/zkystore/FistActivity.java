package com.satrioarda.zkystore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FistActivity extends AppCompatActivity {
    Button first;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        first = findViewById(R.id.first);
    }
    public void first(View view){
        Intent intent = new Intent(FistActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
