package binarygeek.phonebookWithMVP.PoliceStatioDetailsView;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import binarygeek.phonebookWithMVP.Data.sqliteAssetHelper;
import binarygeek.phonebookWithMVP.Model.policeOfficer;
import binarygeek.phonebookWithMVP.R;


public class PoliceStationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_station_details);
        if (-1 != getIntent().getIntExtra("ID", -1)) {
            Toast.makeText(PoliceStationDetailsActivity.this, "ID get", Toast.LENGTH_LONG).show();



            policeOfficer policeOfficer = new policeOfficer();
            policeOfficer = sqliteAssetHelper.getInstance(PoliceStationDetailsActivity.this).getPoliceObject(getIntent().getIntExtra("ID", -1));

            settingCallButtons(policeOfficer);
            settingEmailButtons(policeOfficer);
            settingSMSButton(policeOfficer);







        }else {
            Toast.makeText(PoliceStationDetailsActivity.this,"ID not get",Toast.LENGTH_LONG).show();
        }
    }

    void settingCallButtons(policeOfficer policeOfficer){

        Button call1 = findViewById(R.id.btn_call_1);
        if(policeOfficer.getPhone1()==null)call1.setVisibility(View.GONE);
        Button call2 = findViewById(R.id.btn_call_2);
        if(policeOfficer.getPhone2()==null)call1.setVisibility(View.GONE);
        Button call3 = findViewById(R.id.btn_call_3);
        if(policeOfficer.getPhone3()==null)call1.setVisibility(View.GONE);


        final binarygeek.phonebookWithMVP.Model.policeOfficer finalPoliceOfficer = policeOfficer;



        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + finalPoliceOfficer.phone1));
                if (ActivityCompat.checkSelfPermission(PoliceStationDetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PoliceStationDetailsActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }
                PoliceStationDetailsActivity.this.startActivity(intent);
            }
        });


        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + finalPoliceOfficer.phone2));
                if (ActivityCompat.checkSelfPermission(PoliceStationDetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PoliceStationDetailsActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }
                PoliceStationDetailsActivity.this.startActivity(intent);
            }
        });


        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + finalPoliceOfficer.phone3));
                if (ActivityCompat.checkSelfPermission(PoliceStationDetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PoliceStationDetailsActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }
                PoliceStationDetailsActivity.this.startActivity(intent);
            }
        });


    }



    void settingEmailButtons(policeOfficer policeOfficer){

        Button emailButton = findViewById(R.id.btn_email_1);


       if(policeOfficer.email==null)emailButton.setVisibility(View.GONE);


        final binarygeek.phonebookWithMVP.Model.policeOfficer finalPoliceOfficer = policeOfficer;

       final String[] recipients={"emon.info2013@gmail.com"};



        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    Intent intent=new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "HELP");
                    intent.putExtra(Intent.EXTRA_TEXT, "Sir,please help me !");
                    intent.setType("text/html");
                    intent.setPackage("com.google.android.gm");
                    startActivity(Intent.createChooser(intent, "Send mail"));


                    startActivity(intent);
                }catch(ActivityNotFoundException e){

                }
            }
        });




    }

    void settingSMSButton(final policeOfficer policeOfficer){

        Button smsButton1=findViewById(R.id.btn_sms_1);
        if(policeOfficer.getPhone1()==null)smsButton1.setVisibility(View.GONE);
        Button smsButton2=findViewById(R.id.btn_sms_2);
        if(policeOfficer.getPhone2()==null)smsButton2.setVisibility(View.GONE);
        Button smsButton3=findViewById(R.id.btn_sms_3);
        if(policeOfficer.getPhone3()==null)smsButton3.setVisibility(View.GONE);



        smsButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"+ policeOfficer.getPhone1()));
                startActivity(sendIntent);

            }
        });

        smsButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"+ policeOfficer.getPhone2()));
                startActivity(sendIntent);
            }
        });

        smsButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"+ policeOfficer.getPhone3()));
                startActivity(sendIntent);
            }
        });


    }

}
