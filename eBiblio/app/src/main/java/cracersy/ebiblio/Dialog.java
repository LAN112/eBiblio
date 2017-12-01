package cracersy.ebiblio;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by sobot on 01.12.2017.
 */

public class Dialog {
    public AlertDialog.Builder dialog;
    public AlertDialog alert;


    public Dialog(Context context){
        dialog = new AlertDialog.Builder(context);
        dialog.setTitle("Proszę czekać, wczytuję.")
                .setIcon(R.drawable.icons8_news_feed);
        alert=dialog.create();
        alert.show();
    }

    public void stop(){
        if (alert.isShowing()) {
            alert.dismiss();
        }
    }

    public void resume(){
        if (!alert.isShowing()) {
            alert.show();
        }
    }


}
