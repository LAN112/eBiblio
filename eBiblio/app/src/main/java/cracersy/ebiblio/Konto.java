package cracersy.ebiblio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Konto extends AppCompatActivity {
    private static final String TAG = "Moje konto";
    public String saldo;
    public String name;
    public String username;
    public String nazwisko;
    public String all_olders;
    public String cur_orders;
    private JSONObject end_response;
    private Context context;
    String msg = "Moje heheszki : ";
    //Pusty konstruktor bez argumentowy bo się czepiał
    public Konto() {}






    public Konto(String nazwa_informacji, String wartosc_informacji, Context przekazany_context) {
        context = przekazany_context;
        Response.Listener < String > responseListener2 = new Response.Listener < String > () {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray responseArray = new JSONArray(response);
                    for (int i = 0; i < responseArray.length(); i++) {
                        end_response = (JSONObject) responseArray.get(i);

                    }


                    name = end_response.optString("imie");
                    nazwisko = end_response.optString("nazwisko");
                    saldo = end_response.optString("saldo");
                    cur_orders = end_response.optString("obecnie");
                    all_olders = end_response.optString("ogolnie");


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

//username="admin";
        KontoRequest kontoRequest = new KontoRequest(nazwa_informacji, wartosc_informacji, responseListener2);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(kontoRequest);

    }


}