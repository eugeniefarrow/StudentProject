package org.pltw.examples.math_inq;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    final private String APP_ID = "C19B1FFA-0215-D85D-FFD4-F432D9B1BE00";
    final private String SECRET_KEY = "7669F556-496B-67E4-FFA7-64434AFBF400";
    private String TAG = "";
    final public String MY_EMAIL_ADDRESS = "manningk12.ks@gmail.com";
    final public static String EMAIL_PREF = "EMAIL PREF";
    private TextView userEmail;
    private EditText userEmail1;
    private TextView password;
    private EditText password1;
    private String mUserEmail;
    private String mPassword;
    public Login(){}


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);



        userEmail = (TextView) rootView.findViewById(R.id.UserEmail);
        userEmail1 = (EditText) rootView.findViewById(R.id.UserEmail);
        password = (TextView) rootView.findViewById(R.id.UserPassword);
        password1 = (EditText) rootView.findViewById(R.id.UserPassword);

        Button registerButton = (Button) rootView.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            Intent intent = new Intent(getActivity(), Register.class);
            startActivity(intent);
            }
        });

        Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserEmail = String.valueOf(userEmail1.getText());
                mPassword = String.valueOf(password1.getText());
                Intent intent1 = new Intent(getActivity(), Home.class);
                startActivity(intent1);

                //loginUserAsync(mUserEmail,mPassword);
            }
        });

        return rootView;
    }

    private void loginUserAsync(final String user, String pass)
    {
        AsyncCallback<BackendlessUser> callback = new AsyncCallback<BackendlessUser>()
        {
            @Override
            public void handleResponse( BackendlessUser loggedInUser )
            {
                Intent intent1 = new Intent(getActivity(), Home.class);
                startActivity(intent1);
            }

            @Override
            public void handleFault( BackendlessFault backendlessFault )
            {
                Toast.makeText(getContext(),"Invalid Email or Password",Toast.LENGTH_SHORT).show();
            }
        };

        Backendless.UserService.login( user, pass , callback );
    }
}

