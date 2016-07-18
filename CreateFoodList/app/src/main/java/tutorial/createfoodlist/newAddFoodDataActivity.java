package tutorial.createfoodlist;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jo on 28/6/16.
 */
public class newAddFoodDataActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_add_food);

        final EditText etBrandName = (EditText) findViewById(R.id.etBrandName);
        final EditText etDesc = (EditText) findViewById(R.id.etDesc);
        final EditText etPortion = (EditText) findViewById(R.id.etPortion);

        final EditText etWeight = (EditText) findViewById(R.id.etWeight);

        final Button bAdd = (Button) findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String brand_name = etBrandName.getText().toString();
                final String food_desc = etDesc.getText().toString();
                final String serving_portion = etPortion.getText().toString();
                final int serving_weight = Integer.parseInt(etWeight.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(newAddFoodDataActivity.this, MainActivity.class);
                                newAddFoodDataActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(newAddFoodDataActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                newFoodRequest registerRequest = new newFoodRequest(brand_name, food_desc, serving_portion, serving_weight, responseListener);
                RequestQueue queue = Volley.newRequestQueue(newAddFoodDataActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
