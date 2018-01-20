package br.harlan.satisfactionsurvey.view.services;

import android.app.Activity;
import android.content.Intent;

import br.harlan.satisfactionsurvey.business.services.INavigationServices;

public class NavigationServices extends BaseServices implements INavigationServices {
    public NavigationServices(Activity activity) {
        super(activity);
    }

    @Override
    public void navigateTo(Class<?> cls) {
        activity.startActivity(new Intent(activity, cls));
    }

    @Override
    public void navigateToAndFinish(Class<?> cls) {
        navigateTo(cls);
        activity.finish();
    }
}