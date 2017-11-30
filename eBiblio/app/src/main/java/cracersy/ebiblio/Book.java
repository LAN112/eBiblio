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

/**
 * Created by sobot on 30.11.2017.
 */

public class Book {
    public String id_book;
    public String tytul;
    public String autor;
    public String wydawnictwo;
    public String rok_wydania;
    public String opis;
    public String cover_filename;
    private JSONObject end_response;
    private Context context;

    public Book(String nazwa_informacji, String wartosc_informacji, Context przekazany_context){
        context=przekazany_context;
        Response.Listener<String> responseListener2 = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray responseArray = new JSONArray(response);
                    for(int i=0;i<responseArray.length(); i++){
                        end_response=(JSONObject) responseArray.get(i);
                        //Log.d(TAG, end_response.optString("tytul"));
                    }

                    id_book= end_response.optString("id_book");
                    tytul= end_response.optString("tytul");
                    autor= end_response.optString("autor");
                    wydawnictwo= end_response.optString("wydawnictwo");
                    rok_wydania= end_response.optString("rok_wydania");
                    opis= end_response.optString("opis");
                    cover_filename= end_response.optString("cover_filename");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        BookRequest bookRequest = new BookRequest(nazwa_informacji, wartosc_informacji, responseListener2);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(bookRequest);

    }


}
