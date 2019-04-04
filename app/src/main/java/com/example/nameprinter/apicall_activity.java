package com.example.nameprinter;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


public class apicall_activity extends AppCompatActivity {
String webapiadress;
TextView apiresponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicall);
        Button apirequestbutton=(Button)findViewById(R.id.apicall);
        final TextView apicity=findViewById(R.id.apicity);
        apiresponse=findViewById(R.id.apiresponse);

        apirequestbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webapiadress="https://api.openweathermap.org/data/2.5/weather?q=" +apicity.getText() + "&APPID=bc0f58134016ebbb041d2cfedffa974c&units=metric";
                apicall ap =new apicall();
                ap.execute();
            }
        });

}
    public class apicall extends AsyncTask<String,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                URL url=new URL(webapiadress);
                HttpURLConnection con=(HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
               String reponse=bf.readLine();
                JSONObject json=new JSONObject(reponse);
                String[] stringarray=json.getJSONObject("main").toString().split(",");

                apiresponse.setText("current weather: "+ stringarray[0].substring(8)+ "°C");

            } catch (Exception e) {

            }

            return null;
        }
    }
    }
