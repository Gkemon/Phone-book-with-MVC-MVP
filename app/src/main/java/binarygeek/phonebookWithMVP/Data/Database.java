package binarygeek.phonebookWithMVP.Data;

import java.util.ArrayList;

import binarygeek.phonebookWithMVP.Model.District;
import binarygeek.phonebookWithMVP.Model.Division;
import binarygeek.phonebookWithMVP.Model.Thana;
import binarygeek.phonebookWithMVP.Model.policeOfficer;

/**
 * Created by uy on 7/6/2018.
 */

public class Database {
  public static Division getDataOfDhakaDivision(){
        //Division
        Division dhaka = new Division();
        dhaka.setDivisionName("ঢাকা বিভাগ");

        //District under dhaka
        District dhakaDistrict = new District();
        dhakaDistrict.setDistrictName("ঢাকা জেলা");

        Thana badda = new Thana();
        badda.setThanaName("বাড্ডা");

        ArrayList<policeOfficer> baddaPoliceOfficerList=new ArrayList<>();

        policeOfficer baddaPoliceOfficer1 = new policeOfficer();

        baddaPoliceOfficer1.setPoliceOfficerName("MD Golam kibria emon");

        ArrayList <String> baddaPoliceOfficer1Telephones = new ArrayList<>();
        baddaPoliceOfficer1Telephones.add("01234212314");
        baddaPoliceOfficer1Telephones.add("01234212314");


        ArrayList <String> baddaPoliceOfficer1Emails = new ArrayList<>();
        baddaPoliceOfficer1Emails.add("emon.info@gmail.com");
        baddaPoliceOfficer1Emails.add("emon.info@gmail.com");

        ArrayList<String> baddaPoliceOfficerPhones = new ArrayList<>();
        baddaPoliceOfficerPhones.add("01234212314");
        baddaPoliceOfficerPhones.add("23423345333");

        baddaPoliceOfficerList.add(baddaPoliceOfficer1);



        badda.setPoliceOfficerArrayList(baddaPoliceOfficerList);

        ArrayList<Thana> dhakaDistrictThanaList = new ArrayList<>();


        dhakaDistrictThanaList.add(badda);

        dhakaDistrict.setThanaArrayList(dhakaDistrictThanaList);

        ArrayList<District> dhakaDivisionDistrictList = new ArrayList<>();
        dhakaDivisionDistrictList.add(dhakaDistrict);

        dhaka.setDistrictArrayList(dhakaDivisionDistrictList);


return dhaka;

    }

}
