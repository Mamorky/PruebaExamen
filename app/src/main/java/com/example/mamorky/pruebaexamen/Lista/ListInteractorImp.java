package com.example.mamorky.pruebaexamen.Lista;

import com.example.mamorky.pruebaexamen.Repository.ProductoRepository;
import com.example.mamorky.pruebaexamen.pojo.Producto;

import java.util.ArrayList;

/**
 * Created by mamorky on 10/12/17.
 */

public class ListInteractorImp implements ListInteractor{
    ListPresenter presenter;

    public ListInteractorImp(ListPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public ArrayList<Producto> searchProduct() {
        return ProductoRepository.getInstance().getProductos();
    }
}
