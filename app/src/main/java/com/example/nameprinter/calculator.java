package com.example.nameprinter;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class calculator extends AppCompatActivity implements View.OnClickListener {
    Button a0;
    Button a1;
    Button a2;
    Button a3;
    Button a4;
    Button a5;
    Button a6;
    Button a7;
    Button a8;
    Button a9;
    Button adivide;
    Button aminus;
    Button amulti;
    Button aplus;
    Button aequals;
    Button adelete;
    Button acomma;
    TextView resualt;
    int temp;
    String[] d;
    String[] a;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        startup();
        a0.setOnClickListener(this);
        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        a5.setOnClickListener(this);
        a6.setOnClickListener(this);
        a7.setOnClickListener(this);
        a8.setOnClickListener(this);
        a9.setOnClickListener(this);
        adelete.setOnClickListener(this);
        acomma.setOnClickListener(this);
        aequals.setOnClickListener(this);
        aplus.setOnClickListener(this);
        aminus.setOnClickListener(this);
        adivide.setOnClickListener(this);
        amulti.setOnClickListener(this);
    }

    private void startup() {

        a0 = findViewById(R.id.buttonnul);
        a1=findViewById(R.id.button1);
        a2=findViewById(R.id.button2);
        a3=findViewById(R.id.button3);
        a4=findViewById(R.id.button4);
        a5=findViewById(R.id.button5);
        a6=findViewById(R.id.button6);
        a7=findViewById(R.id.button7);
        a8=findViewById(R.id.button8);
        a9=findViewById(R.id.button9);
        a2=findViewById(R.id.button2);
        a2=findViewById(R.id.button2);
        adivide=findViewById(R.id.buttondivide);
        aminus=findViewById(R.id.buttonminus);
        amulti=findViewById(R.id.buttonmulti);
        aplus=findViewById(R.id.buttonplus);
        aequals=findViewById(R.id.buttonequals);
        adelete=findViewById(R.id.buttondel);
        acomma=findViewById(R.id.buttondot);
        resualt=findViewById(R.id.resualt);
    }

    @Override
    public void onClick(View v) {
        Button everythingelse=(Button)v;

        if(!everythingelse.getText().toString().matches("[=]|Slet")){
            resualt.setText(resualt.getText().toString() + everythingelse.getText().toString());
            Log.d("button pressed! if  ",everythingelse.getText().toString());

        }else
           Log.d("button pressed! else  ",everythingelse.getText().toString());

        switch (v.getId()) {

                case R.id.buttondel:
                    String delete = resualt.getText().toString();
                    String removecharictor = delete.substring(0, delete.length() - 1);
                    resualt.setText(removecharictor);
                    break;

                    case R.id.buttonequals:
                    Integer calculate = 0;
                    d = resualt.getText().toString().split("[+-/*]");
                    a = resualt.getText().toString().split("");

                    for (int i = 0; i < a.length; i++) {

                        if (a[i].matches("[+-/*]")) {
                            calculate = i;
                        }

                    }
                    if (a[calculate].equals("-")) {
                        calculate = Integer.parseInt(d[0]) - Integer.parseInt(d[1]);

                    } else if (a[calculate].equals("+")) {
                        calculate = Integer.parseInt(d[0]) + Integer.parseInt(d[1]);

                    } else if (a[calculate].equals("/")) {
                        calculate = Integer.parseInt(d[0]) / Integer.parseInt(d[1]);

                    } else if (a[calculate].equals("*")) {
                        calculate = Integer.parseInt(d[0]) * Integer.parseInt(d[1]);
                    }

                    resualt.setText(calculate.toString());

                    break;
            }


    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
