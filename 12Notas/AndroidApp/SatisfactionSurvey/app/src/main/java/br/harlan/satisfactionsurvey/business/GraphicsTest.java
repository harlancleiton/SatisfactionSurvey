package br.harlan.satisfactionsurvey.business;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.database.StatisticsDatabase;
import br.harlan.satisfactionsurvey.model.BaseModel;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.singleton.StatisticsSingleton;

public class GraphicsTest<T extends ChartData, C extends Chart> extends BaseBusiness {

    //region Variables
    T data;
    int chartDataType;
    int dataType;
    List<Integer> yValues = new ArrayList<>();
    List<String> xValues = new ArrayList<>();
    DataSet dataSet;
    String chartLabel;
    StatisticsModel mStatisticsModel = StatisticsSingleton.getInstance();
    OnDataChangeListener onDataChangeListener;
    //endregion Variables

    public GraphicsTest(IMessageServices messageServices, INavigationServices navigationServices, int chartDataType, int dataType) {
        super(messageServices, navigationServices);
        this.chartDataType = chartDataType;
        this.dataType = dataType;
    }

    public void loadChartData(OnDataChangeListener onDataChangeListener) {
        this.onDataChangeListener = onDataChangeListener;
        if (checkStatistics())
            //loadData();
            createChartDataType();
        else {
            StatisticsDatabase statisticsDatabase = new StatisticsDatabase(databaseServices);
            statisticsDatabase.setStatisticsListener(new StatisticsDatabase.OnStatisticsChangeListener() {
                @Override
                public void onStatisticsChange(StatisticsModel statisticsModel) {
                    mStatisticsModel = statisticsModel;
                    createChartDataType();
                }
            });
            statisticsDatabase.retrieveAll(StatisticsModel.CLASS_NAME_STATISTICS);
        }
    }

    private void createChartDataType() {
        loadYValues();
        loadXValues();
        List entries = new ArrayList<>();
        if (isBarDataChart(data)){

        }
        else {
            entries = new ArrayList<PieEntry>();
            for (int i = 0; i < xValues.size(); i++)
                entries.add(new PieEntry(yValues.get(i), xValues.get(i)));
            dataSet = new PieDataSet(entries, chartLabel);
            dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
            data = (T) new PieData((IPieDataSet) dataSet);
        }
        onDataChangeListener.onDataChange(data);
    }

    private void loadXValues() {
        if (dataType == GraphicsTest.SATISFACTION_TYPE) {
            chartLabel = "Satisfação";
            xValues.add("Satisfeitos");
            xValues.add("Indiferentes");
            xValues.add("Insatisfeitos");
        } else if(dataType == GraphicsTest.COMMENT_TYPE){
            chartLabel = "Tipos de comentários";
            xValues.add("Elogio");
            xValues.add("Dúvida");
            xValues.add("Crítica");
            xValues.add("Sugestão");
        }
    }

    private void loadYValues() {
        if (dataType == GraphicsTest.SATISFACTION_TYPE) {
            yValues.add(mStatisticsModel.getSatisfied());
            yValues.add(mStatisticsModel.getIndifferent());
            yValues.add(mStatisticsModel.getDissatisfied());
        } else if (dataType == GraphicsTest.COMMENT_TYPE){
            yValues.add(mStatisticsModel.getCompliment());
            yValues.add(mStatisticsModel.getDoubt());
            yValues.add(mStatisticsModel.getCriticims());
            yValues.add(mStatisticsModel.getSuggestion());
        }
    }

    private void loadData() {
        if (isBarDataChart(data))
            loadBarData();
        else loadPieData();
    }

    private boolean checkStatistics() {
        return mStatisticsModel.getTotal() != StatisticsModel.NO_READY;
    }

    private void loadBarData() {

    }

    private void loadPieData() {

    }

    private boolean isBarDataChart(T data) {
        return chartDataType == BAR_DATA;
    }

    private boolean isPieDataChart(T data) {
        return chartDataType == PIE_DATA;
    }

    public interface OnDataChangeListener<T extends ChartData> {
        void onDataChange(T chartData);
    }
}