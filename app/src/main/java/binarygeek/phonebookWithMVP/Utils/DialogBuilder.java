package binarygeek.phonebookWithMVP.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

import java.util.ArrayList;

import binarygeek.phonebookWithMVP.Data.Constants;
import binarygeek.phonebookWithMVP.Data.DataController;
import binarygeek.phonebookWithMVP.Data.sqliteAssetHelper;

public
class DialogBuilder {

    public static CharSequence selectedItem;
    public static DataController dataController;
    public static  void buildDialog(final Activity activity, final ArrayList<String>itemList, final String flag) {

       final CharSequence[] items = itemList.toArray(new CharSequence[itemList.size()]);
        int itemSelected = 0;

        selectedItem=items[0];


        dataController = (DataController)activity.getApplicationContext();

        new AlertDialog.Builder(activity)

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

                        if (flag.equals(Constants.flagDistrict)) {
                            dataController.setDistrict(selectedItem.toString());
                            buildDialog(activity, sqliteAssetHelper.getInstance(activity).getAllThana(selectedItem.toString()),Constants.flagThana);
                        }
                        else if(flag.equals(Constants.flagThana)){
                            dataController.setThana(selectedItem.toString());
                            buildDialog(activity, sqliteAssetHelper.getInstance(activity).getPoliceOfficerList(selectedItem.toString()),Constants.flagPolice);
                        }
                        else if(flag.equals(Constants.flagPolice)){
                            sqliteAssetHelper.getInstance(activity).getPoliceIDAndGoPoliceStation(selectedItem.toString(),dataController.getThana(),dataController.getDistrict());
                        }
                    }
                })
                .show();

        Log.d("GK","Keyword :"+dataController.getDistrict());

    }

}
