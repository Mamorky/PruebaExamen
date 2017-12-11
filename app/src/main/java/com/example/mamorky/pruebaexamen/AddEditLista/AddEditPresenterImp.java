package com.example.mamorky.pruebaexamen.AddEditLista;

import android.widget.EditText;

import com.example.mamorky.pruebaexamen.Repository.ProductoRepository;
import com.example.mamorky.pruebaexamen.pojo.Producto;

/**
 * Created by mamorky on 11/12/17.
 */

public class AddEditPresenterImp implements AddEditPresenter,AddEditInteractorImp.onValidatePreference{
    AddEditInteractor interactor;
    AddEditView view;

    public AddEditPresenterImp(AddEditView view){
        this.view = view;
        this.interactor = new AddEditInteractorImp(this);
    }

    @Override
    public void onErrorName() {
        view.onSetErrorName();
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }

    @Override
    public void addProducto(String nombre) {
        interactor.addPersona(nombre,this);
    }

    @Override
    public void editProducto(Producto producto,String nombre) {
        if(nombre.isEmpty())
            onErrorName();
        else{
            //producto.setNombre(nombre);

            //No hacer esto, debe ir en interactor
            ProductoRepository.getInstance().editProduct(producto,nombre);
            onSuccess();
        }
    }
}
