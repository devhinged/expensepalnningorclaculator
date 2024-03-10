package com.example.expensepalnning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class planner_or_calculator extends AppCompatActivity {

    private EditText mobileNumberEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner_or_calculator);

        mobileNumberEditText = findViewById(R.id.ed1);
        String userName = getIntent().getStringExtra("userName");
        TextView tv3 = findViewById(R.id.tv3);
        tv3.setText(userName);
        nextButton = findViewById(R.id.bt1);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkMobileNumber();
            }
        });
    }

    private void checkMobileNumber() {
        String mobileNumberStr = mobileNumberEditText.getText().toString();


        if (mobileNumberStr.length() < 9) {
            Toast.makeText(this, "Mobile number must be at least 9 digits.", Toast.LENGTH_SHORT).show();
        } else {
            Intent i2 = new Intent(planner_or_calculator.this, planner.class);
            startActivity(i2);
        }
    }
}

