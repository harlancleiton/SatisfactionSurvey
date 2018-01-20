package br.harlan.satisfactionsurvey.view;


import android.graphics.Color;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.model.GraphicModel;

public class GraphicsFragment extends BaseFragment {

    //region Variables
    PieChart pieChart;
    //endregion Variables

    public GraphicsFragment() {
        super(R.layout.fragment_graphics);
    }

    //region Methods
    @Override
    protected void initializeComponents(View rootView) {
        pieChart = rootView.findViewById(R.id.pie_chart);
        createGraphic();
    }

    @Override
    protected void addEvents() {

    }

    private void createGraphic() {
        ArrayList<Float> yValues = new ArrayList<>();
        yValues.add(20f);
        yValues.add(40f);
        yValues.add(25f);
        yValues.add(29f);
        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("Harlan");
        xValues.add("Luis");
        xValues.add("Tiago");
        xValues.add("Carlos");
        GraphicModel graphicModel = new GraphicModel(yValues, xValues);
        PieData pieData = graphicModel.getPieData();
        pieChart.setData(pieData);
        pieChart.animateX(1000, Easing.EasingOption.EaseInCirc);
        //pieChart.setUsePercentValues(true);
        pieChart.setDrawCenterText(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setEntryLabelColor(getResources().getColor(R.color.colorPrimaryDark));
        pieChart.setTransparentCircleRadius(60f);
        pieChart.animateX(1000, Easing.EasingOption.EaseInCirc);
        /*pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setEntryLabelColor(getResources().getColor(R.color.colorPrimaryDark));
        pieChart.setTransparentCircleRadius(60f);
        pieChart.animateX(1000, Easing.EasingOption.EaseInCirc);
        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(31f, "Harlan"));
        yValues.add(new PieEntry(17f, "Tiago"));
        yValues.add(new PieEntry(24f, "Carlos"));
        yValues.add(new PieEntry(16f, "Luis"));
        PieDataSet pieDataSet = new PieDataSet(yValues, "Tecnicos");
        pieDataSet.setSliceSpace(3f);
        pieDataSet.setSelectionShift(5f);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        PieData pieData = new PieData(pieDataSet);
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(getResources().getColor(R.color.colorAccent));
        pieChart.setData(pieData);*/

    }
    //region Methods
}