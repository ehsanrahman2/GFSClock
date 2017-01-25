package com.github.teamgfs.gfsproto;


import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class CodeScanner extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder mHolder;
    private Camera mCamera;

    public CodeScanner(Context context, Camera camera) {
        super(context);
        mCamera = camera;

        // Callback lets us know when surface is created/killed
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void surfaceCreated(SurfaceHolder holder) {
        // try to draw preview on surface
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (IOException e) {
            Log.d(TAG, "Error establishing camera preview: " + e.getMessage());
        }
    }

    public void surfaceChanged(SurfaceHolder older, int format, int width, int height) {
        if(mHolder.getSurface() == null) {
            // no preview
            return;
        }

        try {
            mCamera.stopPreview();
        } catch (Exception e) {
            // ignore
        }

        // camera preview settings

        // new preview
        try {
            mCamera.setPreviewDisplay(mHolder);
            mCamera.startPreview();
        } catch (Exception e) {
            Log.d(TAG, "Error starting camera preview: " + e.getMessage());
        }
    }
}
