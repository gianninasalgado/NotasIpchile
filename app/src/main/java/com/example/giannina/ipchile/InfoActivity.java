package com.example.giannina.ipchile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {

    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        volver =(Button)findViewById(R.id.btn_volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                Intent volver = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(volver);
            }

        });
    }
}
