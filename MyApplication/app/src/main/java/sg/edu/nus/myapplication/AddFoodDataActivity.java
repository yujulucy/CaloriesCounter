package sg.edu.nus.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jo on 28/6/16.
 */
public class AddFoodDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_data);

        final EditText etBrandName = (EditText) findViewById(R.id.etBrandName);
        final EditText etDescription = (EditText) findViewById(R.id.etDescription);
        final EditText etPortion = (EditText) findViewById(R.id.etPortion);
        final EditText etWeight = (EditText) findViewById(R.id.etWeight);
        final EditText etCalories = (EditText) findViewById(R.id.etCalories);
        final EditText etProtein = (EditText) findViewById(R.id.etProtein);
        final EditText etCarbs = (EditText) findViewById(R.id.etCarbs);
        final EditText etFat = (EditText) findViewById(R.id.etFat);
        final EditText etFiber = (EditText) findViewById(R.id.etFiber);

        final Button bAdd = (Button) findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String brand_name = etBrandName.getText().toString();
                final String description = etDescription.getText().toString();
                final String serving_portion = etPortion.getText().toString();
                final double serving_weight = Double.parseDouble(etWeight.getText().toString());
                final double calories = Double.parseDouble(etCalories.getText().toString());
                final double protein = Double.parseDouble(etProtein.getText().toString());
                final double carbs = Double.parseDouble(etCarbs.getText().toString());
                final double fat = Double.parseDouble(etFat.getText().toString());
                final double fiber = Double.parseDouble(etFiber.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success) {
                                Intent intent = new Intent(AddFoodDataActivity.this, UserAreaActivity.class);
                                AddFoodDataActivity.this.startActivity(intent);

                                Toast popMessage = Toast.makeText(AddFoodDataActivity.this, "Food item added", Toast.LENGTH_SHORT);
                                popMessage.show();

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(AddFoodDataActivity.this);
                                builder.setMessage("Food addition failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };


                AddFoodDataRequest addFoodDataRequest = new AddFoodDataRequest(brand_name, description, serving_portion,
                        serving_weight, calories, protein, carbs, fat, fiber, responseListener);
                RequestQueue queue = Volley.newRequestQueue(AddFoodDataActivity.this);
                queue.add(addFoodDataRequest);
            }
        });

    }
}
