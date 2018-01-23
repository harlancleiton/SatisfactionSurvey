package br.harlan.satisfactionsurvey.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import br.harlan.satisfactionsurvey.R;

public class Main2Activity extends AppCompatActivity {

    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        barChart = findViewById(R.id.barchart);

        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 10));
        barEntries.add(new BarEntry(2, 3));
        barEntries.add(new BarEntry(3, 14));
        barEntries.add(new BarEntry(4, 30));
        barEntries.add(new BarEntry(5, 45));
        BarDataSet barDataSet = new BarDataSet(barEntries, "4Cs");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
    }
}