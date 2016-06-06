package sg.edu.nus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        populateListView();
        registerClickCallback();
    }

    private void populateListView() {
        String[] food = {"Chicken Rice", "Char Siew Rice", "Chicken Teriyaki Don", "Nasi Lemak"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.activity_food_list, food);
        ListView list = (ListView) findViewById(R.id.lvList);
        //list.setAdapter(adapter);﻿
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.lvList);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String msg = "You clicked # " + position + ", which is string: "
                        + textView.getText().toString();
                Toast.makeText(FoodListActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to te action bar if it is present
        getMenuInflater().inflate(R.menu.menu_food_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here. the action bar will automatically handle clicks on the
        //Home/Up button, so long as you specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();
        if (id = R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
