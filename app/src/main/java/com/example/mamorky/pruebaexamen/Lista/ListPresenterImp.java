package com.example.mamorky.pruebaexamen.Lista;

import com.example.mamorky.pruebaexamen.pojo.Producto;

import java.util.ArrayList;

/**
 * Created by mamorky on 10/12/17.
 */

public class ListPresenterImp implements ListPresenter{
    ListaView view;
    ListInteractor interactor;

    public ListPresenterImp(ListaView view){
        this.view = view;
        this.interactor = new ListInteractorImp(this);
    }

    @Override
    public void loadProductos() {
        view.loadProducts(searchPersonas());
    }

    @Override
    public ArrayList<Producto> searchPersonas() {
        return interactor.searchProduct();
    }
}
