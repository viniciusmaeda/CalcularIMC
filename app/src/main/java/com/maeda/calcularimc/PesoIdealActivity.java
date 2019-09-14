package com.maeda.calcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PesoIdealActivity extends AppCompatActivity {

    private EditText campoSexo;
    private EditText campoAltura;
    private EditText campoPesoIdeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_ideal);
    }

    public void calcularPesoIdeal(View view) {
        instanciarCampos();

        // implementar o cálculo

        double pesoIdeal = 0;
        double altura = Double.parseDouble(campoAltura.getText().toString());
        String sexo = campoSexo.getText().toString();

        if (sexo.equals("M")) { // sexo == "M"
            pesoIdeal = altura - 100 - ((altura-150) / 4);

        } else if (sexo.equals("F")) { // sexo == "F"
            pesoIdeal = altura - 100 - ((altura-150) / 2);

        } else {
            Toast.makeText(this, "Digite M ou F", Toast.LENGTH_SHORT).show();

        }
        campoPesoIdeal.setText(pesoIdeal + "");


    }

    public void limparPesoIdeal(View view) {

        instanciarCampos();

        campoAltura.setText("");
        campoSexo.setText("");
        campoPesoIdeal.setText("");
        campoAltura.requestFocus();
    }

    private void instanciarCampos() {
        campoAltura = (EditText) findViewById(R.id.edt_peso_ideal_altura);
        campoSexo = (EditText) findViewById(R.id.edt_peso_ideal_sexo);
        campoPesoIdeal = (EditText) findViewById(R.id.edt_peso_ideal_peso_ideal);
    }


}
