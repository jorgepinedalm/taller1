package com.example.taller1jpineda;

import java.util.ArrayList;

public class Manilla {
    Material material;
    Dije dije;
    ArrayList<TipoDije> tipos;
    Double valor;

    public Manilla(){
        tipos = new ArrayList<>();
    }

    public Manilla(Material material, Dije dije, Double valor) {
        this.material = material;
        this.dije = dije;
        this.valor = valor;
        this.tipos = new ArrayList<>();
    }

    public Manilla(Material material, Dije dije, ArrayList<TipoDije> tipos, Double valor) {
        this.material = material;
        this.dije = dije;
        this.tipos = tipos;
        this.valor = valor;
    }

    public void setTipo(TipoDije tipo) {
        this.tipos.add(tipo);
    }
}
