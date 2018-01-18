package br.harlan.satisfactionsurvey.business;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.business.services.DatabaseServices;
import br.harlan.satisfactionsurvey.singleton.DatabaseServicesSingleton;

public class BaseBusiness {
    protected IMessageServices messageServices;
    protected INavigationServices navigationServices;
    protected DatabaseServices databaseServices;

    public BaseBusiness(IMessageServices messageServices, INavigationServices navigationServices) {
        this.messageServices = messageServices;
        this.navigationServices = navigationServices;
        this.databaseServices = DatabaseServicesSingleton.getInstance(messageServices, navigationServices);
    }
}