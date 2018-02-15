package br.harlan.satisfactionsurvey.business.services;

import android.support.annotation.StringRes;

public interface IMessageServices {
    void newToast(@StringRes int message);
    void newToast(String message);
}
