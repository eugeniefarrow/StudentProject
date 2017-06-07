package org.pltw.examples.math_inq;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 1005269 on 5/12/2017.
 */
public class AddTo extends Activity{

    private String TAG = "AddTO";
    private Spinner spinner1;
    private byte[] pic;
    private ArrayList<String> comments;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addto);
        Add num1 = new Add();
        pic = num1.getPicture();


        ImageView imgViewer = (ImageView) findViewById(R.id.imageView4);
        Bitmap bm = BitmapFactory.decodeByteArray(pic, 0, pic.length);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        imgViewer.setMinimumHeight(dm.heightPixels);
        imgViewer.setMinimumWidth(dm.widthPixels);
        imgViewer.setImageBitmap(bm);

        //addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new AddHelper());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner);
        Button finalize = (Button) findViewById(R.id.finalize);

        finalize.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),
                        "OnClickListener : " +
                                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) ,
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}
