package br.harlan.satisfactionsurvey.business;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.database.StatisticsDatabase;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.singleton.StatisticsSingleton;

public class GraphicsBusiness extends BaseBusiness {

//    StatisticsBusiness statisticsBusiness;
    GraphicsTest.OnDataChangeListener onDataChangeListener;
    StatisticsModel statisticsModel = StatisticsSingleton.getInstance();

    public GraphicsBusiness(IMessageServices messageServices, INavigationServices navigationServices) {
        super(messageServices, navigationServices);
//        statisticsBusiness = new StatisticsBusiness(messageServices, navigationServices);
    }

    public void getPieDataSatisfaction(GraphicsTest.OnDataChangeListener<PieData> onDataChangeListener) {
        this.onDataChangeListener = onDataChangeListener;
        if(statisticsReady()){
            createGraphicsPieDataSatisfaction(statisticsModel);
        } else {
            final StatisticsDatabase statisticsDatabase = new StatisticsDatabase(databaseServices);
            statisticsDatabase.setStatisticsListener(new StatisticsDatabase.OnStatisticsChangeListener() {
                @Override
                public void onStatisticsChange(StatisticsModel statisticsModel) {
                    createGraphicsPieDataSatisfaction(statisticsModel);
                }
            });
            statisticsDatabase.retrieveAll(StatisticsModel.CLASS_NAME_STATISTICS);
        }
    }

    private boolean statisticsReady() {
        return (statisticsModel.getTotal() > 0);
    }

    private void createGraphicsPieDataSatisfaction(StatisticsModel statisticsModel) {
        List<Integer> yValues = new ArrayList<>();
        List<String> xValues = new ArrayList<>();
        yValues.add(statisticsModel.getSatisfied());
        yValues.add(statisticsModel.getIndifferent());
        yValues.add(statisticsModel.getDissatisfied());
        xValues.add("Satisfeitos");
        xValues.add("Indiferentes");
        xValues.add("Insatisfeitos");
        List<PieEntry> pieEntries = new ArrayList<>();
        for (int i = 0; i < xValues.size(); i++){
            pieEntries.add(new PieEntry(yValues.get(i), xValues.get(i)));
        }
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Satisfação");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData(pieDataSet);
        onDataChangeListener.onDataChange(pieData);
    }
}