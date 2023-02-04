package com.example.contractorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculateSubtotal();
        initClearButton();
    }

    private void calculateSubtotal() {
        EditText material_Cost = findViewById(R.id.material_cost_edittext);
        EditText labor_Cost = findViewById(R.id.labor_cost_edittext);

        TextView set_Subtotal = findViewById(R.id.textSetSubtotal);
        TextView set_Tax = findViewById(R.id.textSetTaxRate);
        TextView set_Total = findViewById(R.id.textSetTotal);

        Button calculate = findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double materialCost = Double.parseDouble(material_Cost.getText().toString());
                double laborCost = Double.parseDouble(labor_Cost.getText().toString());

                double subtotal = materialCost + laborCost;
                double tax = subtotal * .05;
                double total = subtotal + tax;

                // display the results
                set_Subtotal.setText(String.format("%.2f", subtotal));
                set_Tax.setText(String.format("$%.2f", tax));
                set_Total.setText(String.format("$%.2f", total));
            }
        });
    }

        private void initClearButton() {
            Button clearButton = findViewById(R.id.btnClear);
            clearButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView set_Subtotal = findViewById(R.id.textSetSubtotal);
                    TextView set_Tax = findViewById(R.id.textSetTaxRate);
                    TextView set_Total = findViewById(R.id.textSetTotal);

                    set_Subtotal.setText("Your subtotal is...");
                    set_Tax.setText(" 5 % ");
                    set_Total.setText("Your total is...");
                }
            });
        }


    }