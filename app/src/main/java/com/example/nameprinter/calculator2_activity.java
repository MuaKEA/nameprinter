package com.example.nameprinter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculator2_activity extends AppCompatActivity implements View.OnClickListener {
    EditText numb1;
    EditText numb2;
    TextView Resualt;
    Button Calulate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2_activity);

        numb1=findViewById(R.id.numb1);
        numb2=findViewById(R.id.numb2);
        Resualt=findViewById(R.id.R1);
        Calulate=(Button)findViewById(R.id.Calculate);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(savedInstanceState!=null){
            Resualt.setText(savedInstanceState.get("resualtat").toString());
            Resualt.setTextColor(Color.GREEN);
        }


        if(bundle != null){
            int c  = bundle.getInt("Resualt");
              numb1.setText(c +"");
        }

        Calulate.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {
     int number1=Integer.parseInt(numb1.getText().toString());
     int number2=Integer.parseInt(numb2.getText().toString());
     int resualt=number1 + number2;
        Resualt.setText("resultat "+resualt);
        Resualt.setTextColor(Color.GREEN);


    }
@Override
public void onSaveInstanceState(Bundle outstate) {
    super.onSaveInstanceState(outstate);
    outstate.putString("resualtat", Resualt.getText().toString());
}

}
