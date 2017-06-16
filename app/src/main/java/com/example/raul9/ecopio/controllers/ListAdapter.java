package com.example.raul9.ecopio.controllers;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.raul9.ecopio.R;
import com.example.raul9.ecopio.models.Centro;

import java.util.List;

/**
 * Created by raul94jvu on 15/6/2017.
 */

public class ListAdapter extends ArrayAdapter<Centro> {
    Context context;
    int layoutResourceId;
    List<Centro> objects = null;

    public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Centro> objects) {
        super(context, resource, objects);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.objects= objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CentroHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item, null);

            holder = new CentroHolder();
            holder.txtNombre = (TextView) row.findViewById(R.id.txtNombre);
            holder.txtDireccion = (TextView)row.findViewById(R.id.txtDireccion);

            row.setTag(holder);
        }
        else
        {
            holder = (CentroHolder)row.getTag();
        }

        Centro centro = objects.get(position);
        holder.txtNombre.setText(centro.getNombre());
        holder.txtDireccion.setText(centro.getDireccion());

        return row;
    }

    static class CentroHolder
    {
        TextView txtNombre;
        TextView txtDireccion;
    }
}
