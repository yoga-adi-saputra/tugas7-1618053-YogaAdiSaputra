package com.example.latihancrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapterTalent adapter_off;
    private MyDatabaseTalent db;
    private List<Talent> ListTalent = new ArrayList<Talent>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabaseTalent(this);
        adapter_off = new CustomListAdapterTalent(this, ListTalent );
        mListView = (ListView) findViewById(R.id.list_talent);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListTalent.clear();
        List<Talent> contacts = db.ReadTalent();
        for (Talent cn : contacts) {
            Talent judulModel = new Talent();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_genre(cn.get_genre());
            judulModel.set_kota(cn.get_kota());
            judulModel.set_tlp(cn.get_tlp());
            ListTalent.add(judulModel);
            if ((ListTalent.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Talent obj_itemDetails = (Talent)o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sgenre = obj_itemDetails.get_genre();
        String Skota = obj_itemDetails.get_kota();
        String Stlp = obj_itemDetails.get_tlp();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Igenre", Sgenre);
        goUpdel.putExtra("Ikota", Skota);
        goUpdel.putExtra("Itlp", Stlp);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListTalent.clear();
        mListView.setAdapter(adapter_off);
        List<Talent> contacts = db.ReadTalent();
        for (Talent cn : contacts) {
            Talent judulModel = new Talent();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_genre(cn.get_genre());
            judulModel.set_kota(cn.get_kota());
            judulModel.set_tlp(cn.get_tlp());
            ListTalent.add(judulModel);
            if ((ListTalent.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
