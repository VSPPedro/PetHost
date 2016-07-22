package com.example.pedro.pethost;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AnfitriaoAdapter extends BaseAdapter
{
    private List<UserAnfitriao> lista;
    private Context context;

    public AnfitriaoAdapter(List<UserAnfitriao> anfitriaos , Context context)
    {
        Log.i("BD","ChegouNoAdapter");
        this.lista = anfitriaos;
        this.context = context;
    }
    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        UserAnfitriao anfitriao = this.lista.get(position);

        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.activity_anfitriao_layout, null);
        }else view = convertView;

        TextView tv = (TextView) view.findViewById(R.id.tvNomeAnfitriaoLayout);
        tv.setText(anfitriao.getNome());

        return view;
    }
}
