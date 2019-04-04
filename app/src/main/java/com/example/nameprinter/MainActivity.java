package com.example.nameprinter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   private TextView inputtext;
   private TextView printname;
   private Button printbuttom;

   private Button weightactivity;
   private Button openweatheractivity;
   private Button calculatoractivity;
   private Button tempConverteractivity;
   private Button BMI_activity;
   private Button currentcyactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         init();


        }

      public void init(){
          inputtext = findViewById(R.id.nameinput);
          printname = findViewById(R.id.printname);
          printbuttom = (Button) findViewById(R.id.nameprinterbuttom);

          openweatheractivity = (Button) findViewById(R.id.openweatheractivity);
          calculatoractivity = (Button) findViewById(R.id.calculatoractivity);
          tempConverteractivity=(Button)findViewById(R.id.tempConverteractivity);
          weightactivity=(Button)findViewById(R.id.weightactivity);
          BMI_activity=(Button)findViewById(R.id.BMI_btn);
          currentcyactivity=(Button)findViewById(R.id.currentcy_btn);
          printbuttom.setOnClickListener(this);
          openweatheractivity.setOnClickListener(this);
          calculatoractivity.setOnClickListener(this);
          tempConverteractivity.setOnClickListener(this);
          weightactivity.setOnClickListener(this);
          BMI_activity.setOnClickListener(this);
          currentcyactivity.setOnClickListener(this);


      }

    @Override
    public void onClick (View view){

        switch(view.getId()) {

            case R.id.nameprinterbuttom:
                printname.setText("hallo " +inputtext.getText().toString());

                break;

            case R.id.calculatoractivity:
                Intent calculator_btn= new Intent(this,calculator.class);
                startActivity(calculator_btn);
                break;

            case R.id.openweatheractivity:
                Intent intent = new Intent(this, apicall_activity.class);
                startActivity(intent);
                break;

            case R.id.weightactivity:
               Intent weightintent=new Intent(this,KgtoLb_activity.class);
                startActivity(weightintent);
                break;

            case R.id.tempConverteractivity:
                Intent tempconverter= new Intent(this,temperaturConverter.class);
                startActivity(tempconverter);
               break;

            case R.id.BMI_btn:
                Intent BmiIntent= new Intent(this, BMI_activity.class);
                startActivity(BmiIntent);

                break;


            case R.id.currentcy_btn:
                Intent currentcyactivity= new Intent(this,currency_activity.class);
                startActivity(currentcyactivity);
        }


    }
    }







