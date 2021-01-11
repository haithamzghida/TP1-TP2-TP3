package com.example.tp1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MaligneAdapter extends ArrayAdapter<String> {
    Activity context ;
    String[] items;
    MaligneAdapter(Activity context, String[] items){
        super(context, R.layout.ma_ligne,items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.ma_ligne,null);

            holder = new ViewHolder();
            holder.label = (TextView) convertView.findViewById(R.id.note);
            holder.icone =  (ImageView)convertView.findViewById(R.id.monImage);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        float note = Float.valueOf(items[position]);
        holder.label.setText(items[position]);
        holder.icone.setImageResource(
                (note>= 10)? R.drawable.like : R.drawable.sad
        );

        return convertView;
    }


}
