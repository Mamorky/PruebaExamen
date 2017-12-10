package com.example.mamorky.pruebaexamen.pojo;

import java.util.Date;

/**
 * Created by mamorky on 10/12/17.
 */

public class Producto {
    private int id;
    private Date fecha;
    private String Nombre;

    public Producto(int id, Date fecha, String nombre) {
        this.id = id;
        this.fecha = fecha;
        Nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
