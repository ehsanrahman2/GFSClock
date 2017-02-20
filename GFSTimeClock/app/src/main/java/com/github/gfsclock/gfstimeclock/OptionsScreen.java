package com.github.gfsclock.gfstimeclock;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class OptionsScreen extends AppCompatActivity {

    // UI Controls
//    Button clockInButton = (Button) findViewById(R.id.ClockInButton);
//    Button clockOutButton = (Button) findViewById(R.id.ClockOutButton);
//    Button breakInButton = (Button) findViewById(R.id.BreakInButton);
//    Button breakOutButton = (Button) findViewById(R.id.BreakOutButton);
//    Button lunchInButton = (Button) findViewById(R.id.LunchInButton);
//    Button lunchOutButton = (Button) findViewById(R.id.LunchOutButton);
//    Button punchHistoryButton = (Button) findViewById(R.id.PunchHistoryButton);
//    Button changeJobButton = (Button) findViewById(R.id.ChangeJobButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_screen);
    }

    // Method called to display punch history dialog.
    // TODO call apimapper with actual api call to get punch history
    public void showPunchHistoryDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(OptionsScreen.this);
        builder.setTitle(getString(R.string.punch_history));
        builder.setMessage(getString(R.string.dummy_history));
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
        Intent intent = getIntent();
        String id = intent.getStringExtra("barcode");

    }

    // Intent to go back
    public void backToScanBadge(){
        Intent backToScanBadge = new Intent(OptionsScreen.this, ScanBadge.class);
        OptionsScreen.this.startActivity(backToScanBadge);
    }
}
