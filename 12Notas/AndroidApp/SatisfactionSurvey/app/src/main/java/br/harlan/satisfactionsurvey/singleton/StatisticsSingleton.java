package br.harlan.satisfactionsurvey.singleton;

import br.harlan.satisfactionsurvey.model.StatisticsModel;

public class StatisticsSingleton {

    private static StatisticsModel statisticsModel;

    private StatisticsSingleton(){}

    public static StatisticsModel getInstance(){
        if(statisticsModel == null) {
            statisticsModel = new StatisticsModel();
        }
        return statisticsModel;
    }
}