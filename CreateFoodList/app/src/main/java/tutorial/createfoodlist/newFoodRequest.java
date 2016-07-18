package tutorial.createfoodlist;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jo on 28/6/16.
 */
public class newFoodRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://joellehippotutorial.netau.net/newAddFood.php";
    private Map<String, String> params;

    public newFoodRequest(String brand_name, String food_desc, String serving_portion, int serving_weight, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("brand_name", brand_name);
        params.put("food_desc", food_desc);
        params.put("serving_portion", serving_portion);
        params.put("serving_weight", serving_weight + "");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
