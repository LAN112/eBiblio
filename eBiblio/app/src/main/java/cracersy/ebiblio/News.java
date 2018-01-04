package cracersy.ebiblio;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sobot on 30.11.2017.
 */

public class News {
    public String news_id;
    public String news_title;
    public String news_text;
    public String news_short_text;
    public String news_image_url;
    private JSONObject end_response;
    private Context context;

    public News(String nazwa_informacji, String wartosc_informacji, Context przekazany_context){
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

                    news_id= end_response.optString("news_id");
                    news_title= end_response.optString("news_title");
                    news_text= end_response.optString("news_text");
                    news_short_text= end_response.optString("news_short_text");
                    news_image_url= end_response.optString("news_image_url");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        NewsRequest newsRequest = new NewsRequest(nazwa_informacji, wartosc_informacji, responseListener2);
        RequestQueue queue = Volley.newRequestQueue(context);

        queue.add(newsRequest);

    }


}
