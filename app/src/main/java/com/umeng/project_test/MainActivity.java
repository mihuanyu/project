package com.umeng.project_test;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.umeng.project_test.fragment.HomeFragment;
import com.umeng.project_test.fragment.VideosFragment;


public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrame;
    private BottomNavigationView mNavigationview;
    private VideosFragment videosFragment;
    private HomeFragment homeFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        videosFragment = new VideosFragment();
        homeFragment = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame,videosFragment).add(R.id.frame,homeFragment).show(videosFragment).hide(homeFragment).commit();

        mNavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.videos:
                        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                        fragmentTransaction1.show(videosFragment).hide(homeFragment).commit();
                        break;
                    case R.id.mine:
                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                        fragmentTransaction2.show(homeFragment).hide(videosFragment).commit();
                }
                return false;
            }
        });
    }

    private void initView() {
        mFrame = (FrameLayout) findViewById(R.id.frame);
        mNavigationview = (BottomNavigationView) findViewById(R.id.navigationview);
    }
}
