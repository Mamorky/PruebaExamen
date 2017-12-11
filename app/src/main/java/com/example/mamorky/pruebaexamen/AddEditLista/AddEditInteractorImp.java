package com.example.mamorky.pruebaexamen.AddEditLista;

import com.example.mamorky.pruebaexamen.Repository.ProductoRepository;
import com.example.mamorky.pruebaexamen.pojo.Producto;

import java.util.Date;

/**
 * Created by mamorky on 11/12/17.
 */

public class AddEditInteractorImp implements AddEditInteractor{
    AddEditPresenter presenter;

    public AddEditInteractorImp(AddEditPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void addPersona(String nombre, onValidatePreference onValidatePreference) {
        if(nombre.isEmpty())
            onValidatePreference.onErrorName();
        else{
            ProductoRepository.getInstance().AddProducto(new Producto(ProductoRepository.getInstance().getLastId(),new  Date(),nombre));
            onValidatePreference.onSuccess();
        }
    }

    interface onValidatePreference{
        void onErrorName();
        void onSuccess();
    }
}
