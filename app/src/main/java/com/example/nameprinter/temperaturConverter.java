package com.example.nameprinter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

public class temperaturConverter extends AppCompatActivity {
    double numb;
    double roundoff;
    TextView t;
    TextView result;
    RadioGroup tempradio;
    String Tag= "here somthing went wrong";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatur_converter);


        tempradio = findViewById(R.id.radiogroup2);
        t = findViewById(R.id.number);
        result = findViewById(R.id.result);




        tempradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d(Tag,checkedId +" ");

                if (checkedId == R.id.celsius) {
                    Log.d(Tag,numb+"");

                    numb = Integer.parseInt(t.getText().toString());
                    numb=numb-32;
                    numb=(numb/1.8);

                    result.setText("fra F til C " + numb);

                } else if (checkedId == R.id.fahrenheit) {


                    numb = Integer.parseInt(t.getText().toString());
                    numb = (int) (numb * 1.8);
                    numb=numb+ 32;
                    result.setText("fra C til F " + numb);
                }
            }

        });






    }
}