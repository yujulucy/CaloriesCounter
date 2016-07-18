package sg.edu.nus.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jo on 18/7/16.
 */
public class DeleteActivity extends AppCompatActivity {

    private static final String JSON_URL = "http://joellehippotutorial.netau.net/Delete.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        final EditText etID = (EditText) findViewById(R.id.etID);
        Button bDelete = (Button) findViewById(R.id.bDelete);

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String food_id = etID.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success) {
                                Intent intent = new Intent(DeleteActivity.this, DeleteRequest.class);
                                DeleteActivity.this.startActivity(intent);

                                Toast popMessage = Toast.makeText(DeleteActivity.this, "Food item deleted", Toast.LENGTH_SHORT);
                                popMessage.show();

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(DeleteActivity.this);
                                builder.setMessage("Delete failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                DeleteRequest deleteRequest = new DeleteRequest(food_id,responseListener);
                RequestQueue queue = Volley.newRequestQueue(DeleteActivity.this);
                queue.add(deleteRequest);
            }
        });

    }

}