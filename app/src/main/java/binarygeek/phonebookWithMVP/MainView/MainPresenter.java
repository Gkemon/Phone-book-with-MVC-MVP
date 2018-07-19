package binarygeek.phonebookWithMVP.MainView;

import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import binarygeek.phonebookWithMVP.Data.Constants;
import binarygeek.phonebookWithMVP.Data.DataController;
import binarygeek.phonebookWithMVP.Data.sqliteAssetHelper;
import binarygeek.phonebookWithMVP.Utils.DialogBuilder;

/**
 * Created by uy on 7/6/2018.
 */

public class MainPresenter implements MainViewPresenterContract.Presenter {

    public MainViewPresenterContract.MainView mainView;
    public DataController dataController;
    public sqliteAssetHelper mDatabaseHelper;
    public Activity context;
    public String district,thana;

     public MainPresenter (MainViewPresenterContract.MainView mainView, Activity context){
         this.mainView=mainView;
         this.context=context;

         dataController = new DataController();
         mDatabaseHelper =new sqliteAssetHelper(context);

         mainView.setDivisions(Arrays.asList(Constants.DhakaDivison,
                 Constants.ChittagoanDivison,
                 Constants.BarishalDivison,
                 Constants.SylhetDivison,
                 Constants.RajshahiDivison,
                 Constants.RangpureDivison,
                 Constants.MymansinghDivison,
                 Constants.KhulnaDivison
         ));
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }


    @Override
    public void setGlobalDataAfterClickDivision(int pos) {



        if(pos==0){
            district=createDialog(context,mDatabaseHelper.getAllDistrict(Constants.DhakaDivison));
         }else if (pos == 1){
            district=createDialog(context,mDatabaseHelper.getAllDistrict(Constants.ChittagoanDivison));
        }else if (pos == 2){
            district=createDialog(context,mDatabaseHelper.getAllDistrict(Constants.BarishalDivison));
        }else if (pos == 3){
            district=createDialog(context,mDatabaseHelper.getAllDistrict(Constants.SylhetDivison));
        }else if (pos == 4){
            district=createDialog(context,mDatabaseHelper.getAllDistrict(Constants.RajshahiDivison));
        }else if (pos == 5){
            district=createDialog(context,mDatabaseHelper.getAllDistrict(Constants.RangpureDivison));
        }else if (pos == 6){
            district=createDialog(context,mDatabaseHelper.getAllDistrict(Constants.MymansinghDivison));
        }else if (pos == 7){
            district=createDialog(context,mDatabaseHelper.getAllDistrict(Constants.KhulnaDivison));
        }

        if(district!=null){
            thana=createDialog(context,mDatabaseHelper.getAllThana(district));
        }

        if(thana!=null) Toast.makeText(context,"Thana :"+thana,Toast.LENGTH_LONG).show();



    }


    @Override
    public String createDialog(Activity activity, ArrayList<String> items) {

         if(items!=null){
             return DialogBuilder.buildDialog(activity,items);
         }
         else return null;
    }
}
