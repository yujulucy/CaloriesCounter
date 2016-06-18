package sg.edu.nus.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final TextView tvAccount = (TextView) findViewById(R.id.tvAccount);
        final TextView tvMessage = (TextView) findViewById(R.id.tvMessage);
        final Button bLogout = (Button) findViewById(R.id.bLogout);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");

        String message = "Welcome to your user area, " + name;
        String accountDetails = "Username: " + username;

        tvMessage.setText(message);
        tvAccount.setText(accountDetails);

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(UserAreaActivity.this, LoginActivity.class);
                UserAreaActivity.this.startActivity(registerIntent);
            }
        });

    }
}
