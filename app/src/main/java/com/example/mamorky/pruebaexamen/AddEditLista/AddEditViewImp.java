package com.example.mamorky.pruebaexamen.AddEditLista;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mamorky.pruebaexamen.Lista.ListaViewImp;
import com.example.mamorky.pruebaexamen.R;
import com.example.mamorky.pruebaexamen.pojo.Producto;
import com.example.mamorky.pruebaexamen.util.AddEdit;

public class AddEditViewImp extends AppCompatActivity implements AddEditView{

    private EditText edtNombre;
    private TextInputLayout ilNombre;
    private Button btnGuardar;

    private AddEdit modo;

    private AddEditPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        presenter = new AddEditPresenterImp(this);

        modo = new AddEdit();
        edtNombre = findViewById(R.id.edtNombre);
        btnGuardar = findViewById(R.id.btnGuardar);
        ilNombre = findViewById(R.id.ilNombre);

        modo.MODE = getIntent().getExtras().getInt(AddEdit.TIPOMODO);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(modo.MODE == AddEdit.MODEADD){
                    presenter.addProducto(edtNombre.getText().toString());
                }
                else if(modo.MODE == AddEdit.MODEEDIT){
                    Bundle bundle = getIntent().getBundleExtra("bundle");
                    Producto productoEdt = (Producto) bundle.getParcelable("producto");
                    presenter.editProducto(productoEdt,edtNombre.getText().toString());
                }
            }
        });
    }

    @Override
    public void onSetErrorName() {
        ilNombre.setError("Nombre no válido");
    }

    @Override
    public void onSuccess() {
        Intent intent = new Intent(this,ListaViewImp.class);
        startActivityForResult(intent, Activity.RESULT_OK);
    }
}
