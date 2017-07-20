package com.example.ferdy.makan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Win_Layout extends AppCompatActivity {
    private TextView cong ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win__layout);
        cong = (TextView) findViewById(R.id.Congratz);
        String angka = getIntent().getStringExtra("angka");
        String gg = getIntent().getStringExtra("gg");
        cong.setText("Kamu Berhasil \n Nilainya adalah \n " + (angka) +" "+ gg );
    }
}
