package sg.edu.nus.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.w3c.dom.Text;

/**
 * Created by jo on 16/8/16.
 */
public class FoodDiaryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_diary);

        final Button bBreakfast = (Button) findViewById(R.id.bBreakfast);
<<<<<<< HEAD
        final TextView tvFoodDate = (TextView) findViewById(R.id.tvFoodDate);
=======
        final Button bLunch = (Button) findViewById(R.id.bLunch);
        final Button bDinner = (Button) findViewById(R.id.bDinner);
        final Button bSnack = (Button) findViewById(R.id.bSnack);
>>>>>>> 4a603116f4e2f01d6b74bdb5127007508b1d7419

        bBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(FoodDiaryActivity.this, AddFoodDataActivity.class);
                FoodDiaryActivity.this.startActivity(registerIntent);
            }
        });

<<<<<<< HEAD
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        tvFoodDate.setText(formattedDate);

        tvFoodDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(FoodDiaryActivity.this, CalendarActivity.class);
=======
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
>>>>>>> 4a603116f4e2f01d6b74bdb5127007508b1d7419
                FoodDiaryActivity.this.startActivity(registerIntent);
            }
        });

    }

    public void read(View v) {
        Intent read_intent = new Intent(FoodDiaryActivity.this, ReadDataActivity.class);
        startActivity(read_intent);
    }



}
