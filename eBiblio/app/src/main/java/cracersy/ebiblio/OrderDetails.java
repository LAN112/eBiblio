package cracersy.ebiblio;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

public class OrderDetails extends AppCompatActivity {
    public Order zamowienie;
    public TextView text;
    Context context=this;
    CountDownTimer mCountDownTimer;
    private JSONObject end_response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);


        String id_order = getIntent().getExtras().getString("id_order");

        text = (TextView) findViewById(R.id.order_number);

        zamowienie=new Order("id_order",id_order,context);
        mCountDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (zamowienie.data_zwrotu!=null){
                    millisUntilFinished=0;
                }
            }
            @Override
            public void onFinish() {
                text.setText(zamowienie.id_order);
            }
        };
        mCountDownTimer.start();

    }
}
