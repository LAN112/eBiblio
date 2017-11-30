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

public class User {
    public String id_user;
    private JSONObject end_response;
    private Context context;

    public User(String username, Context przekazany_context){
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

                    id_user= end_response.optString("id_user");


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        UserRequest userRequest = new UserRequest(username, responseListener2);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(userRequest);

    }


}
