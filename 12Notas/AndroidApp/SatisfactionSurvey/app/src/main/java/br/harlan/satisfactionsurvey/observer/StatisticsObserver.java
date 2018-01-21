package br.harlan.satisfactionsurvey.observer;

import java.util.Observable;
import java.util.Observer;

import br.harlan.satisfactionsurvey.model.StatisticsModel;


public class StatisticsObserver implements Observer {

    StatisticsDataChange statisticsDataChange;

    public StatisticsObserver(StatisticsDataChange statisticsDataChange){
        this.statisticsDataChange = statisticsDataChange;
    }

    @Override
    public void update(Observable observable, Object o) {
        StatisticsModel statisticsModel = (StatisticsModel)observable;
        statisticsDataChange.onDataChange(statisticsModel);
    }
    public interface StatisticsDataChange {
        void onDataChange(StatisticsModel statisticsModel);
    }
}