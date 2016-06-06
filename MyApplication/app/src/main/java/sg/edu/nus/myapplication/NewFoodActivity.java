package sg.edu.nus.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewFoodActivity extends AppCompatActivity {
    //EditText etfoodName, etCalories, etProtein, etFat, etCarbo, etSod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_food);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);  //not working

        final EditText etfoodName = (EditText) findViewById(R.id.etFoodName);
        final EditText etCalories = (EditText) findViewById(R.id.etCalories);
        final EditText etProtein = (EditText) findViewById(R.id.etProtein);
        final EditText etFat = (EditText) findViewById(R.id.etFat);
        final EditText etCarbo = (EditText) findViewById(R.id.etCarbo);
        final EditText etSod = (EditText) findViewById(R.id.etSod);

        final Button bAdd = (Button) findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(NewFoodActivity.this, NewFoodAddedActivity.class);
                NewFoodActivity.this.startActivity(addIntent);
            }
        });
    }
}
