package com.example.taller1jpineda;

import java.util.ArrayList;

public class Material {
    private Integer id;
    private String nombre;

    private ArrayList<Dije> dijes;

    public Material(Integer id, String nombre) {
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

    public void addDije(Dije dije){
        dijes.add(dije);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
