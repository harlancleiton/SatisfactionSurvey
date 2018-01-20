package br.harlan.satisfactionsurvey.singleton;

import android.app.Activity;

import br.harlan.satisfactionsurvey.view.services.MessageServices;

public class MessageServicesSingleton {
    private static MessageServices messageServices;
    private MessageServicesSingleton(){}

    public static MessageServices getInstance(Activity activity) {
        if(messageServices == null)
            messageServices = new MessageServices(activity);
        else
            messageServices.setActivity(activity);
        return messageServices;
    }
}
