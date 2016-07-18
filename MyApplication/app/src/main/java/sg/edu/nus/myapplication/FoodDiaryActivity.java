package sg.edu.nus.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

/**
 * Created by jo on 1/7/16.
 */
public class FoodDiaryActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewJSON;
    private Button buttonGet;
    private Button buttonAddFood;

    private static final String JSON_URL = "http://joellehippotutorial.netau.net/ViewFoodList.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_diary);

        final TextView tvFoodDate = (TextView) findViewById(R.id.tvFoodDate);
        textViewJSON = (TextView) findViewById(R.id.textViewJSON);
        textViewJSON.setMovementMethod(new ScrollingMovementMethod());
        buttonAddFood = (Button) findViewById(R.id.bBreakfast);
        buttonGet = (Button) findViewById(R.id.bExpandView);
        buttonGet.setOnClickListener(this);

        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        tvFoodDate.setText(dateString);

        buttonAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewCalIntent = new Intent(FoodDiaryActivity.this, AddFoodDataActivity.class);
                FoodDiaryActivity.this.startActivity(viewCalIntent);
            }
        });


        tvFoodDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewCalIntent = new Intent(FoodDiaryActivity.this, CalendarActivity.class);
                FoodDiaryActivity.this.startActivity(viewCalIntent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v==buttonGet){
            getJSON(JSON_URL);
        }
    }

    private void getJSON(String url) {
        class GetJSON extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(FoodDiaryActivity.this, "Please Wait...",null,true,true);
            }

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine())!= null){
                        sb.append(json+"\n\n");
                    }

                    return sb.toString().trim();

                }catch(Exception e){
                    return null;
                }

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

                try {
                    JSONObject json = new JSONObject(s);

                    String str = "";

                    JSONArray articles = json.getJSONArray("result");
                    int arraySize = +json.getJSONArray("result").length();
                    str += "Number of food items being displayed: = " + arraySize;
                    str += "\n========================\n";



                    for(int i=0; i<arraySize; i++) {
                        // str += "names: " + articles.getJSONObject(0).names();
                        str += "Brand name: " + articles.getJSONObject(i).getString("brand_name");
                        str += "\n";
                        str += "Food description: " + articles.getJSONObject(i).getString("description");
                        str += "\n";
                        str += "Serving portion: " + articles.getJSONObject(i).getString("serving_portion");
                        str += "\n";
                        str += "Serving weight: " + articles.getJSONObject(i).getString("serving_weight") + "g";
                        str += "\n";
                        str += "Energy: " + articles.getJSONObject(i).getString("calories") + "kcal";
                        str += "\n";
                        str += "Protein: " + articles.getJSONObject(i).getString("protein") + "g";
                        str += "\n";
                        str += "Carbs: " + articles.getJSONObject(i).getString("carbs") + "g";
                        str += "\n";
                        str += "Fiber: " + articles.getJSONObject(i).getString("fiber") + "g";
                        str += "\n";
                        str += "\n========================\n";
                    }
                    textViewJSON.setText(str);
                    //etResponse.setText(str);
                    //etResponse.setText(json.toString(1));

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
        GetJSON gj = new GetJSON();
        gj.execute(url);
    }

}
