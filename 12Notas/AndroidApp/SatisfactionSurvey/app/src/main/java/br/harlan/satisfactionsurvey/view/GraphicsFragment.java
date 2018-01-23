package br.harlan.satisfactionsurvey.view;


import android.graphics.Color;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.business.GraphicsBusiness;
import br.harlan.satisfactionsurvey.business.GraphicsTest;
import br.harlan.satisfactionsurvey.business.StatisticsBusiness;
import br.harlan.satisfactionsurvey.model.GraphicModel;
import br.harlan.satisfactionsurvey.model.StatisticsModel;

public class GraphicsFragment extends BaseFragment {

    //region Variables
    private PieChart pieChartSatisfaction;
    private PieChart pieChart2;

    private final static int TOTAL_GRAPHICS = 1;
    //endregion Variables

    public GraphicsFragment() {
        super(R.layout.fragment_graphics);
    }

    //region Methods
    @Override
    protected void initializeComponents(View rootView) {
        pieChartSatisfaction = rootView.findViewById(R.id.pie_chart);
        pieChart2 = rootView.findViewById(R.id.pie_chart2);
        //createGraphic();
    }

    @Override
    protected void addEvents() {
        //final PieData[] mPieData = new PieData[1];
        //new GraphicsBusiness(messageServices, navigationServices).getPieDataSatisfaction(new GraphicsTest.OnDataChangeListener<PieData>() {
        GraphicsTest<PieData, PieChart> graphicsTest = new GraphicsTest(messageServices, navigationServices, GraphicsTest.PIE_DATA, GraphicsTest.SATISFACTION_TYPE);
        graphicsTest.loadChartData(new GraphicsTest.OnDataChangeListener<PieData>() {
            @Override
            public void onDataChange(PieData chartData) {
                pieChartSatisfaction.setData(chartData);
                pieChartSatisfaction.setDrawCenterText(true);
                pieChartSatisfaction.getDescription().setEnabled(false);
                pieChartSatisfaction.setExtraOffsets(5, 10, 5, 5);
                pieChartSatisfaction.setDragDecelerationFrictionCoef(0.95f);
                pieChartSatisfaction.setDrawHoleEnabled(true);
                pieChartSatisfaction.setHoleColor(Color.WHITE);
                pieChartSatisfaction.setEntryLabelColor(getResources().getColor(R.color.colorPrimaryDark));
                pieChartSatisfaction.setTransparentCircleRadius(60f);
                pieChartSatisfaction.animateX(1000, Easing.EasingOption.EaseInCirc);
            }
        });
        GraphicsTest<PieData, PieChart> graphicsTest1 = new GraphicsTest(messageServices, navigationServices, GraphicsTest.PIE_DATA, GraphicsTest.COMMENT_TYPE);
        graphicsTest1.loadChartData(new GraphicsTest.OnDataChangeListener<PieData>() {
            @Override
            public void onDataChange(PieData chartData) {
                pieChart2.setData(chartData);
                pieChart2.setDrawCenterText(true);
                pieChart2.getDescription().setEnabled(false);
                pieChart2.setExtraOffsets(5, 10, 5, 5);
                pieChart2.setDragDecelerationFrictionCoef(0.95f);
                pieChart2.setDrawHoleEnabled(true);
                pieChart2.setHoleColor(Color.WHITE);
                pieChart2.setEntryLabelColor(getResources().getColor(R.color.colorPrimaryDark));
                pieChart2.setTransparentCircleRadius(60f);
                pieChart2.animateX(1000, Easing.EasingOption.EaseInCirc);
            }
        });
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
        pieChartSatisfaction.setData(pieData);
        pieChartSatisfaction.animateX(1000, Easing.EasingOption.EaseInCirc);
        //pieChartSatisfaction.setUsePercentValues(true);
        pieChartSatisfaction.setDrawCenterText(true);
        pieChartSatisfaction.getDescription().setEnabled(false);
        pieChartSatisfaction.setExtraOffsets(5, 10, 5, 5);
        pieChartSatisfaction.setDragDecelerationFrictionCoef(0.95f);
        pieChartSatisfaction.setDrawHoleEnabled(true);
        pieChartSatisfaction.setHoleColor(Color.WHITE);
        pieChartSatisfaction.setEntryLabelColor(getResources().getColor(R.color.colorPrimaryDark));
        pieChartSatisfaction.setTransparentCircleRadius(60f);
        pieChartSatisfaction.animateX(1000, Easing.EasingOption.EaseInCirc);
        /*pieChartSatisfaction.setUsePercentValues(true);
        pieChartSatisfaction.getDescription().setEnabled(false);
        pieChartSatisfaction.setExtraOffsets(5, 10, 5, 5);
        pieChartSatisfaction.setDragDecelerationFrictionCoef(0.95f);
        pieChartSatisfaction.setDrawHoleEnabled(true);
        pieChartSatisfaction.setHoleColor(Color.WHITE);
        pieChartSatisfaction.setEntryLabelColor(getResources().getColor(R.color.colorPrimaryDark));
        pieChartSatisfaction.setTransparentCircleRadius(60f);
        pieChartSatisfaction.animateX(1000, Easing.EasingOption.EaseInCirc);
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
        pieChartSatisfaction.setData(pieData);*/

    }
    //region Methods
}