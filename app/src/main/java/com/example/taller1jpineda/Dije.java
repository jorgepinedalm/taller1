package com.example.taller1jpineda;

import java.util.ArrayList;

public class Dije {
    private Integer id;
    private String nombre;
    private ArrayList<TipoDije> tipoDije;


    public Dije(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addTipoDije(TipoDije dije){
        tipoDije.add(dije);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
