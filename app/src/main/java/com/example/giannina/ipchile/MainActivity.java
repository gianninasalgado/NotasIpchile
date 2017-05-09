package com.example.giannina.ipchile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    Button info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siguiente =(Button)findViewById(R.id.btn_siguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                Intent siguiente = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(siguiente);
            }

        });



        info = (Button) findViewById(R.id.btn_info);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(info);
            }

        });




    }
}
