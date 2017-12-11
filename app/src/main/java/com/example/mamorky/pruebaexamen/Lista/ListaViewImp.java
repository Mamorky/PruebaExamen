package com.example.mamorky.pruebaexamen.Lista;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mamorky.pruebaexamen.AddEditLista.AddEditViewImp;
import com.example.mamorky.pruebaexamen.R;
import com.example.mamorky.pruebaexamen.adapter.ProductoAdapter;
import com.example.mamorky.pruebaexamen.pojo.Producto;
import com.example.mamorky.pruebaexamen.util.AddEdit;
import com.example.mamorky.pruebaexamen.util.CommonDialog;
import com.example.mamorky.pruebaexamen.util.Comparators;

import java.util.ArrayList;

public class ListaViewImp extends AppCompatActivity implements ListaView {

    private ListView listView;
    private ProductoAdapter adapter;
    private FloatingActionButton btnFabAdd;

    private ListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_view_imp);

        listView = (ListView)findViewById(R.id.listView_productos);
        btnFabAdd = findViewById(R.id.fab_Add);

        presenter = new ListPresenterImp(this);
        adapter = new ProductoAdapter(this);

        listView.setAdapter(adapter);

        presenter.loadProductos();

        btnFabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddEditViewImp.class);
                intent.putExtra(AddEdit.TIPOMODO,AddEdit.MODEADD);

                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("producto",(Producto)parent.getItemAtPosition(position));
                Intent intent = new Intent(ListaViewImp.this,AddEditViewImp.class);
                intent.putExtra(AddEdit.TIPOMODO,AddEdit.MODEEDIT);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });

        presenter.orderProductos(null,adapter);
        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_orden,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_orden_nombre:
                presenter.orderProductos(Comparators.NOMBRE,adapter);
                break;
            case R.id.action_orden_fecha:
                presenter.orderProductos(Comparators.FECHA,adapter);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Titulo");
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete_context:
                AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Bundle bundle = new Bundle();
                Producto productoDel = presenter.searchPersona(menuInfo.position);
                bundle.getString(CommonDialog.TITULO,"Deseas Borrar");
                bundle.getString(CommonDialog.MESSAGE,"Estas seguro que deseas borrar el producto: "+productoDel.getNombre());
                bundle.putParcelable(CommonDialog.PRODUCTO,productoDel);
                Dialog dialog = CommonDialog.showDialog(bundle,presenter,this);
                dialog.show();
                break;
            default:
                super.onContextItemSelected(item);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void loadProducts(ArrayList<Producto> productos) {
        adapter.clear();
        adapter.addAll(productos);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case Activity.RESULT_OK:
                presenter.loadProductos();
                break;
        }
    }
}
