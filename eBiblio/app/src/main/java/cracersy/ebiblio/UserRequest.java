package cracersy.ebiblio;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sobot on 30.11.2017.
 */

public class UserRequest extends StringRequest {
    private static final String RESERVE_REQUEST_URL = "http://michalbielejewski.home.pl/biblio/get_book.php";
    private Map<String, String> params;



    public UserRequest(String username, Response.Listener<String> listener){
        super(Request.Method.POST, RESERVE_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}