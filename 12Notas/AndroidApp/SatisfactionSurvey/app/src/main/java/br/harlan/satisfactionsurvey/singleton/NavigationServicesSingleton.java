package br.harlan.satisfactionsurvey.singleton;

import android.app.Activity;

import br.harlan.satisfactionsurvey.view.services.NavigationServices;

public class NavigationServicesSingleton {
    private static NavigationServices navigationServices;
    private NavigationServicesSingleton(){}

    public static NavigationServices getInstance(Activity activity) {
        if(navigationServices == null)
            navigationServices = new NavigationServices(activity);
        else
            navigationServices.setActivity(activity);
        return navigationServices;
    }
}