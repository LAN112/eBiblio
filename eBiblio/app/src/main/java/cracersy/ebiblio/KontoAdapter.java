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

/**
 * Created by Joaś on 30.12.2017.
 */

public class KontoAdapter  extends RecyclerView.Adapter {


    // źródło danych
    private ArrayList<JSONObject> mArticles = new ArrayList<>();

    // obiekt listy artykułów
    private RecyclerView mRecyclerView;
    Context okk;
    private String ID_USER;

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
    public KontoAdapter(ArrayList<JSONObject> pArticles, RecyclerView pRecyclerView, Context ctx) {
        mArticles = pArticles;
        mRecyclerView = pRecyclerView;
        okk = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        // tworzymy layout artykułu oraz obiekt ViewHoldera
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.konto2, viewGroup, false);


        // tworzymy i zwracamy obiekt ViewHolder
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        // uzupełniamy layout artykułu
        JSONObject object = mArticles.get(i);
        ((KontoAdapter.MyViewHolder) viewHolder).mTitle.setText(object.optString("imie"));
        ((KontoAdapter.MyViewHolder) viewHolder).mContent.setText(object.optString("nazwisko"));

    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}