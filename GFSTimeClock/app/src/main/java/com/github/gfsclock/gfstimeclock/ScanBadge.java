package com.github.gfsclock.gfstimeclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.integration.android.IntentIntegrator;


public class ScanBadge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_badge);
    }

    public void scanBadge1(View view){
        new IntentIntegrator(this).initiateScan();
    }
}
