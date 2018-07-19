package binarygeek.phonebookWithMVP.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by uy on 7/19/2018.
 */

public class MyDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = ConfigDB.DB_NAME;
    private static final int DATABASE_VERSION = 1;
    private  Context context;
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    public List<String> getAllDistrict(String division ){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor = null;
        try {

            String[] projection = {
                    ConfigDB.COLUMN_DISTRICTS};

            //TODO: First argument is true for getting distinct element

            cursor = db.query(true,ConfigDB.TABLE_POLICE, projection,ConfigDB.whereDistrict_is_+"'"+division+"'", null, null, null, null,null);



            if(cursor!=null)
                if(cursor.moveToFirst()){
                    List<String> districtList = new ArrayList<>();
                    do {
                        cursor.getColumnIndex(ConfigDB.COLUMN_DISTRICTS);
                        Log.d("GK",cursor.getString(cursor.getColumnIndex(ConfigDB.COLUMN_DISTRICTS))+" district");
                    }   while (cursor.moveToNext());

                    return districtList;
                }
        } catch (Exception e){

            Log.d("GK","ERROR :"+ e);
            Toast.makeText(context, "Operation failed", Toast.LENGTH_SHORT).show();
        } finally {
            if(cursor!=null)
                cursor.close();
            db.close();
        }

        return Collections.emptyList();
    }



}
