package com.example.nameprinter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class KgtoLb_activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    int numb;
    RadioGroup kgradio;
    TextView t;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kgto_lb_activity);

        kgradio = findViewById(R.id.radiogroup2);
        t = findViewById(R.id.number);
        result = findViewById(R.id.result);
        kgradio.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.kgradio) {
            numb = Integer.parseInt(t.getText().toString());
            numb = (int) (numb / 2.2046);
            result.setText("fra lb til kg " + numb);
        } else if (checkedId == R.id.Lbradio) {
            numb = Integer.parseInt(t.getText().toString());
            numb = (int) (numb * 2.2046);
            result.setText("fra kg til lb " + numb);
        }
    }
}




