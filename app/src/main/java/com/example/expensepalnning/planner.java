package com.example.expensepalnning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class planner extends AppCompatActivity {

    private EditText verificationCodeEditText;
    private Button verifyButton;

    // Define a predefined verification code
    private static final String PREDEFINED_VERIFICATION_CODE = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        verificationCodeEditText = findViewById(R.id.ed4);
        verifyButton = findViewById(R.id.bt1);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredVerificationCode = verificationCodeEditText.getText().toString();

                if (enteredVerificationCode.equals(PREDEFINED_VERIFICATION_CODE)) {
                    Intent i = new Intent(planner.this,select.class);
                    startActivity(i);
                } else {
                    Toast.makeText(planner.this, "Verification code is incorrect. Please try again.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
