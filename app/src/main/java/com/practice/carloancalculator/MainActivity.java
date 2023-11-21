package com.practice.carloancalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DecimalFormat mDecimalFormat = new DecimalFormat("#.##");
    Button saveButton;
    Button calculate;
    EditText loanInput;
    EditText termInput;
    EditText downPaymentInput;
    EditText aprInput;
    TextView monthlyPayment;
    double loanInputNUM;
    int termInputNUM;
    double downPaymentNUM;
    double aprNum;
    String tempValue;
    double monthly;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDecimalFormat.setRoundingMode(RoundingMode.CEILING);

        saveButton = (Button)findViewById(R.id.saveButton);
        calculate = (Button)findViewById(R.id.calculateButton);
        loanInput = (EditText)findViewById(R.id.loanInputText);
        termInput = (EditText)findViewById(R.id.termInputText);
        downPaymentInput = (EditText)findViewById(R.id.downPaymentInputText);
        aprInput = (EditText)findViewById(R.id.aprInputText);
        monthlyPayment = (TextView)findViewById(R.id.payment_TextView);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Loan Amount Parsing and Storage
                tempValue = loanInput.getText().toString();         //assigns user input into a String temporary field for parsing

                //User input validation for empty field
                if(TextUtils.isEmpty(tempValue)) {
                    loanInput.setError("Please enter a loan amount");
                    return;
                }

                loanInputNUM = Double.parseDouble(tempValue);       //parses string temporary field and converts into a double
                UserInputStorage.setLoanAmount(loanInputNUM);       //stores double in the UserInputStorage

                //Loan Term Parsing and Storage
                tempValue = termInput.getText().toString();         //assigns user input into a String temporary field for parsing

                //User input validation for empty field
                if(TextUtils.isEmpty(tempValue)) {
                    termInput.setError("Please enter a loan term");
                    return;
                }

                termInputNUM = Integer.parseInt(tempValue);         //parses string temporary field and converts into a integer
                UserInputStorage.setLoanLength(termInputNUM);       //stores integer in the UserInputStorage

                //Down Payment Parsing and Storage
                tempValue = downPaymentInput.getText().toString();  //assigns user input into a String temporary field for parsing

                //User input validation for empty field
                if(TextUtils.isEmpty(tempValue)) {
                    downPaymentInput.setError("Please enter a down payment amount");
                    return;
                }

                downPaymentNUM = Double.parseDouble(tempValue);     //parses string temporary field and converts into a double
                UserInputStorage.setDownPayment(downPaymentNUM);    //stores double in the UserInputStorage

                //APR Parsing and Storage
                tempValue = aprInput.getText().toString();          //assigns user input into a String temporary field for parsing

                //User input validation for empty field
                if(TextUtils.isEmpty(tempValue)) {
                    aprInput.setError("Please enter an APR");
                    return;
                }

                aprNum = Double.parseDouble(tempValue);             //parses string temporary field and converts into a double
                UserInputStorage.setApr(aprNum);                    //stores double in the UserInputStorage
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monthly = LoanCalculator.getPayment();                      //calculates monthly payment and assigns it to double variable for parsing into string
                tempValue = mDecimalFormat.format(monthly);                 //converts double variable into a String variable while formatting the value into 2 decimals
                monthlyPayment.setText(String.format("$%s", tempValue));    //sets the text in the TextView to the value of the String variable
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}