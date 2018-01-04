package cracersy.ebiblio;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import org.json.JSONObject;

import java.util.ArrayList;

public class Newlist extends AppCompatActivity {
    private static final String TAG = "Biblioteka";
    private JSONObject end_response;
    private CountDownTimer mCountDownTimer;
    private RecyclerView recyclerView;
    private Context context;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteka);
        context=this;
        dialog=new Dialog(context);



        recyclerView = (RecyclerView) findViewById(R.id.articles);
        // w celach optymalizacji
        recyclerView.setHasFixedSize(true);

        // ustawiamy LayoutManagera
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ustawiamy animatora, który odpowiada za animację dodania/usunięcia elementów listy
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final AllNews wszystkie= new AllNews("wszystko", "0", this);


        mCountDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                dialog.resume();
                if (wszystkie.end_response.size()!= 0){
                    mCountDownTimer.cancel();
                    recyclerView.setAdapter(new NewListAdapter(wszystkie.end_response, recyclerView, context));
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
