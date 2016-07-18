package sg.edu.nus.myapplication;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest extends StringRequest {
    private Map<String,String> params;

    private static final String DELETE_REQUEST_URL = "http://joellehippotutorial.netau.net/Delete.php?food_id=";

    public DeleteRequest(String food_id, Response.Listener<String> listener){
        super(Request.Method.DELETE, DELETE_REQUEST_URL + food_id, listener,null);
        params = new HashMap<>();
       // params.put("name",name);

    }

//    @Override
//    public Map<String, String> getParams() {
//        return params;
//    }
}
