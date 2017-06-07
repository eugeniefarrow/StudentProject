package org.pltw.examples.math_inq;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;


public class Home extends Activity implements NavigationView.OnNavigationItemSelectedListener {
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LocalActivityManager mlam = new LocalActivityManager(this, false);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        mlam.dispatchCreate(savedInstanceState);
        tabHost.setup(mlam);

        TabHost.TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Second Tab");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("Third tab");

        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        tab1.setIndicator("Home");
        tab1.setContent(new Intent(this, Tab1Activity.class));

        tab2.setIndicator("Add");
        tab2.setContent(new Intent(this, Add.class));

        tab3.setIndicator("profile");
        tab3.setContent(new Intent(this, profile.class));

        /** Add the tabs  to the TabHost to display.*/
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);

        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(16);
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){

        // called when a drawer has settled in a completely open state

    public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        invalidateOptionsMenu();

     }
   };

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
   @Override
   public boolean onPrepareOptionsMenu(Menu menu){
       // If the drawer is open, hide action items related to the content view
       boolean drawerOpen = drawer.isDrawerOpen(menu);
       menu.findItem(R.id.action_settings.setVisible(!drawerOpen));
       return super.onPrepareOptionsMenu(menu);

   }


    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent contentIntent = null;
        int id = item.getItemId();

        if (id == R.id.algebra1) {
            contentIntent = new Intent(this, Algebra1.class);
        }
        else if (id == R.id.algebra2) {
            contentIntent = new Intent(this, Algebra2.class);
        }
        else if (id == R.id.trigonometry) {
            contentIntent = new Intent(this, Trig.class);
        }
        else if (id == R.id.geometry) {
            contentIntent = new Intent(this, Geometry.class);
        }
        else if (id == R.id.preCalc) {
            contentIntent = new Intent(this, PreCalc.class);
        }
        else if (id == R.id.calc) {
            contentIntent = new Intent(this, Calc.class);
        }

        if (contentIntent != null) {
            startActivity(contentIntent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

