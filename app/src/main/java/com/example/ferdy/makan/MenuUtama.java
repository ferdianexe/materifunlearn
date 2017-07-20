package com.example.ferdy.makan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Random;

public class MenuUtama extends AppCompatActivity implements View.OnClickListener {
    private Button random ;
    private int size ;
    private EditText batasAtas , batasBawah ;
    private TextView result ,systemresult , statusresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        random = (Button)findViewById(R.id.Random);
        batasAtas = (EditText)findViewById(R.id.EditAtas);
        batasBawah = (EditText) findViewById(R.id.EditBawah);
        systemresult = (TextView) findViewById(R.id.SystemView);
        statusresult = (TextView)findViewById(R.id.ResultView);
        result = (TextView) findViewById(R.id.Result);
        random.setOnClickListener(this);
       /* random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bawah = getValue(batasBawah.getText().toString()) ;

                int atas = getValue(batasAtas.getText().toString()) ;
                if(atas == -1 || bawah == -1 ){
                    return ;
                }
                if( atas <= bawah){
                    result.setText("Nilai bawah tidak boleh lebih dari nilai atas");
                }else{
                    int hasil ;
                    Random rand = new Random();
                    hasil = rand.nextInt(atas) + bawah;
                    result.setText(hasil);
                }
            }
        });*/
    }
    private int getValue(String value){
        try {
               return Integer.parseInt(value);
        }catch (NumberFormatException e){
                statusresult.setText("MASUKAN ANGKA SAJA");
                return -1 ;
        }
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.Random :
                generate(); // mengeluarkan hasil
               break ;
       }
    }
    private void generate(){
        int bawah = getValue(batasBawah.getText().toString().trim()) ;
        int atas = getValue(batasAtas.getText().toString().trim()) ;
        if(atas == -1 || bawah == -1 ){
            return ;
        }
        if( atas <= bawah){
            String s = "Nilai bawah tidak boleh lebih dari nilai atas";
            statusresult.setTextSize(20);
            statusresult.setText(s);
        }else{
            int hasil = 0 ; int system = 0 ;
            String berhasil = new String();
            Random rand = new Random();
            hasil = rand.nextInt((atas-bawah+1)) + bawah;
            system = rand.nextInt((atas-bawah+1)) + bawah;
            if(hasil==system) {
                berhasil = " YOU WIN" ;
                changeActi(hasil+"",system+"");
                result.setText(String.valueOf(hasil));
                systemresult.setText(String.valueOf(system));
                statusresult.setText(berhasil);
            }else{
                 berhasil = "YOU LOSE";
                 result.setText(String.valueOf(hasil));
                 systemresult.setText(String.valueOf(system));
                 statusresult.setText(berhasil);
            }


        }
    }
    private void changeActi(String angkas , String gg){
        Intent angka  = new Intent(getApplicationContext(),Win_Layout.class);
        angka.putExtra("angka",angkas);
        angka.putExtra("gg",gg);
        startActivity(angka);

    }
}
