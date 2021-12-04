package com.example.latihancrud;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapterTalent extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Talent> movieItems;

    public CustomListAdapterTalent(Activity activity, List<Talent> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView genre = (TextView) convertView.findViewById(R.id.text_genre);
        TextView kota = (TextView) convertView.findViewById(R.id.text_kota);
        TextView tlp = (TextView) convertView.findViewById(R.id.text_tlp);

        Talent m = movieItems.get(position);
        nama.setText("Nama : "+ m.get_nama());
        genre.setText("Genre : "+ m.get_genre());
        kota.setText("Alamat : "+ m.get_kota());
        tlp.setText("Phone : "+ m.get_tlp());

        return convertView;
    }
}
