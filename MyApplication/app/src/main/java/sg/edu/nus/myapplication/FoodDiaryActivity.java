package sg.edu.nus.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jo on 16/8/16.
 */
public class FoodDiaryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_diary);

        final Button bBreakfast = (Button) findViewById(R.id.bBreakfast);
        final Button bLunch = (Button) findViewById(R.id.bLunch);
        final Button bDinner = (Button) findViewById(R.id.bDinner);
        final Button bSnack = (Button) findViewById(R.id.bSnack);

        bBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(FoodDiaryActivity.this, AddFoodDataActivity.class);
                FoodDiaryActivity.this.startActivity(registerIntent);
            }
        });

        bLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(FoodDiaryActivity.this, AddFoodDataActivity.class);
                FoodDiaryActivity.this.startActivity(registerIntent);
            }
        });

        bDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(FoodDiaryActivity.this, AddFoodDataActivity.class);
                FoodDiaryActivity.this.startActivity(registerIntent);
            }
        });

        bSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(FoodDiaryActivity.this, AddFoodDataActivity.class);
                FoodDiaryActivity.this.startActivity(registerIntent);
            }
        });

    }

    public void read(View v) {
        Intent read_intent = new Intent(FoodDiaryActivity.this, ReadDataActivity.class);
        startActivity(read_intent);
    }



}
