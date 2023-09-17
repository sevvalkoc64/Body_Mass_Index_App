package com.example.vucutkitleindexi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {

    private Button buttonTekrarHesapla;
    private Switch aSwitch;
    private TextView textViewVucutKitleIndeksi;
    private TextView textViewSonuc;
    private double vucutKitleIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        textViewVucutKitleIndeksi= findViewById(R.id.textViewVucutKitleIndeksi);
        textViewSonuc= findViewById(R.id.textViewSonuc);

        //vki veri cekme
        vucutKitleIndex = getIntent().getDoubleExtra("vucutKitleindex", vucutKitleIndex);
        if(vucutKitleIndex<18.50 && vucutKitleIndex>0){
            textViewVucutKitleIndeksi.setText(""+vucutKitleIndex);
            textViewSonuc.setText("Düşük Kilolusunuz");
        }

        if(vucutKitleIndex>18.50 && vucutKitleIndex<24.99){
            textViewVucutKitleIndeksi.setText(""+vucutKitleIndex);
            textViewSonuc.setText("Normal Kilolusunuz");
        }

        if(vucutKitleIndex>25.0 && vucutKitleIndex<29.99){
            textViewVucutKitleIndeksi.setText(""+vucutKitleIndex);
            textViewSonuc.setText("Fazla Kilolusunuz");
        }

        if(vucutKitleIndex>=30.0){
            textViewVucutKitleIndeksi.setText(""+vucutKitleIndex);
            textViewSonuc.setText("Obezsiniz ");
        }

        buttonTekrarHesapla= findViewById(R.id.buttonTekrarHesapla);
        buttonTekrarHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SonucActivity.this, MainActivity.class));
            }
        });

    }
}