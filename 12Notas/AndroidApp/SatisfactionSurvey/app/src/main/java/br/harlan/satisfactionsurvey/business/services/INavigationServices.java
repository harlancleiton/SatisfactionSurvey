package br.harlan.satisfactionsurvey.business.services;

public interface INavigationServices {
    void navigateTo(Class<?> cls);
    void navigateToAndFinish(Class<?> cls);
}
