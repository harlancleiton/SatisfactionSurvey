package br.harlan.satisfactionsurvey.singleton;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

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

    public static NavigationServices getInstance(Activity activity, FragmentManager fragmentManager) {
        if(navigationServices == null)
            navigationServices = new NavigationServices(activity, fragmentManager);
        else {
            navigationServices.setActivity(activity);
            navigationServices.setFragmentManager(fragmentManager);
        }
        return navigationServices;
    }
}