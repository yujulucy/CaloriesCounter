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
    EditText brand_name_et;
    String id, brand_name;

    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        PD = new ProgressDialog(this);
        PD.setMessage("please wait.....");
        PD.setCancelable(false);

        brand_name_et = (EditText) findViewById(R.id.modify_item_et);
        Intent i = getIntent();

        HashMap<String, String> item = (HashMap<String, String>) i
                .getSerializableExtra("brand");

        id = item.get(ReadDataActivity.ITEM_ID);
        brand_name = item.get(ReadDataActivity.ITEM_NAME);

        brand_name_et.setText(brand_name);

    }

    public void update(View view) {
        PD.show();
        brand_name = brand_name_et.getText().toString();

        String update_url = "http://joellehippotutorial.netau.net/update_item.php";

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        params.put("brand",brand_name);

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
        String delete_url = "http://joellehippotutorial.netau.net/delete_item.php?id="
                + id;

        JsonObjectRequest delete_request = new JsonObjectRequest(delete_url,
                new Response.Listener<JSONObject>() {

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
