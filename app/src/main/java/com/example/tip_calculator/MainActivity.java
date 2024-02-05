package com.example.tip_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//import java.text.NumberFormat;

import com.example.tip_calculator.databinding.ActivityMainBinding;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    double bill;
    double total;
    int tip, people_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = binding.billTotal;
                EditText input2 = binding.tipPercentage;
                EditText input3 = binding.numberOfPeople;
                TextView t = binding.output;
                if (input != null || input2 != null || input3 != null)
                {
                    bill = Double.parseDouble(input.getText().toString());
                    tip = Integer.parseInt(input2.getText().toString());
                    people_num = Integer.parseInt(input3.getText().toString());
                    double percentage = (bill * tip) / 100;
                    total = (bill + percentage)/people_num;
                    StringBuilder s = new StringBuilder();

                    String newTotal = NumberFormat.getCurrencyInstance().format(total);
                    s.append(getResources().getText(R.string.Total_message)).append("");
                    s.append(newTotal);
                    t.setText(s.toString());
                }
                else {
                    ;
                }

            }
        });

        }
}

