package br.harlan.satisfactionsurvey.factory;

import java.util.ArrayList;
import java.util.List;

import br.harlan.satisfactionsurvey.business.ChartBusiness;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.singleton.StatisticsSingleton;

public class ValuesFactory {

    private final int dataType;
    StatisticsModel statisticsModel = StatisticsSingleton.getInstance();

    public ValuesFactory(int dataType) {
        this.dataType = dataType;
    }

    public List<Integer> getYValues(){
        List<Integer> yValues = new ArrayList<>();
        if (dataType == ChartBusiness.SATISFACTION_TYPE) {
            yValues.add(statisticsModel.getSatisfied());
            yValues.add(statisticsModel.getIndifferent());
            yValues.add(statisticsModel.getDissatisfied());
        } else if (dataType == ChartBusiness.COMMENT_TYPE){
            yValues.add(statisticsModel.getCompliment());
            yValues.add(statisticsModel.getDoubt());
            yValues.add(statisticsModel.getCriticims());
            yValues.add(statisticsModel.getSuggestion());
        }
        return yValues;
    }

    public List<String> getXValues(){
        List<String> xValues = new ArrayList<>();
        if (dataType == ChartBusiness.SATISFACTION_TYPE) {
            xValues.add("Satisfeitos");
            xValues.add("Indiferentes");
            xValues.add("Insatisfeitos");
        } else if(dataType == ChartBusiness.COMMENT_TYPE){
            xValues.add("Elogio");
            xValues.add("Dúvida");
            xValues.add("Crítica");
            xValues.add("Sugestão");
        }
        return xValues;
    }
}