package com.example.readjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Lolicon> {
    public CustomAdapter(Context context, int resource, List<Lolicon> items) {
        super(context, resource, items);
    }
    public View getView (int posision, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater  = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.custtomlist, null);
        }
        Lolicon p = getItem(posision);
        if (p != null) {
            TextView  txttitle = (TextView) view.findViewById(R.id.name);
            txttitle.setText(p.name);
            TextView aget = (TextView) view.findViewById(R.id.age);
            aget.setText(p.age);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            Picasso.with(getContext()).load(p.img).into(imageView);
        }
        return view;
    }

}
