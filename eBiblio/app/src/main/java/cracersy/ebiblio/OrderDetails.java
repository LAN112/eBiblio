package cracersy.ebiblio;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

public class OrderDetails extends AppCompatActivity {
    public Order zamowienie;
    public TextView ID_order, data_zamowienia, data_odbioru, data_zwrotu, tytul;
    Context context=this;
    CountDownTimer mCountDownTimer, mmCountDownTimer;
    private JSONObject end_response;
    private Dialog dialog;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        dialog=new Dialog(context);

        String id_order = getIntent().getExtras().getString("id_order");

        ID_order = (TextView)findViewById(R.id.id_order);
        data_zamowienia = (TextView) findViewById(R.id.data_zamowienia);
        data_odbioru = (TextView) findViewById(R.id.data_odbioru);
        data_zwrotu = (TextView) findViewById(R.id.data_zwrotu);
        tytul = (TextView) findViewById(R.id.tytul);


        zamowienie=new Order("id_order",id_order,context);
        mCountDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                dialog.resume();
                if (zamowienie.data_zwrotu!=null){
                    mCountDownTimer.cancel();
                    book=new Book("id", zamowienie.id_book,context);

                    mmCountDownTimer = new CountDownTimer(10000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            dialog.resume();
                            if (book.tytul!=null){
                                mmCountDownTimer.cancel();
                                tytul.setText("Tytuł: " + book.tytul);
                                dialog.stop();
                            }
                        }
                        @Override
                        public void onFinish() {}
                    };
                    mmCountDownTimer.start();

                    ID_order.setText("ID zamówienia: " + zamowienie.id_order);
                    data_zamowienia.setText("Data zamówienia: " + zamowienie.data_zamowienia);
                    data_odbioru.setText("Data odbioru: " + zamowienie.data_odbioru);
                    data_zwrotu.setText("Data zwrotu: " + zamowienie.data_zwrotu);
                    dialog.stop();
                }
            }
            @Override
            public void onFinish() {
            }
        };
        mCountDownTimer.start();

    }
}
