package com.example.mamorky.pruebaexamen.Lista;

import com.example.mamorky.pruebaexamen.Repository.ProductoRepository;
import com.example.mamorky.pruebaexamen.adapter.ProductoAdapter;
import com.example.mamorky.pruebaexamen.pojo.Producto;

import java.util.ArrayList;

/**
 * Created by mamorky on 10/12/17.
 */

public class ListInteractorImp implements ListInteractor{
    ListPresenter presenter;
    interface OnLoadSucess{
        void onLoadSucces(ArrayList<Producto> adapter);
    }

    public ListInteractorImp(ListPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void searchProduct(OnLoadSucess onLoadSucess) {
        ArrayList<Producto> productos = ProductoRepository.getInstance().getProductos();
        onLoadSucess.onLoadSucces(productos);
    }

    @Override
    public Producto searchProduct(int pos) {
        return ProductoRepository.getInstance().getProducto(pos);
    }

    @Override
    public void deleteProducto(Producto producto) {
        ProductoRepository.getInstance().deleteProducto(producto);
    }
}
