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

    private String barcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_badge);
    }

    public void scanBadge1(View view){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    public void admin(View view){
        Intent adminScreen = new Intent(ScanBadge.this, AdminOptions.class);
        ScanBadge.this.startActivity(adminScreen);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("ScanBadge", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("ScanBadge", "Scanned");
                barcode = result.getContents().substring(1);

                Toast.makeText(this, "Scanned: " + barcode, Toast.LENGTH_LONG).show();
                processScan();
//                startActivity(options, scanResults);
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
            Toast.makeText(this, "something goofed", Toast.LENGTH_LONG).show();
        }
    }
    public void processScan(){
        Intent optionsScreen = new Intent(ScanBadge.this, OptionsScreen.class);
        optionsScreen.putExtra("barcode", barcode);
        ScanBadge.this.startActivity(optionsScreen);
    }

}

