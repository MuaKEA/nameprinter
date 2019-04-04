package com.example.nameprinter;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class BMI_activity extends AppCompatActivity implements View.OnClickListener {
EditText KG;
EditText height;
TextView result;
Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_activity);

        KG=findViewById(R.id.KgInput);
        height=findViewById(R.id.HøjdeInput);
        result=findViewById(R.id.Resultat);
        Calculate=findViewById(R.id.udregn_btn);
        Calculate.setOnClickListener(this);


        if(savedInstanceState != null){
            result.setText(savedInstanceState.getString("Result"));
            Log.d("getting value ", result.getText().toString());
        }

    }

    @Override
    public void onClick(View v) {
        double højde= Double.parseDouble(height.getText().toString());
        højde=højde/100;
        højde=højde*2;
        Log.d("udregning ",højde +" ");
        double weight=Double.parseDouble(KG.getText().toString());
        Log.d("udregning ",weight +" ");
        String endresult = new DecimalFormat("#.00").format(weight/højde);

        Log.d("udregning",endresult +" ");


        result.setText("din BMI er: " + endresult);
        Toast.makeText(getApplicationContext(), endresult + " ", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Result",result.getText().toString());

    }
}
