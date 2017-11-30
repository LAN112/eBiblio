package cracersy.ebiblio;

import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by sobot on 29.11.2017.
 */




public class BookRequest extends StringRequest {
    private static final String BOOK_REQUEST_URL = "http://michalbielejewski.home.pl/biblio/get_book.php";
    private Map<String, String> params;



    public BookRequest(String nazwa_informacji, String wartosc_informacji, Response.Listener<String> listener){
        super(Request.Method.POST, BOOK_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put(nazwa_informacji, wartosc_informacji);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
