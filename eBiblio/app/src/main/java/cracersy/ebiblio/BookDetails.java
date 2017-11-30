package cracersy.ebiblio;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BookDetails extends AppCompatActivity {
    Button przycisk;
    public Book ksiazka;
    public TextView text;
    Context context=this;
    CountDownTimer mCountDownTimer;
    Button Reserve;
    private JSONObject end_response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);


        String id_book = getIntent().getExtras().getString("id");

        text = (TextView) findViewById(R.id.title3);

        ksiazka=new Book("id",id_book,context);
        mCountDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (ksiazka.cover_filename!=null){
                    millisUntilFinished=0;
                }
            }
            @Override
            public void onFinish() {
                text.setText(ksiazka.tytul);
            }
        };
        mCountDownTimer.start();


        Reserve = (Button) findViewById(R.id.reserve);
        Reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Response.Listener<String> responseListener2 = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            for(int i=0;i<responseArray.length(); i++){
                                end_response=(JSONObject) responseArray.get(i);
                                //Log.d(TAG, end_response.optString("tytul"));
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };


                ReserveRequest reserveRequest = new ReserveRequest(getIntent().getExtras().getString("id_user"), ksiazka.id_book, responseListener2);
                RequestQueue queue = Volley.newRequestQueue(context);
                queue.add(reserveRequest);
            }
        });

    }
}
