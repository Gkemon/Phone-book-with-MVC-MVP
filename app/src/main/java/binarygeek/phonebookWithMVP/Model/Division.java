package binarygeek.phonebookWithMVP.Model;

import java.util.ArrayList;

/**
 * Created by uy on 7/5/2018.
 */

public class Division {
    public String divisionName;
    public ArrayList<District> districtArrayList;

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public ArrayList<District> getDistrictArrayList() {
        return districtArrayList;
    }

    public void setDistrictArrayList(ArrayList<District> districtArrayList) {
        this.districtArrayList = districtArrayList;
    }
}
