package com.example.mamorky.pruebaexamen.Lista;

import com.example.mamorky.pruebaexamen.adapter.ProductoAdapter;
import com.example.mamorky.pruebaexamen.pojo.Producto;
import com.example.mamorky.pruebaexamen.util.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mamorky on 10/12/17.
 */

public class ListPresenterImp implements ListPresenter,ListInteractorImp.OnLoadSucess{
    ListaView view;
    ListInteractor interactor;

    public ListPresenterImp(ListaView view){
        this.view = view;
        this.interactor = new ListInteractorImp(this);
    }

    @Override
    public void loadProductos() {
        interactor.searchProduct(this);
    }

    @Override
    public Producto searchPersona(int pos) {
        return interactor.searchProduct(pos);
    }

    @Override
    public void deleteProducto(Producto producto) {
        interactor.deleteProducto(producto);
    }

    @Override
    public void orderProductos(String orden, ProductoAdapter adapter) {
        if(orden == Comparators.FECHA)
            adapter.sort(new Comparators.CompareByFecha());
        else
            adapter.sort(null);
    }

    @Override
    public void onLoadSucces(ArrayList<Producto> productos) {
        view.loadProducts(productos);
    }
}
