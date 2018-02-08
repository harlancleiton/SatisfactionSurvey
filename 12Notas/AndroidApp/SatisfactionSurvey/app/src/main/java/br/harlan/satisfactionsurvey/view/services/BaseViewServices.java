package br.harlan.satisfactionsurvey.view.services;

import android.app.Activity;

public class BaseViewServices {

    protected Activity activity;

    public BaseViewServices(Activity activity){
        this.activity = activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
