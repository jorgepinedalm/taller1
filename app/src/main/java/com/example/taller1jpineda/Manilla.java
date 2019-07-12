package com.example.taller1jpineda;

import java.util.ArrayList;

public class Manilla {
    private Material material;
    private Dije dije;
    private ArrayList<TipoDije> tipos;
    private double valor;
    private static final double DOLLAR = 3200;

    public Manilla(Material material, Dije dije, double valor) {
        this.material = material;
        this.dije = dije;
        this.valor = valor;
        this.tipos = new ArrayList<>();
    }

    public void setTipo(TipoDije tipo) {
        this.tipos.add(tipo);
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Dije getDije() {
        return dije;
    }

    public void setDije(Dije dije) {
        this.dije = dije;
    }

    public Double getValor() {
        return valor;
    }

    public Double getValorByCurrency(int posCurrency){
        Double valor;
        switch (posCurrency){
            case 0:
                //dolar
                valor = this.valor;
                break;
            case 1:
                //peso
                valor = this.valor * DOLLAR;
                break;
            default:
                valor = this.valor;
        }
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ArrayList<TipoDije> getTipos() {
        return tipos;
    }

}
