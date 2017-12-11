package com.example.mamorky.pruebaexamen.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.mamorky.pruebaexamen.Lista.ListPresenter;
import com.example.mamorky.pruebaexamen.R;
import com.example.mamorky.pruebaexamen.pojo.Producto;

/**
 * Created by mamorky on 11/12/17.
 */

public class CommonDialog {
    public static final String DELETE = "delete";
    public static final String MESSAGE = "message";
    public static final String TITULO = "titulo";

    public static final String PRODUCTO = "producto";

    public static Dialog showDialog(Bundle bundle, final ListPresenter presenter, Context context){
        String mensaje = bundle.getString(MESSAGE);
        String titulo = bundle.getString(TITULO);
        final Producto producto = (Producto) bundle.getParcelable(PRODUCTO);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(mensaje);
        builder.setTitle(titulo);
        builder.setPositiveButton(R.string.btn_borrar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.deleteProducto(producto);
            }
        }).setNegativeButton(R.string.btn_Cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.show();
    }
}
