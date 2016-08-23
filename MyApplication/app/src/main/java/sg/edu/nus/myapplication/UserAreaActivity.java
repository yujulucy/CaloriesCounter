package sg.edu.nus.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


      //  final TextView tvAccount = (TextView) findViewById(R.id.tvAccount);
       // final TextView tvMessage = (TextView) findViewById(R.id.tvMessage);

        final Button bLogout = (Button) findViewById(R.id.bLogout);

      //  final Button bFoodDiary = (Button) findViewById(R.id.bFoodDiary);

        final ImageButton ibList = (ImageButton) findViewById(R.id.ibList);
        final ImageButton ibBookmark = (ImageButton) findViewById(R.id.ibBookmark);
        final ImageButton ibCalc = (ImageButton) findViewById(R.id.ibCalc);
        final ImageButton ibPlus = (ImageButton) findViewById(R.id.ibPlus);

      //  final Button bCalculate = (Button) findViewById(R.id.bCalculate);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");

        String message = "Welcome to your user area, " + name;
        String accountDetails = "Username: " + username;

      //  tvMessage.setText(message);
      //  tvAccount.setText(accountDetails);

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(UserAreaActivity.this, LoginActivity.class);
                UserAreaActivity.this.startActivity(registerIntent);
            }
        });


        ibList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent(UserAreaActivity.this, FoodDiaryActivity.class);
                UserAreaActivity.this.startActivity(viewIntent);
            }
        });


        ibCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(UserAreaActivity.this, Calculator.class);
                UserAreaActivity.this.startActivity(registerIntent);
            }
        });

        ibPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(UserAreaActivity.this, AddFoodDataActivity.class);
                UserAreaActivity.this.startActivity(registerIntent);
            }
        });


    }
}
