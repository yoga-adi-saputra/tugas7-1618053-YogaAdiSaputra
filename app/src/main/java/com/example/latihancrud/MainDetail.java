package com.example.latihancrud;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainDetail extends AppCompatActivity {
    private MyDatabaseTalent db;
    private String Sid, Snama, Sgenre, Skota, Stlp;
    private TextView Enama, Egenre, Ekota, Etlp;
    private Button button, button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);
        db = new MyDatabaseTalent(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sgenre = i.getStringExtra("Igenre");
        Skota = i.getStringExtra("Ikota");
        Stlp = i.getStringExtra("Itlp");
        Enama = (TextView) findViewById(R.id.detail_nama);
        Egenre = (TextView) findViewById(R.id.detail_genre);
        Ekota = (TextView) findViewById(R.id.detail_kota);
        Etlp = (TextView) findViewById(R.id.detail_tlp);
        Enama.setText(Snama);
        Egenre.setText(Sgenre);
        Ekota.setText(Skota);
        Etlp.setText(Stlp);

        button = (Button)findViewById(R.id.tlp_btn);
        button1 = (Button)findViewById(R.id.sms_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Stlp));
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+Stlp));
                intent.putExtra("sms_body", "Assalamu'alaikum Pak/Bu ");
                startActivity(intent);
            }
        });
    }

}
