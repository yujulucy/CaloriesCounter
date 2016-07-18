package tutorial.replicate;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jo on 17/6/16.
 */
public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://joellehippotutorial.netau.net/Replicate.php";
    private Map<String,String> params;

    public RegisterRequest(String name, String username, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener,null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
