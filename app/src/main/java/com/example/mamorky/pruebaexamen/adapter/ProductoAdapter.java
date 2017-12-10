package com.example.mamorky.pruebaexamen.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mamorky.pruebaexamen.R;
import com.example.mamorky.pruebaexamen.pojo.Producto;

import java.util.ArrayList;

/**
 * Created by mamorky on 10/12/17.
 */

public class ProductoAdapter extends ArrayAdapter<Producto> {

    public ProductoAdapter(@NonNull Context context) {
        super(context,R.layout.item_lista,new ArrayList<Producto>());
    }

    private class ProductoHolder{
        public TextView txvNombre;
        public TextView txvFecha;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewRoot = convertView;

        ProductoHolder holder;

        if(viewRoot == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewRoot = inflater.inflate(R.layout.item_lista,null);

            holder = new ProductoHolder();

            holder.txvFecha = (TextView)viewRoot.findViewById(R.id.txvFecha);
            holder.txvNombre = (TextView)viewRoot.findViewById(R.id.txvNameProduct);

            viewRoot.setTag(holder);
        }
        else
            holder = (ProductoHolder)viewRoot.getTag();

        holder.txvNombre.setText(getItem(position).getNombre());
        holder.txvFecha.setText(getItem(position).getFecha().toString());

        return viewRoot;
    }
}

