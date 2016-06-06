package sg.edu.nus.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UX305 on 2016/6/6.
 */
public class DBHandler extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "foodInfo";

    //Food Table Name
    private static final String TABLE_FOOD = "food";

    //Food Table Columns Names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CAL = "calories";
    private static final String KEY_PROTEIN = "protein";
    private static final String KEY_FAT = "fat";
    private static final String KEY_CARBO = "carbo";
    private static final String KEY_SOD = "sodium";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FOOD_TABLE = "CREATE TABLE " + TABLE_FOOD + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_CAL + " INTEGER PRIMARY KEY,"
                + KEY_PROTEIN + " INTEGER PRIMARY KEY,"
                + KEY_FAT + " INTEGER PRIMARY KEY,"
                + KEY_CARBO + " INTEGER PRIMARY KEY,"
                + KEY_SOD + " INTEGER PRIMARY KEY," + ")";
        db.execSQL(CREATE_FOOD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);
        //Creating tables again
        onCreate(db);
    }

    //***********************************CRUD*****************************************//
    //*******************************Adding new food************************************//
    public void addFood(Data food) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, food.getId());
        values.put(KEY_NAME, food.getName());  //food name
        values.put(KEY_CAL, food.getCalories());  //calories
        values.put(KEY_PROTEIN, food.getProtein());  //protein
        values.put(KEY_FAT, food.getFat());  //fat
        values.put(KEY_CARBO, food.getCarbo());  //carbohydrate
        values.put(KEY_SOD, food.getSodium());  //sodium

        //Inserting row
        db.insert(TABLE_FOOD, null, values);
        db.close();  //Closing database connection
    }

    //*******************************Reading record**************************************//
    //Getting one food only
    public Data getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_FOOD, new String[] { KEY_ID,
                        KEY_NAME, KEY_CAL, KEY_PROTEIN,
                        KEY_FAT, KEY_CARBO, KEY_SOD}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Data food = new Data(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)),
                Integer.parseInt(cursor.getString(6)));

        //Return data
        return food;
    }

    //Getting all food
    public List<Data> getAllFood() {
        List<Data> foodList = new ArrayList<Data>();

        //Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_FOOD;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Data food = new Data();
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setName(cursor.getString(1));
                food.setCalories(Integer.parseInt(cursor.getString(2)));
                food.setProtein(Integer.parseInt(cursor.getString(3)));
                food.setFat(Integer.parseInt(cursor.getString(4)));
                food.setCarbo(Integer.parseInt(cursor.getString(5)));
                food.setSodium(Integer.parseInt(cursor.getString(6)));
                //Adding food to list
                foodList.add(food);
            } while (cursor.moveToNext());
        }

        //Return food list
        return foodList;
    }

    //Getting food count
    public int getFoodCount() {
        String countQuery = "SELECT * FROM" + TABLE_FOOD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //Return count
        return cursor.getCount();
    }

    //******************************Updating Record***********************************//
    //Updating a food
    public int updateFood(Data food) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, food.getName());
        values.put(KEY_CAL, food.getCalories());
        values.put(KEY_PROTEIN, food.getProtein());
        values.put(KEY_FAT, food.getFat());
        values.put(KEY_CARBO, food.getCarbo());
        values.put(KEY_SOD, food.getSodium());
        //Updating row
        return db.update(TABLE_FOOD, values, KEY_ID + " = ?",
                new String[]{String.valueOf(food.getId())});
    }

    //*******************************Delete Record************************************//
    //Deleting a food
    public void deleteFood(Data shop) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FOOD, KEY_ID + " = ?",
                new String[] { String.valueOf(shop.getId()) });
        db.close();
    }
}
