package cracersy.ebiblio;

import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;



public class KontoRequest extends StringRequest {
    private static final String STATS_REQUEST_URL = "http://michalbielejewski.home.pl/biblio/get_user_stats.php";
    private Map<String, String> params;



    public KontoRequest(String nazwa_informacji, String wartosc_informacji, Response.Listener<String> listener){
        super(Request.Method.POST, STATS_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("id_user", wartosc_informacji);
       // params.put(nazwa_informacji, wartosc_informacji);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
