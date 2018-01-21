package br.harlan.satisfactionsurvey.business;

import com.github.mikephil.charting.data.PieData;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.observer.StatisticsObserver;

public class GraphicsBusiness extends BaseBusiness {

    StatisticsModel statisticsModel;
    StatisticsObserver statisticsObserver;
    StatisticsBusiness statisticsBusiness;

    public GraphicsBusiness(IMessageServices messageServices, INavigationServices navigationServices) {
        super(messageServices, navigationServices);
        statisticsModel = new StatisticsModel();
        statisticsBusiness = new StatisticsBusiness(messageServices, navigationServices);

    }

    public PieData getPieDataSatisfaction() {
        return  null;
    }
}
