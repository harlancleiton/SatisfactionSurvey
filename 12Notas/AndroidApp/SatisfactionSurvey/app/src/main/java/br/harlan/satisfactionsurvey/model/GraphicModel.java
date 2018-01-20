package br.harlan.satisfactionsurvey.model;

import android.content.res.Resources;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import br.harlan.satisfactionsurvey.R;

public class GraphicModel {

    private List<String> xValues;
    private List<Float> yValues;
    List<PieEntry> pieEntries;

    public GraphicModel(List<Float> yValues, List<String> xValues){
        this.yValues = yValues;
        this.xValues = xValues;
        pieEntries = new ArrayList<>();
    }

    public PieData getPieData(){
        if(xValues.size() != yValues.size())
            return null;
        for (int i = 0; i < xValues.size(); i++){
            pieEntries.add(new PieEntry(yValues.get(i), xValues.get(i)));
        }
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Chamados (%)");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData(pieDataSet);
        return pieData;
    }

}