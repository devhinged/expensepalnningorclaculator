package com.example.expensepalnning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class select extends AppCompatActivity {
    public static final String Num = "NUM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Button bt1 = findViewById(R.id.bt1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button bt2 = findViewById(R.id.bt2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView tv2 = findViewById(R.id.tv2);
        Intent intent = new Intent();
        intent = getIntent();

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(select.this, calculator.class );
                startActivity(i);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(select.this, planner_1.class);
                startActivity(i);
            }
        });

    }
}