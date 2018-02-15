package br.harlan.satisfactionsurvey.factory;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.List;

/**
 * Created by harlancleiton on 24/01/18.
 */

public class DataSetFactory <T extends DataSet> {

    T dataSet;

    public T getDataSet(List<Entry> entries, String chartLabel){
        //dataSet = new PieDataSet(entries, chartLabel);
        return dataSet;
    }
}