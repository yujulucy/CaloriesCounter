package sg.edu.nus.myapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jo on 28/6/16.
 */
public class AddFoodDataRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://joellehippotutorial.netau.net/NewFoodData.php";
    private Map<String,String> params;

    public AddFoodDataRequest(String brand_name, String description, String serving_portion, double serving_weight,
                              double calories, double protein, double carbs, double fat,
                              double fiber, Response.Listener<String>listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("brand_name", brand_name);
        params.put("description", description);
        params.put("serving_portion", serving_portion);
        params.put("serving_weight", serving_weight + "");
        params.put("calories", calories + "");
        params.put("protein", protein + "");
        params.put("carbs", carbs + "");
        params.put("fat", fat + "");
        params.put("fiber", fiber + "");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
