package sg.edu.nus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        String[] food = {"Chicken Rice", "Char Siew Rice", "Chicken Teriyaki Don", "Nasi Lemak"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, food);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);﻿
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to te action bar if it is present
        getMenuInflater().inflate(R.menu.food_list, menu);
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
    }
}
