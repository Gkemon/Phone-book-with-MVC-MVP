package binarygeek.phonebookWithMVP.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import java.util.ArrayList;

public
class DialogBuilder {

    public static CharSequence selectedItem;

    public static String buildDialog(Context context, final ArrayList<String>itemList) {

       final CharSequence[] items = itemList.toArray(new CharSequence[itemList.size()]);
        int itemSelected = 0;

        new AlertDialog.Builder(context)

                .setSingleChoiceItems(items, itemSelected, new DialogInterface.OnClickListener() {
                    @Override
                    public
                    void onClick(DialogInterface dialogInterface, int i) {

                        selectedItem = "";
                        selectedItem = items[i];

                        Log.d("GK", "selectedReport " + selectedItem);

                    }

                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public
                    void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }

                })
                .setPositiveButton("Go", new DialogInterface.OnClickListener() {
                    @Override
                    public
                    void onClick(DialogInterface dialogInterface, int i) {

                    }

                })
                .show();

        return "";

    }

}
