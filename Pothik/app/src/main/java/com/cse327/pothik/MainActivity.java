package com.cse327.pothik;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cse327.pothik.ARview.ARActivity;
import com.cse327.pothik.Help.ChatActivity;
import com.cse327.pothik.Setting.VideoAdapter;
import com.cse327.pothik.Setting.YoutubeVideo;
import com.cse327.pothik.login.FacebookSignInFragment;
import com.cse327.pothik.login.LoginActivity;
import com.cse327.pothik.notification.NotifyUser;
import com.cse327.pothik.splash.SplashActivity;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.Vector;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView nav_header_Name;
    TextView nav_header_email;
    NavigationView navigationView;
    ImageView profilePic;

    FloatingActionButton floatingActionButtonb;

    NotifyUser notifyUser;



;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        buildNotification();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setNaveBarValues();


        //ARcamera button starts
        floatingActionButtonb = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButtonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ARActivity.class);
                startActivity(intent);
            }
        });
        //ARcamera button ends






    }
    public void setNaveBarValues(){
      //  FirebaseUser mauth = FirebaseAuth.getInstance().getCurrentUser();

        View view =  navigationView.getHeaderView(0);

        nav_header_Name = (TextView)view.findViewById(R.id.name);
        nav_header_email = (TextView)view.findViewById(R.id.email);
        profilePic = (ImageView)view.findViewById(R.id.propic);


/*        nav_header_Name.setText(mauth.getDisplayName()+"");
        nav_header_email.setText(mauth.getEmail()+"");
        Picasso.with(this).load(mauth.getPhotoUrl()).into(profilePic);*/

        nav_header_Name.setText("Name");
        nav_header_email.setText("Password");
//        Picasso.with(this).load(mauth.getPhotoUrl()).into(profilePic);



    }






    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        int id = item.getItemId();

        if (id == R.id.mapview) {
            // Handle the camera action
        } else if (id == R.id.arview) {

        } else if (id == R.id.help) {
            Intent intent1 = new Intent(getApplicationContext(), ChatActivity.class);
            startActivity(intent1);



        } else if (id == R.id.logout) {
         //   FirebaseAuth.getInstance().signOut();
            FacebookSignInFragment.fbLogout();
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            finish();
            startActivity(intent);



        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void makeNotify() {
//        sendNotification();
        Context context = getApplicationContext();

        notifyUser = new NotifyUser(context,MainActivity.class);
        notifyUser.sendNotification();
    }






}
