package com.cforlando.streetartandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesUtil;

public class LicenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);

        String licenseText = GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(this);

        TextView tv = (TextView)findViewById(R.id.legal);
        if (licenseText == null) {
            Toast.makeText(LicenseActivity.this,
                    "Google Play Services not available on this device",
                    Toast.LENGTH_SHORT).show();
        } else {
            tv.setText(licenseText);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
