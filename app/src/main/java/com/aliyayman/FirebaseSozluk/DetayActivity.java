package com.aliyayman.FirebaseSozluk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private TextView textViewing,textViewtur;
    private Kelimeler kelime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        textViewing=findViewById(R.id.textViewing);
        textViewtur=findViewById(R.id.textViewtur);
        kelime= (Kelimeler) getIntent().getSerializableExtra("nesne");

        textViewing.setText(kelime.getIngilizce());
        textViewtur.setText(kelime.getTurkce());



    }
}