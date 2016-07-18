package sg.edu.nus.myapplication;

import android.app.ProgressDialog;
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


public class FoodListActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewJSON;
    private Button buttonGet;
    private Button buttonParse;

    public static final String MY_JSON ="MY_JSON";

    private static final String JSON_URL = "http://joellehippotutorial.netau.net/ViewFoodList.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        textViewJSON = (TextView) findViewById(R.id.textViewJSON);
        textViewJSON.setMovementMethod(new ScrollingMovementMethod());
        buttonGet = (Button) findViewById(R.id.buttonGet);
      //  buttonParse = (Button) findViewById(R.id.buttonParse);
        buttonGet.setOnClickListener(this);
      //  buttonParse.setOnClickListener(this);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View v) {
        if(v==buttonGet){
            getJSON(JSON_URL);
        }

//        if(v==buttonParse){
//            showParseActivity();
//        }
    }

//    private void showParseActivity() {
//        Intent intent = new Intent(this, ParseJSON.class);
//        intent.putExtra(MY_JSON,textViewJSON.getText().toString());
//        startActivity(intent);
//    }


    private void getJSON(String url) {
        class GetJSON extends AsyncTask<String, Void, String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(FoodListActivity.this, "Please Wait...",null,true,true);
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
                    str += "\n---------------------\n";



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

               // textViewJSON.setText(s);
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute(url);
    }
}