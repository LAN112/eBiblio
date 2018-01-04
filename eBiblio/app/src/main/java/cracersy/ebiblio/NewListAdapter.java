package cracersy.ebiblio;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sobot on 30.10.2017.
 */

public class NewListAdapter extends RecyclerView.Adapter {


    // źródło danych
    private ArrayList<JSONObject> mArticles = new ArrayList<>();

    // obiekt listy artykułów
    private RecyclerView mRecyclerView;
    Context okk;

    // implementacja wzorca ViewHolder
    // każdy obiekt tej klasy przechowuje odniesienie do layoutu elementu listy
    // dzięki temu wywołujemy findViewById() tylko raz dla każdego elementu
    private class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public TextView mContent;


        public MyViewHolder(View pItem) {
            super(pItem);
            mTitle = (TextView) pItem.findViewById(R.id.config_title);
            mContent = (TextView) pItem.findViewById(R.id.config_subtitle);
        }
    }

    // konstruktor adaptera
    public NewListAdapter(ArrayList<JSONObject> pArticles, RecyclerView pRecyclerView, Context ctx){
        mArticles = pArticles;
        mRecyclerView = pRecyclerView;
        okk= ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        // tworzymy layout artykułu oraz obiekt ViewHoldera
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.one_book_on_list, viewGroup, false);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position=mRecyclerView.getChildAdapterPosition(v);
                String news_id=mArticles.get(position).optString("news_id");

                Intent Intent = new Intent(mRecyclerView.getContext(), NewsDetails.class);
                Intent.putExtra("id", news_id);
                mRecyclerView.getContext().startActivity(Intent);

            }
        });

        // tworzymy i zwracamy obiekt ViewHolder
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        // uzupełniamy layout artykułu
        JSONObject object = mArticles.get(i);
        ((MyViewHolder) viewHolder).mTitle.setText(object.optString("news_title"));
        ((MyViewHolder) viewHolder).mContent.setText(object.optString("news_short_text"));
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}