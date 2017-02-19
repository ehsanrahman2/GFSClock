package com.github.gfsclock.gfstimeclock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class ScanBadge extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_badge);
    }

    public void scanBadge1(View view){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String scanResults, scanFormat;
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
//                Log.d("ScanBadge", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
//                Log.d("ScanBadge", "Scanned");
                scanResults = result.getContents();
                scanFormat = result.getFormatName();
                Toast.makeText(this, "Scanned: " + scanResults + " Format: " + scanFormat, Toast.LENGTH_LONG).show();

                // call OptionsScreen activity here
//                Intent options = new Intent(this, OptionsScreen.class);
//                startActivity(options, scanResults);
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}

