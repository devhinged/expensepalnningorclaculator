package com.example.expensepalnning;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class piechart extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView tv3 = findViewById(R.id.tv3);

        int totalExpense = getIntent().getIntExtra("totalExpense", 0);
        tv1.setText("Total Expense: Rs " + totalExpense);

        int totalIncome = getIntent().getIntExtra("totalIncome", 0);
        tv2.setText("Total Income: Rs " + totalIncome);

        int profitloss = (int)(totalIncome-totalExpense);
        tv3.setText("Profit/Loss: Rs " + profitloss);


        if (profitloss < 0) {
            tv3.append("\nPlease reduce your expenses.");
        }else{
            tv3.append("\nyou are managing your expense well!");
            }
    }
}
