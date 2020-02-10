package com.cse327.pothik.Help;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.cse327.pothik.R;

import io.smooch.ui.ConversationActivity;


public class ChatActivity extends AppCompatActivity
        implements ChatNavigationDrawerFragment.NavigationDrawerCallbacks {

    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity_main);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (position) {
            case 0:
                IntroductionFragment introductionFragment = new IntroductionFragment();

                fragmentManager.beginTransaction()
                        .replace(R.id.container, introductionFragment)
                        .commit();
                break;
            case 1:
                ConversationActivity.show(this);
                break;
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
        }
    }

    void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

}
