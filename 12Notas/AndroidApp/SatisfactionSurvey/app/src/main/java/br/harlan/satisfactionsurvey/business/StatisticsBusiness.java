package br.harlan.satisfactionsurvey.business;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;

public class StatisticsBusiness extends BaseBusiness {

    public StatisticsBusiness(IMessageServices messageServices, INavigationServices navigationServices) {
        super(messageServices, navigationServices);
    }
}
