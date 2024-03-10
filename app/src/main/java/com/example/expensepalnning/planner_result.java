package com.example.expensepalnning;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class planner_result extends AppCompatActivity {
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner_result);

        resultTextView = findViewById(R.id.resultTextView);

        // Retrieve the calculated result and event name from the intent
        double result = getIntent().getDoubleExtra("result", 0.0);
        String eventName = getIntent().getStringExtra("eventName");

        // Display the result and event name
        resultTextView.setText(String.format("Event Name: %s\nYou daily expense should not be more than: %.2f", eventName, result));
    }

}
