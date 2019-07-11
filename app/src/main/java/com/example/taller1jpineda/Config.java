package com.example.taller1jpineda;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;



public class Config {

    private List<Material> materiales = new ArrayList<>();
    private List<Dije> dijes = new ArrayList<>();
    private List<TipoDije> tiposDije = new ArrayList<>();
    private List<Manilla> manillas = new ArrayList<>();

    public void init(Context ctx){

        Material cuerda = new Material(1, ctx.getResources().getString(R.string.cuerda));
        Material cuero = new Material(2, ctx.getResources().getString(R.string.cuero));
        materiales.add(cuerda);
        materiales.add(cuero);

        Dije ancla = new Dije(1, ctx.getResources().getString(R.string.ancla));
        Dije martillo = new Dije(2, ctx.getResources().getString(R.string.martillo));
        dijes.add(ancla);
        dijes.add(martillo);

        TipoDije oro = new TipoDije(1, ctx.getResources().getString(R.string.oro));
        TipoDije oro_rosado = new TipoDije(2, ctx.getResources().getString(R.string.oro_rosado));
        TipoDije plata = new TipoDije(3, ctx.getResources().getString(R.string.plata));
        TipoDije niquel = new TipoDije(4, ctx.getResources().getString(R.string.niquel));
        tiposDije.add(oro);
        tiposDije.add(oro_rosado);
        tiposDije.add(plata);
        tiposDije.add(niquel);

        Manilla m1 = new Manilla(cuero, martillo, 100.0);
        m1.setTipo(oro);
        m1.setTipo(oro_rosado);
        manillas.add(m1);

        Manilla m2 = new Manilla(cuero, martillo, 80.0);
        m2.setTipo(plata);
        manillas.add(m2);

        Manilla m3 = new Manilla(cuero, martillo, 70.0);
        m3.setTipo(niquel);
        manillas.add(m3);

        Manilla m4 = new Manilla(cuero, ancla, 120.0);
        m4.setTipo(oro);
        m4.setTipo(oro_rosado);
        manillas.add(m4);

        Manilla m5 = new Manilla(cuero, ancla, 80.0);
        m5.setTipo(plata);
        manillas.add(m5);

        Manilla m6 = new Manilla(cuero, ancla, 70.0);
        m6.setTipo(niquel);
        manillas.add(m6);

        Manilla m7 = new Manilla(cuerda, martillo, 90.0);
        m7.setTipo(oro);
        m7.setTipo(oro_rosado);
        manillas.add(m7);

        Manilla m8 = new Manilla(cuerda, martillo, 70.0);
        m8.setTipo(plata);
        manillas.add(m8);

        Manilla m9 = new Manilla(cuerda, martillo, 50.0);
        m9.setTipo(niquel);
        manillas.add(m9);

        Manilla m10 = new Manilla(cuerda, ancla, 110.0);
        m10.setTipo(oro);
        m10.setTipo(oro_rosado);
        manillas.add(m10);

        Manilla m11 = new Manilla(cuerda, ancla, 90.0);
        m11.setTipo(plata);
        manillas.add(m11);

        Manilla m12 = new Manilla(cuerda, ancla, 80.0);
        m12.setTipo(niquel);
        manillas.add(m12);

    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public List<Dije> getDijes() {
        return dijes;
    }

    public List<TipoDije> getTiposDije() {
        return tiposDije;
    }

    public Manilla getManilla(Material material, Dije dije, TipoDije tipoDije){

        for(int i = 0 ; i < manillas.size(); i++){
            if(manillas.get(i).getMaterial() == material && manillas.get(i).getDije() == dije && manillas.get(i).getTipos().contains(tipoDije)){
                return manillas.get(i);
            }
        }

        return null;
    }

}
