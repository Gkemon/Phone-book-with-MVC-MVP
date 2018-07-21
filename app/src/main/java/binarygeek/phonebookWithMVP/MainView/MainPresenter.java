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
            createDialog(context,mDatabaseHelper.getAllDistrict(Constants.DhakaDivison),Constants.flagDistrict);
         }else if (pos == 1){
            createDialog(context,mDatabaseHelper.getAllDistrict(Constants.ChittagoanDivison),Constants.flagDistrict);
        }else if (pos == 2){
            createDialog(context,mDatabaseHelper.getAllDistrict(Constants.BarishalDivison),Constants.flagDistrict);
        }else if (pos == 3){
            createDialog(context,mDatabaseHelper.getAllDistrict(Constants.SylhetDivison),Constants.flagDistrict);
        }else if (pos == 4){
            createDialog(context,mDatabaseHelper.getAllDistrict(Constants.RajshahiDivison),Constants.flagDistrict);
        }else if (pos == 5){
            createDialog(context,mDatabaseHelper.getAllDistrict(Constants.RangpureDivison),Constants.flagDistrict);
        }else if (pos == 6){
            createDialog(context,mDatabaseHelper.getAllDistrict(Constants.MymansinghDivison),Constants.flagDistrict);
        }else if (pos == 7){
            createDialog(context,mDatabaseHelper.getAllDistrict(Constants.KhulnaDivison),Constants.flagDistrict);
        }



        if(district!=null){
            createDialog(context,mDatabaseHelper.getAllThana(district),Constants.flagThana);
        }


        if(thana!=null) Toast.makeText(context,"Thana :"+thana,Toast.LENGTH_LONG).show();


    }


    @Override
    public void createDialog(Activity activity, ArrayList<String> items,String flag) {
          DialogBuilder.buildDialog(activity,items,flag);
    }

}
