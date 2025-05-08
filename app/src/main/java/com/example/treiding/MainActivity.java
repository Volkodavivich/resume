package com.example.treiding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed_rsi;
    EditText ed_dif;
    EditText ed_dea;
    EditText ed_macd;
    EditText ed_sar;
    EditText ed_price;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_rsi = findViewById(R.id.ed_rsi);
        ed_dif = findViewById(R.id.ed_dif);
        ed_dea = findViewById(R.id.ed_dea);
        ed_macd = findViewById(R.id.ed_macd);
        ed_sar = findViewById(R.id.ed_sar);
        ed_price = findViewById(R.id.ed_price);
        bt = findViewById(R.id.bt);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            double rsi1 = Double.parseDouble(ed_rsi.getText().toString());
            double rsi = 0;
            if (rsi1 >= 70) {
                rsi = -1;
            }
            if (rsi1 <= 30) {
                rsi = 1;
            }

             double dif1 = Double.parseDouble(ed_dif.getText().toString());
             double dea1 = Double.parseDouble(ed_dea.getText().toString());
             double macd1 = Double.parseDouble(ed_macd.getText().toString());
             double dif, macd;

             if (dif1 > dea1) {
                 dif = 1;
             } else {
                 dif = -1;
             }
             if (macd1 > 0) {
                 macd = 1;
             } else {
                 macd = -1;
             }


             double sar1 = Double.parseDouble(ed_sar.getText().toString());
             double price = Double.parseDouble(ed_price.getText().toString());
             double sar = 0;
             double sar01 = sar1 * 1.001;
             if (price > sar01) {
                 sar = 1;
             } else if (price < sar01) {
                 sar = -1;
             }

             double sum = rsi + dif + macd + sar;
             if (sum > 2) {

                 Toast.makeText(MainActivity.this, "Покупай парень", Toast.LENGTH_SHORT).show();
             } else if (sum < 2) {
                 Toast.makeText(MainActivity.this, "Продавай парень", Toast.LENGTH_SHORT).show();
             } else {
                 Toast.makeText(MainActivity.this, "НЕЛЕЗЬ парень", Toast.LENGTH_SHORT).show();
             }


//             ed_rsi.setText("");
//             ed_dif.setText("");
//             ed_dea.setText("");
//             ed_macd.setText("");
//             ed_sar.setText("");
//             ed_price.setText("");
            }
        });




























    }


}