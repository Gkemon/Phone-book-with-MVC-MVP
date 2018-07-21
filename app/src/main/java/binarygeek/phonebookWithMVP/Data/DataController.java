package binarygeek.phonebookWithMVP.Data;

import android.app.Application;

/**
 * Created by uy on 7/8/2018.
 */

//After click any division in bangladesh then it will hold the specific division's full data
public class DataController extends Application {
    public String division;
    public String district;
    public String thana;
    public String policeID;

    public String getPoliceID() {
        return policeID;
    }

    public void setPoliceID(String policeID) {
        this.policeID = policeID;
    }



    public void setDistrict(String district) {
        this.district = district;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }



    public String getDistrict() {
        return district;
    }

    public String getThana() {
        return thana;
    }


    public String getDivision() {
        return division;
    }
    public void setDivision(String division) {
        this.division = division;
    }


//    public String keyWordFromDialoge;
//
//    public String getKeyWordFromDialoge() {
//        return keyWordFromDialoge;
//    }
//
//    public void setKeyWordFromDialoge(String keyWordFromDialoge) {
//        this.keyWordFromDialoge = keyWordFromDialoge;
//    }
}
