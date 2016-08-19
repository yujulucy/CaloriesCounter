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

        bBreakfast.setOnClickListener(new View.OnClickListener() {
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
