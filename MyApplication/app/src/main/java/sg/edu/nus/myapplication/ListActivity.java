package sg.edu.nus.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        DBHandler db = new DBHandler(this);

        //Inserting food/rows
        /*Log.d("Insert: ", "Inserting ..");
        db.addFood(new Data(1, "Chicken Rice", 618, 26, 23, 76, 1314));
        db.addFood(new Data(2, "Char Siew Rice", 602, 25, 16, 90, 1391));
        db.addFood(new Data(3, "Chicken Teriyaki Don", 641, 34, 24, 73, 947));
        db.addFood(new Data(4, "Nasi Lemak", 279, 12, 13, 29, 778));*/

        //Reading all foods
        //Log.d("Reading: ", "Reading all food..");
        List<Data> foods = db.getAllFood();

        if(foods.size() != 0) {
            ListView listView = (ListView) findViewById(R.id.lvFoodList);

            String[] food = {"Chicken Rice", "Char Siew Rice", "Chicken Teriyaki Don", "Nasi Lemak"};

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    food);
            listView.setAdapter(arrayAdapter);
        }

        /*for (Data food : foods) {
            String log = "Id: " + food.getId() + " , Name: " + food.getName()
                    + " , Calories: " + food.getCalories() + " , Protein: " + food.getProtein()
                    + " , Fat: " + food.getFat() + " , Carbohydrates: " + food.getCarbo()
                    + " , Sodium: " + food.getSodium();

        //Writing foods to log
            Log.d("Shop: ", log);
        }*/
    }
}
