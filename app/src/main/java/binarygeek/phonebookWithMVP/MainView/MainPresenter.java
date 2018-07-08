package binarygeek.phonebookWithMVP.MainView;

import android.util.Log;

import java.util.Arrays;

import binarygeek.phonebookWithMVP.Data.DataController;
import binarygeek.phonebookWithMVP.Data.Database;

/**
 * Created by uy on 7/6/2018.
 */

public class MainPresenter implements MainViewPresenterContract.Presenter {

    public MainViewPresenterContract.MainView mainView;
    public DataController dataController;

     public MainPresenter (MainViewPresenterContract.MainView mainView){
         this.mainView=mainView;
         dataController = new DataController();

         mainView.setDivisions(Arrays.asList(
                 "ঢাকা",
                 "চট্টগ্রাম",
                 "সিলেট",
                 "বরিশাল",
                 "রাজশাহী",
                 "রংপুর",
                 "বরিশাল",
                 "খুলনা",
                 "ময়মনসিংহ"
         ));
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void loadDataAfterClickDivision(int pos) {

        if(pos==0){
            Log.d("GK","Division name :"+Database.getDataOfDhakaDivision().divisionName);
             dataController.setDivision(Database.getDataOfDhakaDivision());
         }

    }

    @Override
    public void goToDistrictActivity() {

    }
}
