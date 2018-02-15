package br.harlan.satisfactionsurvey.factory;

import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;

import java.util.List;

import br.harlan.satisfactionsurvey.model.StatisticsModel;

public class ChartDataFactory <T extends ChartData> {

    T chart;
    ChartData chartData;
    List<Entry> entries;
    DataSet dataSet;
    String chartLabel;
    StatisticsModel statisticsModel;
    List<Integer> yValues;
    List<String> xValues;
}