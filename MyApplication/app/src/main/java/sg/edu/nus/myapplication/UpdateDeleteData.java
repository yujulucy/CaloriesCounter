package sg.edu.nus.myapplication;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
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
import com.android.volley.toolbox.JsonObjectRequest;

/**
 * Created by jo on 20/8/16.
 */
public class UpdateDeleteData extends Activity {
    EditText item_name_et,item_energy_et, item_portion_et, item_weight_et, item_carbs_et, item_protein_et,
             item_fats_et, item_fiber_et;
    String id, item_name,item_energy, item_portion, item_weight, item_carbs, item_protein, item_fats
            , item_fiber;

    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        PD = new ProgressDialog(this);
        PD.setMessage("please wait.....");
        PD.setCancelable(false);

        item_name_et = (EditText) findViewById(R.id.modify_item_et);
        item_energy_et = (EditText) findViewById(R.id.modify_energy_et);
        item_carbs_et = (EditText) findViewById(R.id.modify_carbs);
        item_fiber_et = (EditText) findViewById(R.id.modify_fiber);
        item_fats_et = (EditText) findViewById(R.id.modify_fats);
        item_portion_et = (EditText) findViewById(R.id.modify_portion);
        item_protein_et = (EditText) findViewById(R.id.modify_protein);
        item_weight_et = (EditText) findViewById(R.id.modify_weight);

        Intent i = getIntent();

        HashMap<String, String> item = (HashMap<String, String>) i
                .getSerializableExtra("item");

        id = item.get(ReadDataActivity.ITEM_ID);
        item_name = item.get(ReadDataActivity.ITEM_NAME);
        item_energy = item.get(ReadDataActivity.ITEM_ENERGY);
        item_carbs = item.get(ReadDataActivity.ITEM_CARBS);
        item_fiber = item.get(ReadDataActivity.ITEM_FIBER);
        item_protein = item.get(ReadDataActivity.ITEM_PROTEIN);
        item_portion = item.get(ReadDataActivity.ITEM_PORTION);
        item_weight = item.get(ReadDataActivity.ITEM_WEIGHT);
        item_fats = item.get(ReadDataActivity.ITEM_FATS);

        item_name_et.setText(item_name);
        item_energy_et.setText(item_energy);
        item_carbs_et.setText(item_carbs);
        item_fiber_et.setText(item_fiber);
        item_fats_et.setText(item_fats);
        item_portion_et.setText(item_portion);
        item_protein_et.setText(item_protein);
        item_weight_et.setText(item_weight);


    }

    public void update(View view) {
        //perform update
        PD.show();
        item_name = item_name_et.getText().toString();
        item_energy = item_energy_et.getText().toString();

        String update_url = "http://joellehippotutorial.netau.net/update_item.php";

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        params.put("item",item_name);
        params.put("energy",item_energy);
        params.put("portion",item_portion);
        params.put("weight",item_weight);
        params.put("carbs",item_carbs);
        params.put("protein",item_protein);
        params.put("fats", item_fats);
        params.put("fiber",item_fiber);

        CustomRequest update_request = new CustomRequest(Request.Method.POST,update_url,
                params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    int success = response.getInt("success");

                    if (success == 1) {
                        PD.dismiss();
                        Toast.makeText(getApplicationContext(),
                                "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                        // redirect to readdata
                        MoveToReadData();

                    } else {
                        PD.dismiss();
                        Toast.makeText(getApplicationContext(),
                                "failed to update", Toast.LENGTH_SHORT)
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Adding request to request queue
        MyApplication.getInstance().addToReqQueue(update_request);
    }

    public void delete(View view) {
        PD.show();
        String delete_url ="http://joellehippotutorial.netau.net/delete_item.php?id="
                + id;

        JsonObjectRequest delete_request = new JsonObjectRequest(delete_url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    int success = response.getInt("success");

                    if (success == 1) {
                        PD.dismiss();
                        Toast.makeText(getApplicationContext(),
                                "Deleted Successfully",
                                Toast.LENGTH_SHORT).show();
                        // redirect to readdata
                        MoveToReadData();
                    } else {
                        PD.dismiss();
                        Toast.makeText(getApplicationContext(),
                                "failed to delete", Toast.LENGTH_SHORT)
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Adding request to request queue
        MyApplication.getInstance().addToReqQueue(delete_request);

    }

    private void MoveToReadData() {
        Intent read_intent = new Intent(UpdateDeleteData.this, ReadDataActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(read_intent);

    }
}
