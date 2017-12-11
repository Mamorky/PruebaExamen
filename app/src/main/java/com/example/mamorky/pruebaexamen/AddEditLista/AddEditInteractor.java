package com.example.mamorky.pruebaexamen.AddEditLista;

import com.example.mamorky.pruebaexamen.pojo.Producto;

/**
 * Created by mamorky on 11/12/17.
 */

public interface AddEditInteractor {
    void addPersona(String nombre, AddEditInteractorImp.onValidatePreference onValidatePreference);
}
