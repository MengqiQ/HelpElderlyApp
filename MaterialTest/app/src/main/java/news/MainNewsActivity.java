package news;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.materialtest.R;

import news.Activity.BaseActivity;
import news.fragment.NewsFragment;


public class MainNewsActivity extends BaseActivity
        //implements NavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //默认fragment
        NewsFragment fragment=new NewsFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
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
        getMenuInflater().inflate(R.menu.news_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//            NewsFragment fragment=new NewsFragment();
//            FragmentManager fragmentManager=getSupportFragmentManager();
//            FragmentTransaction transaction=fragmentManager.beginTransaction();
//            transaction.replace(R.id.fragment_container,fragment);
//            transaction.commit();
//
//        } else if (id == R.id.nav_gallery) {
//            Toast.makeText(getApplicationContext(),
//                 "还在开发中O_O", Toast.LENGTH_LONG).show();
//
//        } else if (id == R.id.nav_slideshow) {
//            // Handle the camera action
//            MeiNvFragment fragment=new MeiNvFragment();
//            FragmentManager fragmentManager=getSupportFragmentManager();
//            FragmentTransaction transaction=fragmentManager.beginTransaction();
//            transaction.replace(R.id.fragment_container,fragment);
//            transaction.commit();
//
//        } else if (id == R.id.nav_manage) {
//            Toast.makeText(getApplicationContext(),
//                    "还在开发中O_O", Toast.LENGTH_LONG).show();
//        } else if (id == R.id.nav_share) {
//            Toast.makeText(getApplicationContext(),
//                    "还在开发中O_O", Toast.LENGTH_LONG).show();
//        } else if (id == R.id.nav_send) {
//            Toast.makeText(getApplicationContext(),
//                    "还在开发中O_O", Toast.LENGTH_LONG).show();
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
