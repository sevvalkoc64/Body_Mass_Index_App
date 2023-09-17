package com.example.vucutkitleindexi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputEditText;

public class HesaplamaActivity extends AppCompatActivity {

    private Switch aSwitch;
    private Button buttonHesapla;
    private TextInputEditText textInputBoy, textInputKilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesaplama);

        aSwitch= findViewById(R.id.switchDarkMode); //darkmode secme butonu

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aSwitch.isChecked()){
                    getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        buttonHesapla= findViewById(R.id.buttonHesapla);
        textInputBoy= findViewById(R.id.TextInputBoy);
        textInputKilo= findViewById(R.id.TextInputKilo);


        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double boy = Double.valueOf(textInputBoy.getText().toString());
                int kilo = Integer.parseInt(textInputKilo.getText().toString());
                double vucutKitleIndex = kilo/(boy*boy);

                //vki veri alma
               Intent i =  new Intent(HesaplamaActivity.this, SonucActivity.class);
               i.putExtra("vucutKitleindex", vucutKitleIndex);
               startActivity(i);
            }
        });



    }
}