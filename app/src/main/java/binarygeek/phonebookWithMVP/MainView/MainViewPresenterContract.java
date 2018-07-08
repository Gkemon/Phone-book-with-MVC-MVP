package binarygeek.phonebookWithMVP.MainView;

import android.view.View;

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
          void  loadDataAfterClickDivision(int pos);
          void  goToDistrictActivity();
      }

}
