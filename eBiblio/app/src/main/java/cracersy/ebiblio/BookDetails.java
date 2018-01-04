package cracersy.ebiblio;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static java.security.AccessController.getContext;

public class BookDetails extends AppCompatActivity {

    public Book ksiazka;
    public TextView tytul, autor, wydawnictwo, rok_wydania;
    Context context=this;
    CountDownTimer mCountDownTimer;
    Button Reserve, Czytaj_opis, Zapamietaj;
    private JSONObject end_response;
    ImageView cover;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        dialog=new Dialog(context);

        String id_book = getIntent().getExtras().getString("id");
        cover = (ImageView)findViewById(R.id.cover_img);
        tytul = (TextView) findViewById(R.id.tytul);
        autor = (TextView) findViewById(R.id.autor);
        wydawnictwo = (TextView) findViewById(R.id.wydawnictwo);
        rok_wydania = (TextView) findViewById(R.id.rok_wydania);

        ksiazka=new Book("id",id_book,context);
        mCountDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                dialog.resume();
                if (ksiazka.cover_filename!=null){
                    mCountDownTimer.cancel();
                    Picasso.with(getApplicationContext()).load(ksiazka.cover_filename).into(cover);
                    tytul.setText("Tytuł: " + ksiazka.tytul);
                    autor.setText("Autor: " + ksiazka.autor);
                    wydawnictwo.setText("Wydawnictwo: " + ksiazka.wydawnictwo);
                    rok_wydania.setText("Rok wydania: " + ksiazka.rok_wydania);
                    dialog.stop();
                }
            }
            @Override
            public void onFinish() {
            }
        };
        mCountDownTimer.start();


        Czytaj_opis = (Button) findViewById(R.id.opis);
        Czytaj_opis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), book_description.class);
                Intent.putExtra("opis", ksiazka.opis);
                view.getContext().startActivity(Intent);}
        });

        Zapamietaj = (Button) findViewById(R.id.zapamietaj);
        Zapamietaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Zapamietaj.setText("Zapamietano!");

                Response.Listener<String> responseListener2 = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            for (int i = 0; i < responseArray.length(); i++) {
                                end_response = (JSONObject) responseArray.get(i);
                                //Log.d(TAG, end_response.optString("tytul"));
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };


                SaveRequest saveRequest = new SaveRequest(getIntent().getExtras().getString("id_user"), ksiazka.id_book, responseListener2);
                RequestQueue queue = Volley.newRequestQueue(context);
                queue.add(saveRequest);
            }
        });


        Reserve = (Button) findViewById(R.id.zarezerwuj);
        Reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reserve.setText("Zarezerwowano!");

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
