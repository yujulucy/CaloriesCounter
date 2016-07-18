package sg.edu.nus.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by jo on 1/7/16.
 */
public class FoodDiaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_diary);

        final TextView tvFoodDate = (TextView) findViewById(R.id.tvFoodDate);

        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        tvFoodDate.setText(dateString);



        tvFoodDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewCalIntent = new Intent(FoodDiaryActivity.this, CalendarActivity.class);
                FoodDiaryActivity.this.startActivity(viewCalIntent);
            }
        });

    }
}
