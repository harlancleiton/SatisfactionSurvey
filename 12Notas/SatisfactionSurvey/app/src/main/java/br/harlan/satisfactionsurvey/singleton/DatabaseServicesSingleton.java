package br.harlan.satisfactionsurvey.singleton;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.business.services.DatabaseServices;

/**
 * Created by Harlan on 15/01/2018.
 */

public class DatabaseServicesSingleton {
    private static DatabaseServices databaseServices;
    private DatabaseServicesSingleton(){}
    public static DatabaseServices getInstance(IMessageServices messageServices, INavigationServices navigationServices) {
        if(databaseServices == null)
            databaseServices = new DatabaseServices(messageServices, navigationServices);
        return databaseServices;
    }
}
