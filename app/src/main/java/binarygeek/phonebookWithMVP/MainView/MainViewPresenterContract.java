package binarygeek.phonebookWithMVP.MainView;

import android.app.Activity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import binarygeek.phonebookWithMVP.BasePresenter;
import binarygeek.phonebookWithMVP.BaseRecyclerClickListener;

/**
 * Created by uy on 7/6/2018.
 */

public class MainViewPresenterContract  {


    interface MainView extends BaseRecyclerClickListener
    {
        void setDivisions(List<String> divisionList);
        @Override
        void onItemClick(int position, View view);
    }

      interface Presenter extends BasePresenter {
          void setGlobalDataAfterClickDivision(int pos);
          void createDialog(Activity activity, ArrayList<String> items,String flagForInput);//flagForInput is the flag by which we can know what we want to display for input.District,thana,police etc.

      }

}
