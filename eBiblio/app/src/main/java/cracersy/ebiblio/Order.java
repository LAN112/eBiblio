package cracersy.ebiblio;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sobot on 30.11.2017.
 */

public class Order {
    public String id_order;
    public String id_user;
    public String id_book;
    public String data_zamowienia;
    public String data_odbioru;
    public String data_zwrotu;
    private JSONObject end_response;
    private Context context;

    public Order(String nazwa_informacji, String wartosc_informacji, Context przekazany_context){
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

                    id_order= end_response.optString("id_order");
                    id_user= end_response.optString("id_user");
                    id_book= end_response.optString("id_book");
                    data_zamowienia= end_response.optString("data_zamowienia");
                    data_odbioru= end_response.optString("data_odbioru");
                    data_zwrotu= end_response.optString("data_zwrotu");

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
