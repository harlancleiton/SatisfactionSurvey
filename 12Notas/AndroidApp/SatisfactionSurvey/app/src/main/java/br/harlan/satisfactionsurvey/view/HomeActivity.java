package br.harlan.satisfactionsurvey.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.harlan.satisfactionsurvey.R;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public HomeActivity() {
        super(R.layout.activity_home);
    }

    @Override
    protected void initializeComponents() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.coordinator_layout, new SearchFragment()).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void addEvents() {

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_note_add) {
            getSupportFragmentManager().beginTransaction().replace(R.id.coordinator_layout, new SearchFragment()).commit();
        } else if (id == R.id.nav_historic) {
            getSupportFragmentManager().beginTransaction().replace(R.id.coordinator_layout, new HistoricFragment()).commit();
        } else if (id == R.id.nav_graphics) {
            getSupportFragmentManager().beginTransaction().replace(R.id.coordinator_layout, new ChartFragment()).commit();
        } else if (id == R.id.nav_12notas) {
            navigationServices.navigateTo(About12NotasActivity.class);
        } else if (id == R.id.nav_help) {
            navigationServices.navigateTo(AboutActivity.class);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
