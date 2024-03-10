package com.example.expensepalnning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Income extends AppCompatActivity {
    public static final String NUM = "NUM";
    private EditText salaryEditText;
    private EditText bonusesEditText;
    private EditText ExtraIncomeEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        salaryEditText = findViewById(R.id.ed1);
        ExtraIncomeEditText = findViewById(R.id.ed2);
        bonusesEditText = findViewById(R.id.ed3);
        calculateButton = findViewById(R.id.bt1);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateIncome();
            }
        });
    }

    private void calculateIncome() {

        String salaryStr = salaryEditText.getText().toString();
        String bonusesStr = bonusesEditText.getText().toString();
        String IncomeStr = ExtraIncomeEditText.getText().toString();


        if (salaryStr.isEmpty() || bonusesStr.isEmpty() || IncomeStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Parse input to numeric values
        double annualSalary = Double.parseDouble(salaryStr);
        double annualBonuses = Double.parseDouble(bonusesStr);
        double annualIncome = Double.parseDouble(IncomeStr);
        int totalIncome = (int) (annualSalary + annualBonuses + annualIncome);

        // Get the totalExpense passed from calculator activity
        int totalExpense = getIntent().getIntExtra("totalExpense", 0);

        // Start piechart activity with both totalIncome and totalExpense passed as extras
        Intent pieChartIntent = new Intent(Income.this, piechart.class);
        pieChartIntent.putExtra("totalIncome", totalIncome);
        pieChartIntent.putExtra("totalExpense", totalExpense);
        startActivity(pieChartIntent);


    }
}
