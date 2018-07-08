package binarygeek.phonebookWithMVP.Model;

import java.util.ArrayList;

/**
 * Created by uy on 7/6/2018.
 */

public class policeOfficer {
    public String policeOfficerName;
    public ArrayList<String> phoneNumberList;
    public ArrayList<String> emailList;

    public ArrayList<String> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(ArrayList<String> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public ArrayList<String> telephoneNumberList;

    public String getPoliceOfficerName() {
        return policeOfficerName;
    }

    public void setPoliceOfficerName(String policeOfficerName) {
        this.policeOfficerName = policeOfficerName;
    }

    public ArrayList<String> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(ArrayList<String> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    public ArrayList<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(ArrayList<String> emailList) {
        this.emailList = emailList;
    }
}
