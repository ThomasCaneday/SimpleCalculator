package com.codecademy.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Create objects for design URIs
        EditText firstNumber = findViewById(R.id.number1);
        EditText secondNumber = findViewById(R.id.number2);
        RadioGroup operators = findViewById(R.id.operators);
        RadioButton add = findViewById(R.id.add);
        RadioButton subtract = findViewById(R.id.subtract);
        RadioButton multiply = findViewById(R.id.multiply);
        RadioButton divide = findViewById(R.id.divide);
        Button equals = findViewById(R.id.equals);
        TextView result = findViewById(R.id.result);

//        Add functionality to objects
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Convert string input in number boxes to integers
                int firstNumberValue = Integer.parseInt(firstNumber.getText().toString());
                int secondNumberValue = Integer.parseInt(secondNumber.getText().toString());

//                Control flow for which operator is in use
                int operatorButtonId = operators.getCheckedRadioButtonId();
                Integer answer;

                if(operatorButtonId == add.getId()) {
                    answer = firstNumberValue + secondNumberValue;
                }
                else if (operatorButtonId == subtract.getId()) {
                    answer = firstNumberValue - secondNumberValue;
                }
                else if (operatorButtonId == multiply.getId()) {
                    answer = firstNumberValue * secondNumberValue;
                }
                else {
                    answer = firstNumberValue / secondNumberValue;
                }

//                Display the answer in the result text box
                result.setText(answer.toString());
            }
        });
    }
}