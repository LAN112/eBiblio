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

public class KontoDetails extends AppCompatActivity {
    public Konto konto;
    Context context=this;
    private JSONObject end_response;
    CountDownTimer mCountDownTimer, mmCountDownTimer;
    String msg = "Moje heheszki : ";
    public TextView imie,nazwisko,saldo,all_olders, cur_orders;

    private Dialog dialog;


    //Pusty konstruktor bez argumentowy bo się czepiał
    public KontoDetails() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konto);

        dialog = new Dialog(context);
        String id_konto = getIntent().getExtras().getString("id_user");
        imie = (TextView) findViewById(R.id.name);
        nazwisko = (TextView) findViewById(R.id.nazwisko);
        saldo = (TextView) findViewById(R.id.saldo);
        all_olders = (TextView) findViewById(R.id.all_olders);
        cur_orders = (TextView) findViewById(R.id.cur_oders);
        konto = new Konto("id_user", id_konto, context);
        mmCountDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                dialog.resume();
                if (konto.name != null) {
                    mmCountDownTimer.cancel();
                    imie.setText("Imie:" + konto.name);
                    nazwisko.setText("Nazwisko: " + konto.nazwisko);
                    saldo.setText("Saldo: " + konto.saldo);
                    all_olders.setText("Ilość wypożyczonych książek: " + konto.all_olders);
                    cur_orders.setText("Ilość obecnie wypożyczonych:" + konto.cur_orders);
                    dialog.stop();
                }
            }

            @Override
            public void onFinish() {
            }
        };
        mmCountDownTimer.start();
    }}