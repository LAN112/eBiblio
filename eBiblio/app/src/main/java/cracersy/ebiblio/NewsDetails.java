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

public class NewsDetails extends AppCompatActivity {

    public News news;
    public TextView tytul, text;
    Context context=this;
    CountDownTimer mCountDownTimer;
    private JSONObject end_response;
    ImageView cover;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        dialog=new Dialog(context);

        String news_id = getIntent().getExtras().getString("id");
        cover = (ImageView)findViewById(R.id.cover_img);
        tytul = (TextView) findViewById(R.id.tytul);
        text = (TextView) findViewById(R.id.text);

        news=new News("id",news_id,context);
        mCountDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                dialog.resume();
                if (news.news_image_url!=null){
                    mCountDownTimer.cancel();
                    Picasso.with(getApplicationContext()).load(news.news_image_url).into(cover);
                    tytul.setText(news.news_title);
                    text.setText(news.news_text);
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
