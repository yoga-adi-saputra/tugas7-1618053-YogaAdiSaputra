package com.example.latihancrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_detail(View view) {
        Intent c = new Intent(MainActivity.this, MainBaca.class);
        startActivity(c);
    }

    public void btn_login(View view) {
        Intent d = new Intent(MainActivity.this, MainAdmin.class);
        startActivity(d);
    }
}
