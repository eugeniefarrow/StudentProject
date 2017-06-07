package org.pltw.examples.math_inq;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.backendless.Backendless;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity{
        final private String APP_ID = "C19B1FFA-0215-D85D-FFD4-F432D9B1BE00";
        final private String SECRET_KEY = "7669F556-496B-67E4-FFA7-64434AFBF400";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_main);

        String appVersion = "v1";
        Backendless.initApp(this, APP_ID, SECRET_KEY, appVersion);

        //Login frag = (Login)getFragmentManager().findFragmentById(R.id.login);

    }
}
