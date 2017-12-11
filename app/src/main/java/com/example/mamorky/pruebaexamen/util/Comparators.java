package com.example.mamorky.pruebaexamen.util;

import com.example.mamorky.pruebaexamen.pojo.Producto;

import java.util.Comparator;

/**
 * Created by mamorky on 11/12/17.
 */

public class Comparators {
    public static final String NOMBRE="ordenNombre";
    public static final String FECHA="ordenFecha";

    public static class CompareByFecha implements Comparator<Producto>{
        @Override
        public int compare(Producto o1, Producto o2) {
            return o1.getFecha().compareTo(o2.getFecha());
        }
    }
}
