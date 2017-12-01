package cracersy.ebiblio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class book_description extends AppCompatActivity {
    public TextView opis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_description);
        opis = (TextView) findViewById(R.id.opis);
        opis.setText(getIntent().getExtras().getString("opis"));
    }
}
