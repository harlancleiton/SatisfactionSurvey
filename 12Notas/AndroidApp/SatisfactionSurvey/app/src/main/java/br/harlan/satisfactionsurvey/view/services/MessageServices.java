package br.harlan.satisfactionsurvey.view.services;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.widget.Toast;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;

public class MessageServices extends BaseServices implements IMessageServices {
    public MessageServices(Activity activity) {
        super(activity);
    }

    @Override
    public void newToast(@StringRes int message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void newToast(String message) {

    }
}