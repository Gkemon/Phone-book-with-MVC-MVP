package binarygeek.phonebookWithMVP.Data;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static binarygeek.phonebookWithMVP.Data.ConfigDB.DB_NAME;

/**
 * Created by uy on 7/17/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    //The Android's default system path of your application database.

    private SQLiteDatabase myDataBase;

    private final Context myContext;


    private static DatabaseHelper databaseHelper;

    private DatabaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    public static synchronized DatabaseHelper getInstance(Context context){
        if(databaseHelper==null){
            databaseHelper = new DatabaseHelper(context);
        }
        return databaseHelper;
    }



    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if(dbExist){
            Log.d("GK","DB exist");
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            Log.d("GK","DB not exist");
            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }


    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{


            File file = myContext.getDatabasePath(DB_NAME);
            if (file.exists() && !file.isDirectory()){
                checkDB = SQLiteDatabase.openDatabase( myContext.getDatabasePath(DB_NAME).getPath(), null, SQLiteDatabase.OPEN_READONLY);
                myDataBase=checkDB;
            }
            else {
                Log.d("GK","File not open");
            }


        }catch(SQLiteException e){

            Log.d("GK","DB not exist exeption");

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }


    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(myContext.getDatabasePath(DB_NAME).getPath());

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        myDataBase = SQLiteDatabase.openDatabase(myContext.getDatabasePath(DB_NAME).getPath(), null, SQLiteDatabase.OPEN_READONLY);


    }

    public SQLiteDatabase getDataBase(){
       return myDataBase;
    }


    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
