package com.example.mamorky.pruebaexamen.Lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mamorky.pruebaexamen.R;
import com.example.mamorky.pruebaexamen.adapter.ProductoAdapter;
import com.example.mamorky.pruebaexamen.pojo.Producto;

import java.util.ArrayList;

public class ListaViewImp extends AppCompatActivity implements ListaView {

    private ListView listView;
    private ProductoAdapter adapter;

    private ListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_view_imp);

        listView = (ListView)findViewById(R.id.listView_productos);

        presenter = new ListPresenterImp(this);
        adapter = new ProductoAdapter(this);

        listView.setAdapter(adapter);

        presenter.loadProductos();
    }


    @Override
    public void loadProducts(ArrayList<Producto> productos) {
        adapter.clear();
        adapter.addAll(productos);
    }
}
