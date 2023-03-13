package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        llMain=findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(view -> {
            int wt=Integer.parseInt(edtWeight.getText().toString());
            int ft=Integer.parseInt(edtHeightFt.getText().toString());
            int in=Integer.parseInt(edtHeightIn.getText().toString());

            int totalIn=ft*12+in;

            double totalCm=totalIn*2.53;

            double totalM=totalCm/100;

            double bmi=wt/(totalM*totalM);

            if(bmi>25){
                txtResult.setText("Overweight");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
            }else if(bmi<18){
                txtResult.setText("Underweight");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
            }else{
                txtResult.setText("Healthy");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
            }
        });



    }
}