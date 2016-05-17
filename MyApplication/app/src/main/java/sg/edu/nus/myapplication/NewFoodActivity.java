package sg.edu.nus.myapplication;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpanWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewFoodActivity extends AppCompatActivity {
    EditText etfoodName, etPortion, etWeight, etEnergy, etProtein, etFat, etCarbo, etFibre, etChol,
            etCal, etSod;
    Context context;
    FoodHelper foodHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_food);

        etfoodName = (EditText) findViewById(R.id.etFoodName);
        etPortion = (EditText) findViewById(R.id.etPortion);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etEnergy = (EditText) findViewById(R.id.etEnergy);
        etProtein = (EditText) findViewById(R.id.etProtein);
        etFat = (EditText) findViewById(R.id.etFat);
        etCarbo = (EditText) findViewById(R.id.etCarbo);
        etFibre = (EditText) findViewById(R.id.etFibre);
        etChol = (EditText) findViewById(R.id.etChol);
        etCal = (EditText) findViewById(R.id.etCal);
        etSod = (EditText) findViewById(R.id.etSod);
    }

    public void addCalorie(View view) {
        String name = etfoodName.getText().toString();
        String por = etPortion.getText().toString();
        String weight = etWeight.getText().toString();
        String energy = etEnergy.getText().toString();
        String pro = etProtein.getText().toString();
        String fat = etFat.getText().toString();
        String carbo = etCarbo.getText().toString();
        String fibre = etFibre.getText().toString();
        String chol = etChol.getText().toString();
        String cal = etCal.getText().toString();
        String sod = etSod.getText().toString();

        foodHelper = new FoodHelper(context);
        sqLiteDatabase = foodHelper.getWritableDatabase();
        foodHelper.addInfo(name, por, weight, energy, pro, fat, carbo, fibre, chol, cal, sod,
                sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
        foodHelper.close();
    }
}
