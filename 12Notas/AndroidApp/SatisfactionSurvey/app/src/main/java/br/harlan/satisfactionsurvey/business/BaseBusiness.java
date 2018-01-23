package br.harlan.satisfactionsurvey.business;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.business.services.DatabaseServices;
import br.harlan.satisfactionsurvey.singleton.DatabaseServicesSingleton;

public class BaseBusiness {

    protected IMessageServices messageServices;
    protected INavigationServices navigationServices;
    protected DatabaseServices databaseServices;

    //region Data Chart Type
    public final static int PIE_DATA = 0;
    public final static int BAR_DATA = 1;
    public final static int BAR_CHART = 2;
    public final static int PIE_CHART = 3;
    public final static int SATISFACTION_TYPE = 4;
    public final static int COMMENT_TYPE = 5;
    public final static int NOTE_KNOWLEDGE = 6;
    public final static int NOTE_CORDIALITY = 7;
    public final static int NOTE_COMMUNICATION = 7;
    public final static int NOTE_COMMITMENT = 8;
    public final static int NOTE_TYPE = 9;
    //endregion Data Chart Type

    public BaseBusiness(IMessageServices messageServices, INavigationServices navigationServices) {
        this.messageServices = messageServices;
        this.navigationServices = navigationServices;
        this.databaseServices = DatabaseServicesSingleton.getInstance(messageServices, navigationServices);
    }
}