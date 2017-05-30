package com.brill.nitesh.myapplication.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.brill.nitesh.myapplication.Fragments.ContactUsFragment;
import com.brill.nitesh.myapplication.Fragments.EventFragment;
import com.brill.nitesh.myapplication.Fragments.LIveFragment;
import com.brill.nitesh.myapplication.Fragments.LoginFragment;
import com.brill.nitesh.myapplication.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by iiro on 7.6.2016.
 */
public class HomeActivity extends AppCompatActivity implements EventFragment.OnFragmentInteractionListener, LIveFragment.OnFragmentInteractionListener, LoginFragment.OnFragmentInteractionListener, ContactUsFragment.OnFragmentInteractionListener {

    private String nitesh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_changing_tabs);


        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Fragment mFragment = null;


                //==
                switch (tabId) {
                    case R.id.tab_Event:

                        mFragment = EventFragment.newInstance("Recents", "");
                        break;
                    case R.id.tab_Live:

                        mFragment = LIveFragment.newInstance("Favorites", "");

                        break;
                    case R.id.tab_Contact:

                        mFragment = ContactUsFragment.newInstance("Nearby", "");
                        break;
                    case R.id.tab_Login:

                        mFragment = LoginFragment.newInstance("Friends", "");
                        break;

                }
                if (mFragment != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, mFragment);
                    fragmentTransaction.commit();
                    //  messageView.setText(message);
                }

            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}