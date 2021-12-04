package com.example.latihancrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseTalent extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_talent";
    private static final String tb_talent = "tb_talent";
    private static final String tb_talent_id = "id";
    private static final String tb_talent_nama = "nama";
    private static final String tb_talent_genre = "genre";
    private static final String tb_talent_kota = "kota";
    private static final String tb_talent_tlp = "tlp";
    private static final String CREATE_TABLE_TALENT = "CREATE TABLE " +
            tb_talent + "("
            + tb_talent_id + " INTEGER PRIMARY KEY ,"
            + tb_talent_nama + " TEXT,"
            + tb_talent_genre + " TEXT,"
            + tb_talent_kota + " TEXT,"
            + tb_talent_tlp + " TEXT" + ")";

    public MyDatabaseTalent (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TALENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateTalent (Talent mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_talent_id, mdNotif.get_id());
        values.put(tb_talent_nama, mdNotif.get_nama());
        values.put(tb_talent_genre, mdNotif.get_genre());
        values.put(tb_talent_kota, mdNotif.get_kota());
        values.put(tb_talent_tlp, mdNotif.get_tlp());
        db.insert(tb_talent, null, values);
        db.close();
    }

    public List<Talent> ReadTalent() {
        List<Talent> judulModelList = new ArrayList<Talent>();
        String selectQuery = "SELECT * FROM " + tb_talent;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Talent mdKontak = new Talent();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_genre(cursor.getString(2));
                mdKontak.set_kota(cursor.getString(3));
                mdKontak.set_tlp(cursor.getString(4));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateTalent (Talent mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_talent_nama, mdNotif.get_nama());
        values.put(tb_talent_genre, mdNotif.get_genre());
        values.put(tb_talent_kota, mdNotif.get_kota());
        values.put(tb_talent_tlp, mdNotif.get_tlp());
        return db.update(tb_talent, values, tb_talent_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteTalent (Talent mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_talent, tb_talent_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

