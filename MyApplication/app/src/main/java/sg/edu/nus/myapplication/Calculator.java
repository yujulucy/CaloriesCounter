package sg.edu.nus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener {
    EditText etFirstCal, etSecondCal, etThirdCal;
    Button bPlus1, bMinus1, bPlus2, bMinus2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etFirstCal = (EditText) findViewById(R.id.etFirstCal);
        etSecondCal = (EditText) findViewById(R.id.etSecondCal);
        etThirdCal = (EditText) findViewById(R.id.etThirdCal);
        bPlus1 = (Button) findViewById(R.id.bPlus1);
        bMinus1 = (Button) findViewById(R.id.bMinus1);
        bPlus2 = (Button) findViewById(R.id.bPlus2);
        bMinus2 = (Button) findViewById(R.id.bMinus2);
        tvResult = (TextView) findViewById(R.id.tvResult);

        bPlus1.setOnClickListener(this);
        bMinus1.setOnClickListener(this);
        bPlus2.setOnClickListener(this);
        bMinus2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String num1 = etFirstCal.getText().toString();
        String num2 = etSecondCal.getText().toString();
        String num3 = etThirdCal.getText().toString();
        int result;
        switch(view.getId()) {
            case R.id.bPlus1:
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                tvResult.setText(String.valueOf(result));
                break;
            case R.id.bMinus1:
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                tvResult.setText(String.valueOf(result));
                break;
        }

        result = Integer.parseInt(tvResult.getText().toString());

        switch(view.getId()) {
            case R.id.bPlus2:
                result = result + Integer.parseInt(num3);
                tvResult.setText(String.valueOf(result));
                break;
            case R.id.bMinus2:
                result = result - Integer.parseInt(num3);
                tvResult.setText(String.valueOf(result));
                break;
        }
    }
}