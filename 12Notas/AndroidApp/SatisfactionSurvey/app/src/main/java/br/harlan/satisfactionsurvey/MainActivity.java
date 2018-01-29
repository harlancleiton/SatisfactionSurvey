package br.harlan.satisfactionsurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseInstallation;

import br.harlan.satisfactionsurvey.view.HomeActivity;
import br.harlan.satisfactionsurvey.view.Main2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        startActivity(new Intent(this, HomeActivity.class));
        //startActivity(new Intent(this, Home_oldActivity.class ));
    }
}