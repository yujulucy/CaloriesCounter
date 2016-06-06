package sg.edu.nus.myapplication;

/**
 * Created by UX305 on 2016/6/6.
 */
public class Data {
    private int id;
    private String name;
    private int calories;
    private int protein;
    private int fat;
    private int carbo;
    private int sodium;

    public Data() {
    }

    public Data(int id, String name, int calories, int protein, int fat, int carbo,
                int sodium) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbo = carbo;
        this.sodium = sodium;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setCarbo(int carbo) {
        this.carbo = carbo;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbo() {
        return carbo;
    }

    public int getSodium() {
        return sodium;
    }
}
