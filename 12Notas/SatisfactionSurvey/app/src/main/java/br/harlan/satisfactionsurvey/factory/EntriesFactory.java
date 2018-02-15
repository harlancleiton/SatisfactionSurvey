package br.harlan.satisfactionsurvey.factory;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class EntriesFactory<T extends Entry> {

    public List<T> getEntries(List<Integer> yValues, List<String> xValues) {
        List entries;
        entries = new ArrayList<T>();
        for (int i = 0; i < xValues.size(); i++)
            entries.add(new PieEntry(yValues.get(i), xValues.get(i)));
        return entries;
    }
}