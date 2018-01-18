package br.harlan.satisfactionsurvey.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.singleton.MessageServicesSingleton;
import br.harlan.satisfactionsurvey.singleton.NavigationServicesSingleton;
import br.harlan.satisfactionsurvey.view.services.MessageServices;
import br.harlan.satisfactionsurvey.view.services.NavigationServices;

public abstract class BaseActivity extends AppCompatActivity {

    private int layout;
    protected Toolbar toolbar;
    protected MessageServices messageServices;
    protected NavigationServices navigationServices;

    public BaseActivity(@LayoutRes int layout){
        this.layout = layout;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        messageServices = MessageServicesSingleton.getInstance(this);
        navigationServices = NavigationServicesSingleton.getInstance(this);
        initializeComponents();
        addEvents();
    }

    protected abstract void initializeComponents();

    protected abstract void addEvents();
}
