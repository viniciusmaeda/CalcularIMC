package com.maeda.calcularimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText campoPeso = (EditText) findViewById(R.id.edt_peso);
        final EditText campoAltura = (EditText) findViewById(R.id.edt_altura);
        final EditText campoIMC = (EditText) findViewById(R.id.edt_imc);
        final EditText campoClassificacaoIMC = (EditText) findViewById(R.id.edt_classificacao_imc);
        Button botaoCalcular = (Button) findViewById(R.id.btn_calcular);
        Button botaoLimpar = (Button) findViewById(R.id.btn_limpar);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // obtem as strings dos campos
                String pesoString = campoPeso.getText().toString();
                String alturaString = campoAltura.getText().toString();

                // converte para double
                double pesoDouble = Double.parseDouble(pesoString);
                double alturaDouble = Double.parseDouble(alturaString);

                // realiza o cálculo
                double imc = pesoDouble / (alturaDouble * alturaDouble);
                imc = Math.floor(imc * 100) / 100;

                // atribui o valor ao campo de IMC
                campoIMC.setText(Double.toString(imc));

                // variável para armazer texto de classificação
                String classificacaoIMC = "";

                // classificar o imc
                if (imc < 18.5) {
                    classificacaoIMC = "Magreza";
                } else if (imc < 24.9) {
                    classificacaoIMC = "Normal";
                } else if (imc < 29.9) {
                    classificacaoIMC = "Sobrepeso";
                } else if (imc < 39.9) {
                    classificacaoIMC = "Obesidade";
                } else {
                    classificacaoIMC = "Obesidade Grave";
                }

                // mostra a classificação
                campoClassificacaoIMC.setText(classificacaoIMC);


            }
        });

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoPeso.setText("");
                campoAltura.setText("");
                campoIMC.setText("");
                campoPeso.requestFocus();
            }
        });

    }

}

