package sg.edu.nus.myapplication;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewFoodAddedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_food_added);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent msgIntent = new Intent(NewFoodAddedActivity.this, MainActivity.class);
                NewFoodAddedActivity.this.startActivity(msgIntent);
                NewFoodAddedActivity.this.finish();
            }
        }, 1000);
    }
}
