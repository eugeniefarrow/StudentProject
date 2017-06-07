package org.pltw.examples.math_inq;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends AppCompatActivity {
    private String TAG = "";
    final public String MY_EMAIL_ADDRESS = "manningk12.ks@gmail.com";
    final public static String EMAIL_PREF = "EMAIL PREF";
    private TextView userEmail1;
    private TextView password1;
    private String mUserEmail;
    private String mPassword;

    public Register() {
        // Required empty public constructor
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userEmail1 = (TextView) findViewById(R.id.UserEmail01);
        password1 = (TextView) findViewById(R.id.Password01);

        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Going to register");
                registerMethod();
            }
        });
    }

    public void registerMethod(){
        BackendlessUser user = new BackendlessUser();
        mUserEmail = userEmail1.getText().toString();
        mPassword = password1.getText().toString();
        Log.d(TAG, mPassword + "     " + mUserEmail);

        if (!mUserEmail.equals(null) && !mPassword.equals(null)) {
            user.setEmail(mUserEmail);
            user.setPassword(mPassword);
            Backendless.UserService.register(user, new BackendlessCallback<BackendlessUser>() {
                @Override
                public void handleResponse(BackendlessUser BackendlessUser) {
                    Log.i("Registration:", BackendlessUser.getEmail() + " registered");
                    Intent intent = new Intent(getApplicationContext(),Home.class);
                    startActivity(intent);

                }
                public void handleFault( BackendlessFault fault ) {
                    Log.d(TAG,"Handle fault message");
                    fault.getCode();
                }
            });


            SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(EMAIL_PREF, MY_EMAIL_ADDRESS);
            editor.commit();


        }
        else
        Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();

    }


}

