package com.example.hupsub_91;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab, fab1, fab2, fab3;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    boolean isOpen = false; ///by default it is false

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    ///add the fragments

    private AHome1Fragment aHome1Fragment;
    private BFood2Fragment bFood2Fragment;
    private CEnterMusic3Fragment cEnterMusic3Fragment;
    private DDasboard4Fragment dDasboard4Fragment;
    private EbuySell5Fragment ebuySell5Fragment;
    private FRent6Fragment fRent6Fragment;
    private IProfile7Fragment iProfile7Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        // animation
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add function here
                animateFab();

            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///add function here
                Toast.makeText(MainActivity.this, "Icon Click", Toast.LENGTH_LONG).show();

            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add funtion here
                Toast.makeText(MainActivity.this, "Icon Click", Toast.LENGTH_LONG).show();
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add funtion here
                Toast.makeText(MainActivity.this, "cliked", Toast.LENGTH_LONG).show();
            }
        });


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        aHome1Fragment = new AHome1Fragment();
        bFood2Fragment = new BFood2Fragment();
        cEnterMusic3Fragment = new CEnterMusic3Fragment();
        dDasboard4Fragment = new DDasboard4Fragment();
        ebuySell5Fragment = new EbuySell5Fragment();
        fRent6Fragment = new FRent6Fragment();
        iProfile7Fragment = new IProfile7Fragment();

        tabLayout.setupWithViewPager(viewPager);

//add page function>>
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);

        viewPagerAdapter.addFragment(aHome1Fragment,"");
        viewPagerAdapter.addFragment(bFood2Fragment,"");
        viewPagerAdapter.addFragment(cEnterMusic3Fragment, "");
        viewPagerAdapter.addFragment(dDasboard4Fragment,"");
        viewPagerAdapter.addFragment(ebuySell5Fragment, "");
        viewPagerAdapter.addFragment(fRent6Fragment,"");
        viewPagerAdapter.addFragment(iProfile7Fragment,"");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_bfood_green);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_center_music);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_ddashboard_green);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_e_landscape_green);
        tabLayout.getTabAt(5).setIcon(R.drawable.ic_fdirections_car_green);
        tabLayout.getTabAt(6).setIcon(R.drawable.ic_iperson_green);

        BadgeDrawable badgeDrawable = tabLayout.getTabAt(0).getOrCreateBadge();
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(19);

    }
//add page function^^

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            fragmentTitle.add(title);

        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
    ///fab animation function
    private void animateFab(){
        if (isOpen){
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab3.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isOpen=false;
        }
        else{
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab3.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isOpen=true;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "notic click", Toast.LENGTH_LONG).show();
        }else if (id == R.id.action_search){
            Toast.makeText(getApplicationContext(),"Iconned click", Toast.LENGTH_LONG).show();
        }else if (id == R.id.action_sms){
            Toast.makeText(getApplicationContext(),"Sms clicked", Toast.LENGTH_LONG).show();
        }else if (id == R.id.action_sort){
            Toast.makeText(getApplicationContext(), "Sort click", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}