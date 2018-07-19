package binarygeek.phonebookWithMVP.MainView;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import binarygeek.phonebookWithMVP.Data.Constants;
import binarygeek.phonebookWithMVP.Data.DataController;
import binarygeek.phonebookWithMVP.Data.Database;
import binarygeek.phonebookWithMVP.Data.MyDatabase;
import binarygeek.phonebookWithMVP.Utils.DialogBuilder;

/**
 * Created by uy on 7/6/2018.
 */

public class MainPresenter implements MainViewPresenterContract.Presenter {

    public MainViewPresenterContract.MainView mainView;
    public DataController dataController;
    public DatabaseQueryClass databaseQueryClass;
    MyDatabase myDatabase;
    public Context context;

     public MainPresenter (MainViewPresenterContract.MainView mainView, Context context){
         this.mainView=mainView;
         dataController = new DataController();

         //databaseQueryClass=new DatabaseQueryClass(context);

         myDatabase =new MyDatabase(context);

         myDatabase.getAllDistrict(Constants.RajshahiDivison);


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

        myDatabase.getAllDistrict(Constants.RajshahiDivison);

        if(pos==0){
            Log.d("GK","Division name :"+Database.getDataOfDhakaDivision().divisionName);
             dataController.setDivision(Database.getDataOfDhakaDivision());
         }

    }

    @Override
    public void goToDistrictActivity(Context context, ArrayList<String> items) {
        DialogBuilder.buildDialog(context,items);
    }
}
