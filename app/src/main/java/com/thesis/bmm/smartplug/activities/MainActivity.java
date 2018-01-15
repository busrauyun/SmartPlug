package com.thesis.bmm.smartplug.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.thesis.bmm.smartplug.R;
import com.thesis.bmm.smartplug.adapter.ViewPagerAdapter;
import com.thesis.bmm.smartplug.fragments.PlugsFragment;
import com.thesis.bmm.smartplug.fragments.SupportFragment;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {
    private TabLayout tabLayout = null;
    private ViewPager vpFragments = null;
    private Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();
    }

    private void initView() {
        tabLayout = findViewById(R.id.activity_main_tablayout);
        vpFragments = findViewById(R.id.activity_main_vpFragments);
        toolbar = findViewById(R.id.toolbar);
        initEvent();
    }

    private void initEvent() {
        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(vpFragments);
        tabLayout.addOnTabSelectedListener(this);
        ViewPagerAdapter viewpagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        PlugsFragment plugsFragment = new PlugsFragment();
        SupportFragment supportFragment = new SupportFragment();
        viewpagerAdapter.addFragment(plugsFragment, "Prizler");
        viewpagerAdapter.addFragment(supportFragment, "Destek");
        vpFragments.setAdapter(viewpagerAdapter);
        vpFragments.addOnPageChangeListener(this);
        vpFragments.setCurrentItem(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
