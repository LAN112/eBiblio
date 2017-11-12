package cracersy.ebiblio;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;




//public class MyNewlistAdapter extends RecyclerView.Adapter {


//Zakomentowane do czasu implementacji api
/*
// źródło danych
private ArrayList<Command> mArticles = new ArrayList<>();

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
public MyNewlistAdapter(ArrayList<Command> pArticles, RecyclerView pRecyclerView, Context ctx){
mArticles = pArticles;
mRecyclerView = pRecyclerView;
okk= ctx;
}

@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
// tworzymy layout artykułu oraz obiekt ViewHoldera
View view = LayoutInflater.from(viewGroup.getContext())
.inflate(R.layout.config_layout, viewGroup, false);

// dla elementu listy ustawiamy obiekt OnClickListener,
// który usunie element z listy po kliknięciu na niego
view.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

//Kasowanie elementu
// odnajdujemy indeks klikniętego elementu
int position = mRecyclerView.getChildAdapterPosition(v);
// usuwamy element ze źródła danych
//    mArticles.remove(positionToDelete);
// poniższa metoda w animowany sposób usunie element z listy
//    notifyItemRemoved(positionToDelete);


Command_time_dialog dialog123;


//                    mArticles.remove(position);
//               //  poniższa metoda w animowany sposób usunie element z listy
//                    notifyItemRemoved(position);


//                Intent Intent = new Intent(mRecyclerView.getContext(), One_config.class);
//                Intent.putExtra("Position", position);
//                mRecyclerView.getContext().startActivity(Intent);

}
});

// tworzymy i zwracamy obiekt ViewHolder
return new MyViewHolder(view);
}

@Override
public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
// uzupełniamy layout artykułu
Command command = mArticles.get(i);
((MyViewHolder) viewHolder).mTitle.setText(command.mName);
((MyViewHolder) viewHolder).mContent.setText(command.mDescription);
}

@Override
public int getItemCount() {
return mArticles.size();
}
*/
//}