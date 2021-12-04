package com.example.latihancrud;

public class Talent {
    private String _id, _nama, _genre, _kota, _tlp;
    public Talent (String id, String nama, String genre, String kota, String tlp) {
        this._id = id;
        this._nama = nama;
        this._genre = genre;
        this._kota = kota;
        this._tlp = tlp;
    }
    public Talent() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_genre() {
        return _genre;
    }
    public void set_genre(String _genre) {
        this._genre = _genre;
    }
    public String get_kota() {
        return _kota;
    }
    public void set_kota(String _kota) {
        this._kota = _kota;
    }
    public String get_tlp() {
        return _tlp;
    }
    public void set_tlp(String _tlp) {
        this._tlp = _tlp;
    }
}

