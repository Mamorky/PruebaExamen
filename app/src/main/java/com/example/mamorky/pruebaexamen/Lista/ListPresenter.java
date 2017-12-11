package com.example.mamorky.pruebaexamen.Lista;

import com.example.mamorky.pruebaexamen.adapter.ProductoAdapter;
import com.example.mamorky.pruebaexamen.pojo.Producto;

import java.util.ArrayList;

/**
 * Created by mamorky on 10/12/17.
 */

public interface ListPresenter {
     void loadProductos();
     Producto searchPersona(int pos);
     void deleteProducto(Producto producto);
     void orderProductos(String orden, ProductoAdapter adapter);
}
