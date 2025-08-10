package com.example.calculator; 
 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.Toast; 
 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
    EditText etFirstValue, etSecondValue; 
    String operator = ""; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
 
        etFirstValue = findViewById(R.id.etFirstValue); 
        etSecondValue = findViewById(R.id.etSecondValue); 
    } 
 
    public void onNumberClick(View view) { 
        Button button = (Button) view; 
        String buttonText = button.getText().toString(); 
 
        if (etFirstValue.hasFocus()) { 
            etFirstValue.append(buttonText); 
        } else if (etSecondValue.hasFocus()) { 
            etSecondValue.append(buttonText); 
        } 
    } 
 
    public void onOperatorClick(View view) { 
        Button button = (Button) view; 
        operator = button.getText().toString(); 
        etSecondValue.requestFocus(); 
    } 
 
    public void calculateResult(View view) { 
        try { 
            double num1 = Double.parseDouble(etFirstValue.getText().toString()); 
            double num2 = Double.parseDouble(etSecondValue.getText().toString()); 
            double result = 0; 
 
            switch (operator) { 
                case "+": 
                    result = num1 + num2; 
                    break; 
                case "-": 
                    result = num1 - num2; 
                    break; 
                case "*": 
                    result = num1 * num2; 
                    break; 
                case "/": 
                    if (num2 != 0) { 
                        result = num1 / num2; 
                    } else { 
                        Toast.makeText(this, "Cannot divide by zero", 
Toast.LENGTH_SHORT).show(); 
                        return; 
                    } 
                    break; 
                default: 
                    Toast.makeText(this, "Select an operation", 
Toast.LENGTH_SHORT).show(); 
                    return; 
            } 
 
            Toast.makeText(this, "Result: " + result, Toast.LENGTH_LONG).show(); 
        } catch (NumberFormatException e) { 
            Toast.makeText(this, "Please enter valid numbers", 
Toast.LENGTH_SHORT).show(); 
        } 
    } 
 
    public void onClearClick(View view) { 
        etFirstValue.setText(""); 
        etSecondValue.setText(""); 
        operator = ""; 
    } 
} 
