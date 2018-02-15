package br.harlan.satisfactionsurvey.view;

import android.content.DialogInterface;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.MenuItem;
import android.widget.EditText;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.singleton.NavigationServicesSingleton;
import br.harlan.satisfactionsurvey.view.services.NavigationServices;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String PASSWORD = "cangaspar@123";

    public HomeActivity() {
        super(R.layout.activity_home);
    }

    @Override
    protected void initializeComponents() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationServices = NavigationServicesSingleton.getInstance(this, getSupportFragmentManager());
        navigationServices.setLayout(R.id.coordinator_layout);
        navigationServices.loadFragment(new SearchFragment());
        //getSupportFragmentManager().beginTransaction().replace(R.id.coordinator_layout, new SearchFragment()).commit();
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
            checkPermissionAcess(new WithAwnser() {
                @Override
                public void awnser(boolean action) {
                    if (action)
                        getSupportFragmentManager().beginTransaction().replace(R.id.coordinator_layout, new HistoricFragment()).commit();
                }
            });
        } else if (id == R.id.nav_graphics) {
            checkPermissionAcess(new WithAwnser() {
                @Override
                public void awnser(boolean action) {
                    if (action)
                        getSupportFragmentManager().beginTransaction().replace(R.id.coordinator_layout, new ChartFragment()).commit();
                }
            });
        } else if (id == R.id.nav_12notas) {
            navigationServices.navigateTo(About12NotasActivity.class);
        } else if (id == R.id.nav_help) {
            navigationServices.navigateTo(AboutActivity.class);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void checkPermissionAcess(final WithAwnser withAwnser){
        final EditText edtPassword = new EditText(this);
        edtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Senha");
        builder.setMessage("Digite a senha de acesso:");
        builder.setView(edtPassword);
        builder.setPositiveButton("Acessar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(validadeAcess(edtPassword.getText().toString()))
                    withAwnser.awnser(true);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                withAwnser.awnser(false);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private boolean validadeAcess(String password) {
        return password.equals(PASSWORD);
    }

    interface WithAwnser {
        void awnser(boolean action);
    }
}