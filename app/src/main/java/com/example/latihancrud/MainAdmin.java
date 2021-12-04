package com.example.latihancrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


    public class MainAdmin extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_admin);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Home");
            }
            final TextView textView = findViewById(R.id.textView1);
            final Button createbutton = findViewById(R.id.create_btn11);
            createbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(com.example.latihancrud.MainAdmin.this, MainCreate.class);
                    startActivity(intent);
                }
            });
            final Button readbutton = findViewById(R.id.read_btn11);
            readbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(com.example.latihancrud.MainAdmin.this, MainRead.class);
                    startActivity(intent);
                }
            });

            final Button logoutbutton = findViewById(R.id.btnLogout1);
            final SharedPrefManager prefManager = new SharedPrefManager(this);
            if (!prefManager.isUserLoggedIn()) {
                backToLogin();
            }
            UserModel user = prefManager.getUserLogin();
            textView.setText(getString(R.string.welcome, user.getUserName()));
            logoutbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    prefManager.userLogout();
                    backToLogin();
                }
            });
        }

        private void backToLogin() {
            startActivity(new Intent(getApplicationContext(), MainLogin.class));
            finish();
        }
    }


