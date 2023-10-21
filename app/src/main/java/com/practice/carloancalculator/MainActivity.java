package com.practice.carloancalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button saveButton;
    EditText loanInput;
    EditText termInput;
    double loanInputNUM;
    int termInputNUM;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button)findViewById(R.id.saveButton);
        loanInput = (EditText)findViewById(R.id.loanInputText);
        termInput = (EditText)findViewById(R.id.termInputText);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Loan Amount Parsing and Storage
                String tempValue = loanInput.getText().toString();  //assigns user input into a String temporary field for parsing
                loanInputNUM = Double.parseDouble(tempValue);       //parses string temporary field and converts into a double
                UserInputStorage.setLoanAmount(loanInputNUM);       //stores double in the UserInputStorage

                //Loan Term Parsing and Storage
                tempValue = termInput.getText().toString();         //assigns user input into a String temporary field for parsing
                termInputNUM = Integer.parseInt(tempValue);         //parses string temporary field and converts into a integer
                UserInputStorage.setLoanLength(termInputNUM);       //stores integer in the UserInputStorage

                //Storage Validation
                Log.d(TAG, "onClick: Loan Amount: " + UserInputStorage.getLoanAmount());    //validation to make sure its storing it correctly
                Log.d(TAG, "onClick: Loan Term: " + UserInputStorage.getLoanLength());       //validation to make sure its storing it correctly
            }
        });
    }
}