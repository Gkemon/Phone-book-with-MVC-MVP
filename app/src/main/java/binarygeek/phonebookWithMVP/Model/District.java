package binarygeek.phonebookWithMVP.Model;

import java.util.ArrayList;

/**
 * Created by uy on 7/6/2018.
 */

public class District {
    public String DistrictName;
    public ArrayList<Thana> thanaArrayList;

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String districtName) {
        DistrictName = districtName;
    }

    public ArrayList<Thana> getThanaArrayList() {
        return thanaArrayList;
    }

    public void setThanaArrayList(ArrayList<Thana> thanaArrayList) {
        this.thanaArrayList = thanaArrayList;
    }
}
