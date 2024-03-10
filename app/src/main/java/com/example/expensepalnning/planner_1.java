package com.example.expensepalnning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class planner_1 extends AppCompatActivity {
    private EditText eventNameEditText, incomeEditText, daysEditText, eventExpenseEditText;
    private Button nextButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner1);

        eventNameEditText = findViewById(R.id.ed1);
        incomeEditText = findViewById(R.id.ed2);
        daysEditText = findViewById(R.id.ed3);
        eventExpenseEditText = findViewById(R.id.ed4);
        nextButton = findViewById(R.id.bt1);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResult();
            }
        });
    }

    private void calculateAndDisplayResult() {
        String eventName = eventNameEditText.getText().toString();
        String incomeStr = incomeEditText.getText().toString();
        String eventExpenseStr = eventExpenseEditText.getText().toString();
        String daysStr = daysEditText.getText().toString();

        if (eventName.isEmpty() || incomeStr.isEmpty() || eventExpenseStr.isEmpty() || daysStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double income = Double.parseDouble(incomeStr);
        double eventExpense = Double.parseDouble(eventExpenseStr);
        int days = Integer.parseInt(daysStr);

        if (days <= 0) {
            daysEditText.setText("Invalid number of days left, Please enter a valid positive number");
            return;
        }

        double result = ((income - eventExpense)/days);

        Intent intent = new Intent(planner_1.this, planner_result.class);
        intent.putExtra("result", result);
        intent.putExtra("eventName", eventName); // Passing event name to planner_result activity
        startActivity(intent);
    }

}

