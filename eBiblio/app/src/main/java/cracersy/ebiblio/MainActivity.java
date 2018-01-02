package cracersy.ebiblio;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private EditText edtSeach;
    GridView simpleList;
    ArrayList<Item> optionList = new ArrayList<>();

    protected void handleMenuSearch(){
        ActionBar action = getSupportActionBar(); //get the actionbar

        if(isSearchOpened){ //test if the search is open

            action.setDisplayShowCustomEnabled(false); //disable a custom view inside the actionbar
            action.setDisplayShowTitleEnabled(true); //show the title in the action bar

            //hides the keyboard

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtSeach.getWindowToken(), 0);

            //add the search icon in the action bar
            mSearchAction.setIcon(getResources().getDrawable(R.drawable.icons8_search_filled));

            isSearchOpened = false;
        } else { //open the search entry

            action.setDisplayShowCustomEnabled(true); //enable it to display a
            // custom view in the action bar.
            action.setCustomView(R.layout.search_bar);//add the custom view
            action.setDisplayShowTitleEnabled(false); //hide the title

            edtSeach = (EditText)action.getCustomView().findViewById(R.id.edtSearch); //the text editor

            //this is a listener to do a search when the user clicks on search button
            edtSeach.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        doSearch();
                        return true;
                    }
                    return false;
                }
            });


            edtSeach.requestFocus();

            //open the keyboard focused in the edtSearch
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edtSeach, InputMethodManager.SHOW_IMPLICIT);


            //add the close icon
            mSearchAction.setIcon(getResources().getDrawable(R.drawable.icons8_cancel));

            isSearchOpened = true;
        }
    }


    @Override
    public void onBackPressed() {
        if(isSearchOpened) {
            handleMenuSearch();
            return;
        }
        super.onBackPressed();
    }

    private void doSearch() {
//
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater();
        mSearchAction = menu.findItem(R.id.action_search);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_logout:
                boolean success = false;
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            case R.id.action_search:
                handleMenuSearch();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    Context context;
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        simpleList = (GridView) findViewById(R.id.simpleGridView);
        optionList.add(new Item("Mój regał",R.drawable.icons8_book_shelf));
        optionList.add(new Item("Biblioteka",R.drawable.icons8_library));
        optionList.add(new Item("Nowości",R.drawable.icons8_exclamation_mark));
        optionList.add(new Item("Zapamiętane",R.drawable.icons8_save));
        optionList.add(new Item("Moje konto",R.drawable.icons8_user));
        optionList.add(new Item("Aktualności",R.drawable.icons8_news_feed));

        MyAdapter myAdapter=new MyAdapter(this,R.layout.grid_view_items,optionList);
        simpleList.setAdapter(myAdapter);

        String uname=getIntent().getExtras().getString("username");
        user=new User(uname, context);


        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                    final Intent intent;
                    switch(position)
                    {
                        case 0:
                            intent =  new Intent(v.getContext(), MojRegal.class);
                            intent.putExtra("id_user", user.id_user);
                            break;

                        case 1:
                            intent =  new Intent(v.getContext(), Biblioteka.class);
                            intent.putExtra("id_user", user.id_user);
                            break;
                        case 3:
                            intent =  new Intent(v.getContext(), zapamietane.class);
                            intent.putExtra("id_user", user.id_user);
                            break;
                        case 4:
                            intent =  new Intent(v.getContext(), KontoDetails.class);
                            intent.putExtra("id_user", user.id_user);
                            break;
                        case 5:
                            intent =  new Intent(v.getContext(), Newlist.class);
                            intent.putExtra("id_user", user.id_user);
                            break;
                        default:
                            intent =  new Intent(v.getContext(), LoginActivity.class);
                            intent.putExtra("id_user", user.id_user);
                            break;
                    }
                    startActivity(intent);


                }
            });





    }



}
