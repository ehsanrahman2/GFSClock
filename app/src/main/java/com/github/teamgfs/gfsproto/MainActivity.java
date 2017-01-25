package com.github.teamgfs.gfsproto;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_PERMISSIONS_REQUEST = 211;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnPrescan = (Button) findViewById(R.id.btn_prescan);
        btnPrescan.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int permissionCheck = ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.CAMERA);
                        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSIONS_REQUEST);
                        } else {
                            Intent intent = new Intent(v.getContext(), ScannerActivity.class);
                            startActivity(intent);
                        }

                    }
                }
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CAMERA_PERMISSIONS_REQUEST:
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // granted
                Intent intent = new Intent(this, ScannerActivity.class);
                startActivity(intent);

            } else {
                // not granted
                Toast.makeText(this, "Unable to access camera without permissions.", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
