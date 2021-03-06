package cracersy.ebiblio;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sobot on 30.11.2017.
 */

public class AllBooks {
    public String id_book;
    public String tytul;
    public String autor;
    public String wydawnictwo;
    public String rok_wydania;
    public String opis;
    public String cover_filename;
    public ArrayList<JSONObject> end_response = new ArrayList<JSONObject>();
    private JSONObject temp_object;
    private Context context;

    public AllBooks(String nazwa_informacji, String przekazana_wartosc, Context przekazany_context ){
        context=przekazany_context;
        Response.Listener<String> responseListener2 = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray responseArray = new JSONArray(response);
                    for(int i=0;i<responseArray.length(); i++){
                        end_response.add(temp_object=(JSONObject) responseArray.get(i));
                        //Log.d(TAG, end_response.optString("tytul"));
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        BookRequest bookRequest = new BookRequest(nazwa_informacji, przekazana_wartosc, responseListener2);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(bookRequest);

    }


}
