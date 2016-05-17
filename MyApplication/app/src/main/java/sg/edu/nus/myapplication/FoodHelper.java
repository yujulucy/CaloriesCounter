package sg.edu.nus.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by UX305 on 2016/5/18.
 */
public class FoodHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FOODINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE" + CalorieData.NewFoodInfo.TABLE_NAME + "{" +
                    CalorieData.NewFoodInfo.FOOD_NAME + "TEXT, " +
                    CalorieData.NewFoodInfo.SERVING_PORTION + "TEXT, " +
                    CalorieData.NewFoodInfo.SERVING_WEIGHT + "TEXT, " +
                    CalorieData.NewFoodInfo.ENERGY + "TEXT, " +
                    CalorieData.NewFoodInfo.PROTEIN + "TEXT, " +
                    CalorieData.NewFoodInfo.TOTAL_FAT + "TEXT, " +
                    CalorieData.NewFoodInfo.CARBOHYRATES + "TEXT, " +
                    CalorieData.NewFoodInfo.DIETARY_FIBRE + "TEXT, " +
                    CalorieData.NewFoodInfo.CHOLESTEROL + "TEXT, " +
                    CalorieData.NewFoodInfo.CALCIUM + "TEXT, " +
                    CalorieData.NewFoodInfo.SODIUM + "TEXT} ;";


    public FoodHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Database created / opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "Table created...");
    }

    public void addInfo(String name, String portion, String weight, String energy, String protein,
                        String fat, String carbo, String fibre, String chol, String cal, String sod,
                        SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CalorieData.NewFoodInfo.FOOD_NAME, name);
        contentValues.put(CalorieData.NewFoodInfo.SERVING_PORTION, portion);
        contentValues.put(CalorieData.NewFoodInfo.SERVING_WEIGHT, weight);
        contentValues.put(CalorieData.NewFoodInfo.ENERGY, energy);
        contentValues.put(CalorieData.NewFoodInfo.PROTEIN, protein);
        contentValues.put(CalorieData.NewFoodInfo.TOTAL_FAT, fat);
        contentValues.put(CalorieData.NewFoodInfo.CARBOHYRATES, carbo);
        contentValues.put(CalorieData.NewFoodInfo.DIETARY_FIBRE, fibre);
        contentValues.put(CalorieData.NewFoodInfo.CHOLESTEROL, chol);
        contentValues.put(CalorieData.NewFoodInfo.CALCIUM, cal);
        contentValues.put(CalorieData.NewFoodInfo.SODIUM, sod);
        db.insert(CalorieData.NewFoodInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "One row is inserted...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
