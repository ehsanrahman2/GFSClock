package com.github.gfsclock.gfstimeclock;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.gfsclock.apimapper.APIMapperOffline;
import com.github.gfsclock.apimapper.PunchModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class OptionsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_screen);

        Intent intent = getIntent();
        String id = intent.getStringExtra("barcode");
        employeeID =  Integer.parseInt(id.substring(id.length()-5, id.length()));
        punches = mapper.getPunchesID(employeeID);

    }

    private int employeeID = 0;
    private APIMapperOffline mapper = APIMapperOffline.getInstance();
    private ArrayList<PunchModel> punches;



    // TODO make formatting betterer
    public void showPunchHistoryDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(OptionsScreen.this);
        builder.setTitle(getString(R.string.punch_history));
        String punchHistory = "";
        for (int i = 0; i < punches.size(); i++) {
            punchHistory += punches.get(i).getDocket()+ " " + punches.get(i).getTimeStamp() + "\n";
        }
        builder.setMessage(punchHistory);
        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void clockIn(View view){
        mapper.punch(employeeID, "F1", new Date());
        backToScanBadge();
    }

    public void breakOut(View view){
        mapper.punch(employeeID, "F2", new Date());
        backToScanBadge();
    }

    public void lunchOut(View view){
        mapper.punch(employeeID, "F3", new Date());
        backToScanBadge();
    }

    public void clockOut(View view){
        mapper.punch(employeeID, "F5", new Date());
        backToScanBadge();
    }

    public void breakIn(View view) {
        mapper.punch(employeeID, "F6", new Date());
        backToScanBadge();
    }

    public void lunchIn(View view){
        mapper.punch(employeeID, "F7", new Date());
        backToScanBadge();
    }

    public void changeJob(View view){
        backToScanBadge();
        // TODO disabled for now
    }

    // Intent to go back
    public void backToScanBadge(){
        Intent backToScanBadge = new Intent(OptionsScreen.this, ScanBadge.class);
        OptionsScreen.this.startActivity(backToScanBadge);
    }
}
