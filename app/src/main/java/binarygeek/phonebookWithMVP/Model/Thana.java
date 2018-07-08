package binarygeek.phonebookWithMVP.Model;

import java.util.ArrayList;

/**
 * Created by uy on 7/6/2018.
 */

public class Thana {
    public String ThanaName;
    public ArrayList<policeOfficer> policeOfficerArrayList;

    public String getThanaName() {
        return ThanaName;
    }

    public void setThanaName(String thanaName) {
        ThanaName = thanaName;
    }

    public ArrayList<policeOfficer> getPoliceOfficerArrayList() {
        return policeOfficerArrayList;
    }

    public void setPoliceOfficerArrayList(ArrayList<policeOfficer> policeOfficerArrayList) {
        this.policeOfficerArrayList = policeOfficerArrayList;
    }
}
