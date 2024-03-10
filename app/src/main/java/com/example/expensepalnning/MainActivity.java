package com.example.expensepalnning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String NUM = "NUM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView tv1 = findViewById(R.id.tv1);

        TextView tv2 = findViewById(R.id.tv2);
        ImageView image = findViewById(R.id.image);
        Button bt1 =findViewById(R.id.bt1);
        EditText ed1 = findViewById(R.id.ed1);



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = ed1.getText().toString();
                Intent i = new Intent(MainActivity.this, planner_or_calculator.class);
                i.putExtra("userName", userName);
                startActivity(i);
            }
        });



    }

    }



