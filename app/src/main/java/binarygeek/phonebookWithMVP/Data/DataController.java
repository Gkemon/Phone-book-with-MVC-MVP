package binarygeek.phonebookWithMVP.Data;

import android.app.Application;

import binarygeek.phonebookWithMVP.Model.Division;

/**
 * Created by uy on 7/8/2018.
 */

//After click any division in bangladesh then it will hold the specific division's full data
public class DataController extends Application {
    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }


    public Division division;

}
