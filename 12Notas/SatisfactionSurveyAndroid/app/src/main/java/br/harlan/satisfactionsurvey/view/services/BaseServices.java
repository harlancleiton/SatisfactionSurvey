package br.harlan.satisfactionsurvey.view.services;

import android.app.Activity;

public class BaseServices {
    protected Activity activity;

    public BaseServices(Activity activity){
        this.activity = activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
