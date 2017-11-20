package cracersy.ebiblio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import java.util.ArrayList;

public class Newlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newlist);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.articles);
        // w celach optymalizacji
        recyclerView.setHasFixedSize(true);

        // ustawiamy LayoutManagera
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ustawiamy animatora, który odpowiada za animację dodania/usunięcia elementów listy
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//Zakomentowane do czasu implementacji api
       //ArrayList<Newlist> new_array;

       //recyclerView.setAdapter(new MyAdapter(new_array, recyclerView, this));


    }


}
