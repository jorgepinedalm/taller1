package com.example.taller1jpineda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;
    private EditText cantidad;
    private Spinner cmbMaterial;
    private Spinner cmbDije;
    private Spinner cmbTipoDije;
    private Spinner cmbMoneda;
    private String[] monedas;
    private Config config;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Captura de los objetos utilizados
        cmbMaterial = findViewById(R.id.cmbMaterial);
        cmbDije = findViewById(R.id.cmbDije);
        cmbTipoDije = findViewById(R.id.cmbTipoDije);
        cmbMoneda = findViewById(R.id.cmbMoneda);
        txtResultado = findViewById(R.id.txtResultado);
        cantidad = findViewById(R.id.txtCantidad);

        //Se creó una clase para recrear y relacionar los datos y el valor dado en el documento del taller.
        config = new Config();
        //Se pasa el contexto de la actividad para poder acceder a los recursos strings
        config.init(this);
        //Se crear los adapters y se relaciona los datos con los componentes de la actividad
        setData();

    }

    public void getCost(View v){
        if(validar()){
            //Se obtienen los datos ingresados
            Material material = (Material) cmbMaterial.getSelectedItem();
            Dije dije = (Dije) cmbDije.getSelectedItem();
            TipoDije tipoDije = (TipoDije) cmbTipoDije.getSelectedItem();
            int moneda = cmbMoneda.getSelectedItemPosition();

            //Se obtiene la manilla que coincida con los datos capturados
            Manilla manilla = config.getManilla(material, dije, tipoDije);
            Double total = Integer.parseInt(cantidad.getText().toString()) * manilla.getValorByCurrency(moneda);

            //Se muestra el valor de la manilla seleccionada en formato moneda.
            NumberFormat format = NumberFormat.getCurrencyInstance();
            txtResultado.setText(format.format(total));
        }


    }

    private void setData(){
        //Traemos las opciones de un array de Strings
        monedas = getResources().getStringArray(R.array.moneda);

        //Creamos el adapter indicando donde se va a colocar
        //como se va a visualizar y que se va a mostrar
        ArrayAdapter<Material> adapterMaterial = new ArrayAdapter<Material>(this, android.R.layout.simple_spinner_item, config.getMateriales());
        adapterMaterial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbMaterial.setAdapter(adapterMaterial);

        ArrayAdapter<Dije> adapterDije = new ArrayAdapter<Dije>(this, android.R.layout.simple_spinner_item, config.getDijes());
        adapterDije.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbDije.setAdapter(adapterDije);

        ArrayAdapter<TipoDije> adapterTipoDije = new ArrayAdapter<TipoDije>(this, android.R.layout.simple_spinner_item, config.getTiposDije());
        adapterTipoDije.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbTipoDije.setAdapter(adapterTipoDije);

        ArrayAdapter<String> adapterMoneda = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, monedas);
        adapterMoneda.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbMoneda.setAdapter(adapterMoneda);

    }

    public boolean validar(){
        //Se valida que la cantidad de manillas haya sido ingresado.
        if(cantidad.getText().toString().isEmpty()){
            cantidad.setError(getResources().getString(R.string.error_cantidad));
            cantidad.requestFocus();
            return false;
        }

        return true;
    }



}
