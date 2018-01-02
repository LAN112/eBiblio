package cracersy.ebiblio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Joaś on 30.12.2017.
 */

public class KontoDetails_bak extends AppCompatActivity {
    public TextView konto, name, nazwisko, saldo, all_olders, cur_oders;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konto);

        name = (TextView) findViewById(R.id.name);
        name.setText(getIntent().getExtras().getString("name"));
        nazwisko = (TextView) findViewById(R.id.nazwisko);
        nazwisko.setText(getIntent().getExtras().getString("nazwisko"));
        saldo = (TextView) findViewById(R.id.saldo);
        saldo.setText(getIntent().getExtras().getString("saldo"));
        all_olders = (TextView) findViewById(R.id.all_olders);
        all_olders.setText(getIntent().getExtras().getString("all_olders"));
        cur_oders = (TextView) findViewById(R.id.cur_oders);
        cur_oders.setText(getIntent().getExtras().getString("cur_oders"));

    }


    }



