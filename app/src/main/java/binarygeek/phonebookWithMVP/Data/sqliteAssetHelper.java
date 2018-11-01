package binarygeek.phonebookWithMVP.Data;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

import binarygeek.phonebookWithMVP.MainView.MainActivity;
import binarygeek.phonebookWithMVP.Model.policeOfficer;
import binarygeek.phonebookWithMVP.PoliceStatioDetailsView.PoliceStationDetailsActivity;

/**
 * Created by uy on 7/19/2018.
 */

public class sqliteAssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = ConfigDB.DB_NAME;
    private static final int DATABASE_VERSION = 1;
    private  Context context ;

    public sqliteAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    public static sqliteAssetHelper getInstance(Context context){
        return new sqliteAssetHelper(context);
    }

    public ArrayList<String> getAllDistrict(String division ){
        SQLiteDatabase db=getWritableDatabase();

        Cursor cursor = null;
        try {

            String[] projection = {
                    ConfigDB.COLUMN_DISTRICTS};

            //TODO: First argument is true for getting distinct element

            cursor = db.query(true,ConfigDB.TABLE_POLICE, projection,ConfigDB.whereDivision_is_+"'"+division+"'", null, null, null, null,null);



            if(cursor!=null)
                if(cursor.moveToFirst()){
                    ArrayList<String> districtList = new ArrayList<>();
                    do {
                        cursor.getColumnIndex(ConfigDB.COLUMN_DISTRICTS);
                        districtList.add(cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_DISTRICTS)));

                        Log.d("GK",cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_DISTRICTS))+" district");
                    }   while (cursor.moveToNext());

                    return districtList;
                }
        } catch (Exception e){
            Log.d("GK","ERROR :"+ e);
        } finally {
            if(cursor!=null)
                cursor.close();
            db.close();
        }

        return null;
    }

    public ArrayList<String> getAllThana(String district ){
        SQLiteDatabase db=getWritableDatabase();

        Cursor cursor = null;
        try {

            String[] projection = {
                    ConfigDB.COLUMN_THANA};

            //TODO: First argument is true for getting distinct element

            cursor = db.query(true,ConfigDB.TABLE_POLICE, projection,ConfigDB.whereDistrict_is_+"'"+district+"'", null, null, null, null,null);



            if(cursor!=null)
                if(cursor.moveToFirst()){
                    ArrayList<String> thanaList = new ArrayList<>();
                    do {
                        cursor.getColumnIndex(ConfigDB.COLUMN_THANA);
                        thanaList.add(cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_THANA)));

                        Log.d("GK",cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_THANA))+" thana");
                    }   while (cursor.moveToNext());

                    return thanaList;
                }
        } catch (Exception e){
            Log.d("GK","ERROR :"+ e);
        } finally {
            if(cursor!=null)
                cursor.close();
            db.close();
        }

        return null;
    }

    public policeOfficer getPoliceObject(Integer id){
        SQLiteDatabase db=getWritableDatabase();

        Cursor cursor = null;
        try {

            String[] projection = {
                    ConfigDB.COLUMN_ID,ConfigDB.COLUMN_NAME,ConfigDB.COLUMN_PHONE_1,ConfigDB.COLUMN_PHONE_2,ConfigDB.COLUMN_PHONE_3,ConfigDB.COLUMN_EMAIL,ConfigDB.COLUMN_DISTRICTS,ConfigDB.COLUMN_THANA};

            //TODO: First argument is true for getting distinct element

            cursor = db.query(true,ConfigDB.TABLE_POLICE, projection,ConfigDB.whereID_is_+id, null, null, null, null,null);

            //select police_id from Police_officers where name= 'ওসি' AND thana='গোদাগাড়ী থানা' AND district='রাজশাহী'


            if(cursor!=null)
                if(cursor.moveToFirst()){
                 policeOfficer policeOfficer=new policeOfficer();

                    do {

                        policeOfficer.setPoliceOfficerName(cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_NAME)));
                        policeOfficer.setDistrict(cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_DISTRICTS)));
                        policeOfficer.setEmail(cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_EMAIL)));

                        policeOfficer.setPhone1(cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_PHONE_1)));
                        policeOfficer.setPhone2(cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_PHONE_2)));
                        policeOfficer.setPhone3(cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_PHONE_3)));

                        policeOfficer.setThana(cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_THANA)));

                        Log.d("GK",cursor.getInt(cursor.getColumnIndex(ConfigDB.COLUMN_ID))+" police ID object");

                        return policeOfficer;


                    }   while (cursor.moveToNext());


                }
        } catch (Exception e){
            Log.d("GK","ERROR :"+ e);
        } finally {
            if(cursor!=null)
                cursor.close();
            db.close();
        }

        return null ;
    }
    public void getPoliceIDAndGoPoliceStation(String name, String thana , String district){
        SQLiteDatabase db=getWritableDatabase();

        Cursor cursor = null;
        try {

            String[] projection = {
                    ConfigDB.COLUMN_ID};

            //TODO: First argument is true for getting distinct element

            cursor = db.query(true,ConfigDB.TABLE_POLICE, projection,ConfigDB.whereName_is_+"'"+name+"' AND "+ConfigDB.whereThana_is_+"'"+thana+"' AND "+ConfigDB.whereDistrict_is_+"'"+district+"'", null, null, null, null,null);

            //select police_id from Police_officers where name= 'ওসি' AND thana='গোদাগাড়ী থানা' AND district='রাজশাহী'


            if(cursor!=null)
                if(cursor.moveToFirst()){

                    do {
                        cursor.getColumnIndex(ConfigDB.COLUMN_ID);
                        Intent intent=new Intent(context,PoliceStationDetailsActivity.class);

                        intent.putExtra("ID",cursor.getInt(cursor.getColumnIndex(ConfigDB.COLUMN_ID)));
                        context.startActivity(intent);

                        Log.d("GK",cursor.getInt(cursor.getColumnIndex(ConfigDB.COLUMN_ID))+" police ID");
                    }   while (cursor.moveToNext());

                    return ;
                }
        } catch (Exception e){
            Log.d("GK","ERROR :"+ e);
        } finally {
            if(cursor!=null)
                cursor.close();
            db.close();
        }

        return ;
    }

    public ArrayList<String> getPoliceOfficerList(String thana){
        SQLiteDatabase db=getWritableDatabase();

        Cursor cursor = null;
        try {

            String[] projection = {
                    ConfigDB.COLUMN_NAME};

            //TODO: First argument is true for getting distinct element

            cursor = db.query(true,ConfigDB.TABLE_POLICE, projection,ConfigDB.whereThana_is_+"'"+thana+"'", null, null, null, null,null);



            if(cursor!=null)
                if(cursor.moveToFirst()){
                    ArrayList<String> policeList = new ArrayList<>();
                    do {
                        cursor.getColumnIndex(ConfigDB.COLUMN_NAME);
                        policeList.add(cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_NAME)));

                        Log.d("GK",cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_NAME))+" police officer");
                    }   while (cursor.moveToNext());

                    return policeList;
                }
        } catch (Exception e){
            Log.d("GK","ERROR :"+ e);
        } finally {
            if(cursor!=null)
                cursor.close();
            db.close();
        }

        return null;
    }

}
