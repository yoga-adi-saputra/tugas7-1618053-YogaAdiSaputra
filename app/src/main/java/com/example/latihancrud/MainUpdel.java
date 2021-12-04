package com.example.latihancrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabaseTalent db;
    private String Sid, Snama, Sgenre, Skota, Stlp;
    private EditText Enama, Egenre, Ekota, Etlp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabaseTalent(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sgenre = i.getStringExtra("Igenre");
        Skota = i.getStringExtra("Ikota");
        Stlp = i.getStringExtra("Itlp");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Egenre = (EditText) findViewById(R.id.updel_genre);
        Ekota = (EditText) findViewById(R.id.updel_kota);
        Etlp = (EditText) findViewById(R.id.updel_tlp);
        Enama.setText(Snama);
        Egenre.setText(Sgenre);
        Ekota.setText(Skota);
        Etlp.setText(Stlp);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sgenre = String.valueOf(Egenre.getText());
                Skota = String.valueOf(Ekota.getText());
                Stlp = String.valueOf(Etlp.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgenre.equals("")){
                    Egenre.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi kelas",
                            Toast.LENGTH_SHORT).show();
                } else if (Skota.equals("")){
                    Ekota.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                }else if (Stlp.equals("")){
                    Etlp.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi phone",
                            Toast.LENGTH_SHORT).show();
                }else {
                    db.UpdateTalent(new Talent(Sid, Snama, Sgenre, Skota, Stlp));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteTalent(new Talent(Sid, Snama, Sgenre, Skota, Stlp));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
