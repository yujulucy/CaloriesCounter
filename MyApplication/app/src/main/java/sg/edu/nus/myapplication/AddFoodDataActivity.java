package sg.edu.nus.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by jo on 16/8/16.
 */
public class AddFoodDataActivity extends Activity {
    String url = "http://joellehippotutorial.netau.net/take_order.php";
    String brand_name,desc,portion,weight,carbs,fiber,fats,energy,protein;


    EditText brand_et,desc_et,energy_et,portion_et,weight_et,carbs_et,protein_et,fiber_et,fats_et;

    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_data);

        PD = new ProgressDialog(this);
        PD.setMessage("Loading.....");
        PD.setCancelable(false);

        brand_et = (EditText) findViewById(R.id.etBrandName);
        desc_et = (EditText)findViewById(R.id.etDescription);
        portion_et = (EditText) findViewById(R.id.etPortion);
        weight_et= (EditText) findViewById(R.id.etWeight);
        energy_et = (EditText) findViewById(R.id.etEnergy);
        protein_et = (EditText) findViewById(R.id.etProtein);
        fats_et = (EditText) findViewById(R.id.etFat);
        carbs_et = (EditText) findViewById(R.id.etCarbs);
        fiber_et = (EditText) findViewById(R.id.etFiber);

    }


    public void insert(View v) {
        PD.show();
        brand_name = brand_et.getText().toString();
        desc = desc_et.getText().toString();
        portion = portion_et.getText().toString();
        weight = weight_et.getText().toString();
        carbs = carbs_et.getText().toString();
        protein = protein_et.getText().toString();
        fats = fats_et.getText().toString();
        fiber = fiber_et.getText().toString();
        energy = energy_et.getText().toString();


        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        PD.dismiss();
                        brand_et.setText("");
                        desc_et.setText("");
                        portion_et.setText("");
                        weight_et.setText("");
                        fats_et.setText("");
                        fiber_et.setText("");
                        protein_et.setText("");
                        energy_et.setText("");
                        carbs_et.setText("");
                        Toast.makeText(getApplicationContext(),
                                "Data Inserted Successfully",
                                Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                PD.dismiss();
                Toast.makeText(getApplicationContext(),
                        "failed to insert", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("brand_name", brand_name);
                params.put("desc", desc);
                params.put("portion",portion);
                params.put("weight",weight);
                params.put("fats",fats);
                params.put("carbs",carbs);
                params.put("fiber",fiber);
                params.put("protein",protein);
                params.put("energy", energy);

                return params;
            }
        };

        // Adding request to request queue
        MyApplication.getInstance().addToReqQueue(postRequest);
    }

}
