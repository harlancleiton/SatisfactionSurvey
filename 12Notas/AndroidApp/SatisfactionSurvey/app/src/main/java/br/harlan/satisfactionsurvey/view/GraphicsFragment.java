package br.harlan.satisfactionsurvey.view;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.business.GraphicsBusiness;
import br.harlan.satisfactionsurvey.model.GraphicModel;

public class GraphicsFragment extends BaseFragment {

    //region Variables
    private PieChart pieChartSatisfaction;
    private PieChart pieChart2;
    private BarChart barChart4Cs;
    private CardView cvDateOrigin;
    private CardView cvDateFim;
    private AppCompatTextView tvDateOrigin;
    private AppCompatTextView tvDateOFim;
    int year;
    int month;
    int day;

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
        barChart4Cs = rootView.findViewById(R.id.barchart_4c);
        cvDateOrigin = rootView.findViewById(R.id.cv_date_origin);
        cvDateFim = rootView.findViewById(R.id.cv_date_fim);
        tvDateOrigin = rootView.findViewById(R.id.tv_date_origin);
        tvDateOFim = rootView.findViewById(R.id.tv_date_fim);
        //createGraphic();
    }

    @Override
    protected void addEvents() {
        cvDateOrigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = 2018;
                month = 0;
                day = 1;
                final DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tvDateOrigin.setText(i2 + "/" + 1 + i1 + "/" + i);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        cvDateFim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = 2018;
                month = 0;
                day = 29;
                final int yearChoise;
                int monthChoise;
                int dayChoise;
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Log.i("i", String.valueOf(i));
                        Log.i("i1", String.valueOf(i1));
                        Log.i("i2", String.valueOf(i2));
                        tvDateOFim.setText(i2 + "/" + 1 + i1 + "/" + i);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        //final PieData[] mPieData = new PieData[1];
        //new GraphicsBusiness_old(messageServices, navigationServices).getPieDataSatisfaction(new GraphicsBusiness.OnDataChangeListener<PieData>() {
        GraphicsBusiness<PieData, PieChart> graphicsBusiness = new GraphicsBusiness(messageServices, navigationServices, GraphicsBusiness.PIE_DATA, GraphicsBusiness.SATISFACTION_TYPE);
        graphicsBusiness.loadChartData(new GraphicsBusiness.OnDataChangeListener<PieData>() {
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
        GraphicsBusiness<PieData, PieChart> graphicsBusiness1 = new GraphicsBusiness(messageServices, navigationServices, GraphicsBusiness.PIE_DATA, GraphicsBusiness.COMMENT_TYPE);
        graphicsBusiness1.loadChartData(new GraphicsBusiness.OnDataChangeListener<PieData>() {
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
        GraphicsBusiness<BarData, BarChart> graphicsBusiness2 = new GraphicsBusiness(messageServices, navigationServices, GraphicsBusiness.BAR_DATA, GraphicsBusiness.NOTE_TYPE);
        graphicsBusiness2.loadChartData(new GraphicsBusiness.OnDataChangeListener<BarData>() {
            @Override
            public void onDataChange(BarData chartData) {
                barChart4Cs.setData(chartData);
//                float groupSpace = 0.1f;
//                float barSpace = 0.02f;
//                float barWidth = 0.43f;
//                chartData.setBarWidth(barWidth);
//                barChart4Cs.groupBars(1, groupSpace, barSpace);
//                String[] months = new String[] {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov"};
//                XAxis xAxis = barChart4Cs.getXAxis();
//                xAxis.setValueFormatter(new AxisValueFormatter(months));
//                xAxis.setGranularity(1);
//                xAxis.setAxisMinimum(1);
//                xAxis.setAxisMaximum(barChart4Cs.getYMax());
//                xAxis.setCenterAxisLabels(true);
            }
        });
    }
    //region Methods

    class AxisValueFormatter implements IAxisValueFormatter {

        String[] mValues;

        public AxisValueFormatter(String[] values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int) value];
        }
    }
}