package com.example.latihancrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabaseTalent db;
    private EditText Enama, Egenre, Ekota, Etlp;
    private String Snama, Sgenre, Skota, Stlp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabaseTalent(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Egenre = (EditText) findViewById(R.id.create_genre);
        Ekota = (EditText) findViewById(R.id.create_kota);
        Etlp = (EditText) findViewById(R.id.create_tlp);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sgenre = String.valueOf(Egenre.getText());
                Skota = String.valueOf(Ekota.getText());
                Stlp = String.valueOf(Etlp.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgenre.equals("")){
                    Egenre.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi kelas",
                            Toast.LENGTH_SHORT).show();
                } else if (Skota.equals("")){
                    Ekota.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                }else if (Stlp.equals("")){
                    Etlp.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi phone",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Enama.setText("");
                    Egenre.setText("");
                    Ekota.setText("");
                    Etlp.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateTalent(new Talent(null, Snama, Sgenre, Skota, Stlp));
                    Intent a = new Intent(MainCreate.this, MainAdmin.class);
                    startActivity(a);
                }
            }
        });
    }
}
