package com.example.mamorky.pruebaexamen.Lista;

import com.example.mamorky.pruebaexamen.pojo.Producto;

import java.util.ArrayList;

/**
 * Created by mamorky on 10/12/17.
 */

public interface ListInteractor {
    void searchProduct(ListInteractorImp.OnLoadSucess onLoadSucess);
    Producto searchProduct(int pos);
    void deleteProducto(Producto producto);
}
