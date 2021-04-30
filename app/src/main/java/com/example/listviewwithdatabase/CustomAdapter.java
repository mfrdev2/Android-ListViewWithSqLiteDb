package com.example.listviewwithdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private ArrayList<Integer> id;
    private ArrayList<String> name;
    private Context context;

    public CustomAdapter(Context context,ArrayList<Integer> id, ArrayList<String> name) {
        this.context = context;
        this.id = id;
        this.name = name;
    }
    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int position) {
        return id.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_layout,parent,false);
        }
        TextView id = convertView.findViewById(R.id.idViewId);
        TextView nameE = convertView.findViewById(R.id.nameViewId);

        id.setText(getItem(position).toString());
        nameE.setText(name.get(position));
        return convertView;
    }
}
