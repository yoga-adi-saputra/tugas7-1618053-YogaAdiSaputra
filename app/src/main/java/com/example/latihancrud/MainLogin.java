package com.example.latihancrud;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Please Login....");
        }
        final EditText userNameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait.....");
        progressDialog.setCancelable(false);
        final SharedPrefManager prefManager = new SharedPrefManager(getApplicationContext());
        Boolean isLoggedIn = prefManager.isUserLoggedIn();
        if (isLoggedIn) {
            goToMain();
        } else {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    progressDialog.show();
                    String username = userNameEditText.getText().toString();
                    String userpass = passwordEditText.getText().toString();
                    if (username.equals("visected@gmail.com") && userpass.equals("admin")) {
                        UserModel user = new UserModel(username, "Yoga Adi Saputra");
                        prefManager.setUserLogin(user, true);
                        goToMain();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(MainLogin.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    private void goToMain() {
        startActivity(new Intent(getApplicationContext(), MainAdmin.class));
        finish();
    }
}

