package br.harlan.satisfactionsurvey.business;

import com.parse.ParseObject;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.model.EvaluationModel;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.model.services.ObjectModelToParseObject;

public class StatisticsBusiness extends BaseBusiness {

    public StatisticsBusiness(IMessageServices messageServices, INavigationServices navigationServices) {
        super(messageServices, navigationServices);
    }

    public ParseObject updateStatistics(EvaluationModel object) {
        StatisticsModel statisticsModel = new StatisticsModel();
        ObjectModelToParseObject.setCurrentEvaluation(object);
        ParseObject parseObject = ObjectModelToParseObject.getParseObject(statisticsModel);
        return parseObject;
    }
}
