package binarygeek.phonebookWithMVP.PoliceStatioDetailsView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

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
            Button call1 = findViewById(R.id.call1);
            call1.setText(policeOfficer.phone1);

            final binarygeek.phonebookWithMVP.Model.policeOfficer finalPoliceOfficer = policeOfficer;
            call1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + finalPoliceOfficer.phone1));

                    if (ActivityCompat.checkSelfPermission(PoliceStationDetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    PoliceStationDetailsActivity.this.startActivity(intent);
    }
});
        }else {
            Toast.makeText(PoliceStationDetailsActivity.this,"ID not get",Toast.LENGTH_LONG).show();
        }
    }
}
