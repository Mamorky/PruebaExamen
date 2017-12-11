package com.example.mamorky.pruebaexamen.AddEditLista;

import com.example.mamorky.pruebaexamen.pojo.Producto;

/**
 * Created by mamorky on 11/12/17.
 */

public interface AddEditPresenter{
    void addProducto(String nombre);
    void editProducto(Producto producto,String nombre);
}
