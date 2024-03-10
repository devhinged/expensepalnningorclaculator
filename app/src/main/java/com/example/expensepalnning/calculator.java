package com.example.expensepalnning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class calculator extends AppCompatActivity {
    public static final String NUM = "NUM";
    private EditText TransportEditText;
    private EditText GroceriesEditText;
    private EditText EducationEditText;
    private EditText LeisureEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        TransportEditText = findViewById(R.id.ed1);
        GroceriesEditText = findViewById(R.id.ed2);
        EducationEditText = findViewById(R.id.ed3);
        LeisureEditText = findViewById(R.id.ed4);
        calculateButton = findViewById(R.id.bt1);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateExpenses();
            }
        });
    }

    private void calculateExpenses() {
        // Get input from EditText fields
        String TransportStr = TransportEditText.getText().toString();
        String GroceriesStr = GroceriesEditText.getText().toString();
        String EducationStr = EducationEditText.getText().toString();
        String LeisureStr = LeisureEditText.getText().toString();

        // Validate input (you can add more validation as needed)
        if (TransportStr.isEmpty() || GroceriesStr.isEmpty() || EducationStr.isEmpty() || LeisureStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Parse input to numeric values
        double TransportExpense = Double.parseDouble(TransportStr);
        double GroceriesExpense = Double.parseDouble(GroceriesStr);
        double EducationExpense = Double.parseDouble(EducationStr);
        double LeisureExpenses = Double.parseDouble(LeisureStr);

        int totalExpense = (int) (TransportExpense + GroceriesExpense + EducationExpense + LeisureExpenses);

        // Start Income activity with the totalExpense passed as an extra
        Intent incomeIntent = new Intent(calculator.this, Income.class);
        incomeIntent.putExtra("totalExpense", totalExpense);
        startActivity(incomeIntent);


    }
}
