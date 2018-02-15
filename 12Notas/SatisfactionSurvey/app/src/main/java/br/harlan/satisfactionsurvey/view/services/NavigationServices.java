package br.harlan.satisfactionsurvey.view.services;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;

import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.view.BaseFragment;
import br.harlan.satisfactionsurvey.view.SearchFragment;

public class NavigationServices extends BaseViewServices implements INavigationServices {

    FragmentManager fragmentManager;
    @LayoutRes int layout;

    public NavigationServices(Activity activity) {
        super(activity);
    }

    public NavigationServices(Activity activity, FragmentManager fragmentManager) {
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

    @SuppressLint("ResourceType")
    @Override
    public void loadFragment(BaseFragment baseFragment) {
        fragmentManager.beginTransaction().replace(layout, baseFragment).commit();
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }
}