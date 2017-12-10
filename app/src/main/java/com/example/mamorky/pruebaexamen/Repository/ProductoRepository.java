package com.example.mamorky.pruebaexamen.Repository;

import com.example.mamorky.pruebaexamen.pojo.Producto;

import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mamorky on 10/12/17.
 */

public class ProductoRepository {
    private ArrayList<Producto> productos;
    private static ProductoRepository instance;

    private ProductoRepository(){
        productos = new ArrayList<Producto>();
        Inicialize();
    }

    public static ProductoRepository getInstance() {
        if(instance == null)
            instance = new ProductoRepository();

        return instance;
    }

    public void Inicialize(){
        for (int i = 0; i < 5; i++) {
            AddProducto(new Producto(i,new Date(),"Albondigas"));
            AddProducto(new Producto(i,new Date(),"Calabaza"));
            AddProducto(new Producto(i,new Date(),"Pimiento"));
        }
    }

    public void AddProducto(Producto producto){
        productos.add(producto);
    }

    public Producto getProducto(int pos){
        return productos.get(pos);
    }

    public ArrayList<Producto> getProductos(){
        return productos;
    }
}
