package com.maeda.calcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void irParaIMC(View view) {
        startActivity(new Intent(PrincipalActivity.this,
                MainActivity.class));
    }

    public void irParaPesoIdeal(View view) {
        startActivity(new Intent(PrincipalActivity.this,
                PesoIdealActivity.class));
    }

}
