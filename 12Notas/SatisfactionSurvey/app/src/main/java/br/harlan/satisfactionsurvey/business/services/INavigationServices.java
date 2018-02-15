package br.harlan.satisfactionsurvey.business.services;

import br.harlan.satisfactionsurvey.view.BaseFragment;

public interface INavigationServices {
    void navigateTo(Class<?> cls);
    void navigateToAndFinish(Class<?> cls);
    void loadFragment(BaseFragment baseFragment);
}
