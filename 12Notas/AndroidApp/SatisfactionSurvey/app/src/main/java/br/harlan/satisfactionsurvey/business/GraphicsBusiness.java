package br.harlan.satisfactionsurvey.business;

import com.github.mikephil.charting.data.PieData;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.database.StatisticsDatabase;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.observer.StatisticsObserver;

public class GraphicsBusiness extends BaseBusiness {

    StatisticsModel statisticsModel;
    StatisticsBusiness statisticsBusiness;
    StatisticsModel.StatisticsChange statisticsChange;


    public GraphicsBusiness(IMessageServices messageServices, INavigationServices navigationServices) {
        super(messageServices, navigationServices);
        statisticsModel = new StatisticsModel();
        statisticsBusiness = new StatisticsBusiness(messageServices, navigationServices);

    }

    public PieData getPieDataSatisfaction(StatisticsModel.StatisticsChange statisticsChange) {
        this.statisticsChange = statisticsChange;
        StatisticsDatabase statisticsDatabase = new StatisticsDatabase(databaseServices).getStatistics(new StatisticsModel.StatisticsChange() {
            @Override
            public void statisticsReady(StatisticsModel statisticsModel) {

            }

            @Override
            public void pieDataReady(PieData pieData) {
                //statisticsChange.pieDataReady(pieData);
            }
        });
        return  null;
    }
}