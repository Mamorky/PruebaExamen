package com.example.mamorky.pruebaexamen.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by mamorky on 10/12/17.
 */

public class Producto implements Parcelable,Comparable<Producto> {
    private int id;
    private Date fecha;
    private String Nombre;

    public Producto(int id, Date fecha, String nombre) {
        this.id = id;
        this.fecha = fecha;
        Nombre = nombre;
    }

    protected Producto(Parcel in) {
        id = in.readInt();
        Nombre = in.readString();
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(Nombre);
        dest.writeLong(fecha.getTime());
    }

    @Override
    public int compareTo(@NonNull Producto o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
