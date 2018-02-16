package br.harlan.satisfactionsurvey.business;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.database.EvaluationDatabase;
import br.harlan.satisfactionsurvey.database.StatisticsDatabase;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.singleton.StatisticsSingleton;

public class ChartBusiness<T extends ChartData, C extends Chart> extends BaseBusiness {

    //region Variables
    T data;
    int chartDataType;
    int dataType;
    List<Integer> yValues = new ArrayList<>();
    List<String> xValues = new ArrayList<>();
    DataSet dataSet;
    String chartLabel;
    StatisticsModel mStatisticsModel = StatisticsSingleton.getInstance();
    StatisticsDatabase statisticsDatabase;
    EvaluationDatabase evaluationDatabase;
    OnDataChangeListener onDataChangeListener;
    //endregion Variables

    public ChartBusiness(IMessageServices messageServices, INavigationServices navigationServices, int chartDataType, int dataType) {
        super(messageServices, navigationServices);
        evaluationDatabase = new EvaluationDatabase(databaseServices);
        this.chartDataType = chartDataType;
        this.dataType = dataType;
    }

    public void onData(Date initialDate, Date finalDate) {
        if (initialDate != null && finalDate != null)
            statisticsDatabase.retrieveAll(StatisticsModel.CLASS_NAME_STATISTICS, initialDate, finalDate);
    }

    public void loadChartData(OnDataChangeListener onDataChangeListener) {
        this.onDataChangeListener = onDataChangeListener;
        if (checkStatistics())
            createChartDataType();
        else {
            statisticsDatabase = new StatisticsDatabase(databaseServices);
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

    private void calculateAverageNotes(StatisticsModel mStatisticsModel) {
        mStatisticsModel.setCommitment(
                (mStatisticsModel.getCommitment1() * 1
                        + mStatisticsModel.getCommitment2() * 2
                        + mStatisticsModel.getCommitment3() * 3
                        + mStatisticsModel.getCommitment4() * 4
                        + mStatisticsModel.getCommitment5() * 5)
                        /
                        mStatisticsModel.getTotal()
        );
        mStatisticsModel.setKnowledge(
                (mStatisticsModel.getKnowledge1() * 1
                        + mStatisticsModel.getKnowledge2() * 2
                        + mStatisticsModel.getKnowledge3() * 3
                        + mStatisticsModel.getKnowledge4() * 4
                        + mStatisticsModel.getKnowledge5() * 5)
                        /
                        mStatisticsModel.getTotal()
        );
        mStatisticsModel.setCordiality(
                (mStatisticsModel.getCordiality1() * 1
                        + mStatisticsModel.getCordiality2() * 2
                        + mStatisticsModel.getCordiality3() * 3
                        + mStatisticsModel.getCordiality4() * 4
                        + mStatisticsModel.getCordiality5() * 5)
                        /
                        mStatisticsModel.getTotal()
        );
        mStatisticsModel.setCommunication(
                (mStatisticsModel.getCommunication1() * 1
                        + mStatisticsModel.getCommunication2() * 2
                        + mStatisticsModel.getCommunication3() * 3
                        + mStatisticsModel.getCommunication4() * 4
                        + mStatisticsModel.getCommunication5() * 5)
                        /
                        mStatisticsModel.getTotal()
        );
    }

    private void createChartDataType() {
        calculateAverageNotes(mStatisticsModel);
        loadYValues();
        loadXValues();
        List entries;
        if (isBarDataChart(data)) {
            ArrayList<BarEntry> barEntries = new ArrayList<>();
            barEntries.add(new BarEntry(1, mStatisticsModel.getKnowledge()));
            barEntries.add(new BarEntry(2, mStatisticsModel.getCommunication()));
            barEntries.add(new BarEntry(3, mStatisticsModel.getCordiality()));
            barEntries.add(new BarEntry(4, mStatisticsModel.getCommitment()));
            BarDataSet barDataSet = new BarDataSet(barEntries, "4Cs");
            barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
            data = (T) new BarData(barDataSet);
        } else {
            entries = new ArrayList<PieEntry>();
            for (int i = 0; i < xValues.size(); i++)
                entries.add(new PieEntry(yValues.get(i), xValues.get(i)));
            dataSet = new PieDataSet(entries, chartLabel);
            dataSet.setColors(ColorTemplate.PASTEL_COLORS);
            data = (T) new PieData((IPieDataSet) dataSet);
            //((PieData)data).notifyDataChanged();
        }
        onDataChangeListener.onDataChange(data);
    }

    private void loadXValues() {
        xValues.clear();
        if (dataType == ChartBusiness.SATISFACTION_TYPE) {
            chartLabel = "Satisfação";
            xValues.add("Satisfeitos");
            xValues.add("Indiferentes");
            xValues.add("Insatisfeitos");
        } else if (dataType == ChartBusiness.COMMENT_TYPE) {
            chartLabel = "Tipos de comentários";
            xValues.add("Elogio");
            xValues.add("Dúvida");
            xValues.add("Crítica");
            xValues.add("Sugestão");
        } else if (dataType == ChartBusiness.NOTE_TYPE) {
            xValues.add("Conhecimento");
            xValues.add("Comprometimento");
            xValues.add("Comunicação");
            xValues.add("Cordialidade");
        }
    }

    private void loadYValues() {
        yValues.clear();
        if (dataType == ChartBusiness.SATISFACTION_TYPE) {
            yValues.add(mStatisticsModel.getSatisfied());
            yValues.add(mStatisticsModel.getIndifferent());
            yValues.add(mStatisticsModel.getDissatisfied());
        } else if (dataType == ChartBusiness.COMMENT_TYPE) {
            yValues.add(mStatisticsModel.getCompliment());
            yValues.add(mStatisticsModel.getDoubt());
            yValues.add(mStatisticsModel.getCriticims());
            yValues.add(mStatisticsModel.getSuggestion());
        } else if (dataType == ChartBusiness.NOTE_TYPE) {
            yValues.add(mStatisticsModel.getCordiality1());
            yValues.add(mStatisticsModel.getCordiality2());
            yValues.add(mStatisticsModel.getCordiality3());
            yValues.add(mStatisticsModel.getCordiality4());
            yValues.add(mStatisticsModel.getCommitment1());
            yValues.add(mStatisticsModel.getCommitment2());
            yValues.add(mStatisticsModel.getCommitment3());
            yValues.add(mStatisticsModel.getCommitment4());
        }
    }

    private boolean checkStatistics() {
        return mStatisticsModel.getTotal() != StatisticsModel.NO_READY;
    }

    private boolean isBarDataChart(T data) {
        return chartDataType == BAR_DATA;
    }

    private boolean isPieDataChart(T data) {
        return chartDataType == PIE_DATA;
    }

    public int getTotal() {
        return mStatisticsModel.getTotal();
    }

    public interface OnDataChangeListener<T extends ChartData> {
        void onDataChange(T chartData);
    }
}