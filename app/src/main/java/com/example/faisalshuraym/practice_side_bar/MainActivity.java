/*
Author: Faisal Shuraym

 */

package com.example.faisalshuraym.practice_side_bar;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.faisalshuraym.practice_side_bar.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding the id for the tool bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // find drawer, Navigation view id and set
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // button in top left corner
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // to display the fragment when lunching the app
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                    , new StoresFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_store);
        }

    }

    @Override // items selected in navigation bar

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.nav_store:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                        ,new StoresFragment()).commit();
                break;

            case R.id.nav_orders:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                        ,new Orders_Fragment()).commit();
                break;

            case R.id.nav_notification:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                        ,new Notification_Fragment()).commit();
                break;

            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                        ,new Profile_Fragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override // when pressing back bottom.
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }
}
