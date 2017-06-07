package org.pltw.examples.math_inq;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class Add extends AppCompatActivity {
    private static final String TAG = "CameraDemo";
    private byte[] picture;
    Camera camera;
    Preview preview;
    Button buttonClick;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        /*
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Camera");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        */
        preview = new Preview(this);
        ((FrameLayout) findViewById(R.id.preview)).addView(preview);

        buttonClick = (Button) findViewById(R.id.buttonClick);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                preview.camera.takePicture(shutterCallback, rawCallback,
                        jpegCallback);
            }
        });

        Log.d(TAG, "onCreate'd");


        Button addButton = (Button) findViewById(R.id.nextButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(getApplicationContext(), AddTo.class);
                startActivity(add);
            }
        });

    }

    android.hardware.Camera.ShutterCallback shutterCallback = new android.hardware.Camera.ShutterCallback() {
        public void onShutter() {
            Log.d(TAG, "onShutter'd");
        }
    };

    /** Handles data for raw picture */
    android.hardware.Camera.PictureCallback rawCallback = new android.hardware.Camera.PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            Log.d(TAG, "onPictureTaken - raw");
            picture = data;
        }
    };

    /** Handles data for jpeg picture */
    android.hardware.Camera.PictureCallback jpegCallback = new android.hardware.Camera.PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            FileOutputStream outStream = null;

            try {
                // write to local sandbox file system
                outStream =
                openFileOutput(String.format("%d.jpg",
                System.currentTimeMillis()), 0);
                // Or write to sdcard
                //outStream = new FileOutputStream(String.format(
                //        "/sdcard/%d.jpg", System.currentTimeMillis()));
                outStream.write(data);
                outStream.close();
                Log.d(TAG, "onPictureTaken - wrote bytes: " + data.length);
                setPicture(data);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
            Log.d(TAG, "onPictureTaken - jpeg");

        }
    };
    public void setPicture(byte[] pic){
        picture = pic;
    }
    public byte[] getPicture(){
        return picture;
    }
}

