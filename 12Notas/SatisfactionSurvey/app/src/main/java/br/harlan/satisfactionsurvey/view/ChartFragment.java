package br.harlan.satisfactionsurvey.view;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.business.ChartBusiness;

public class ChartFragment extends BaseFragment {

    //region Variables
    private PieChart pieChartSatisfaction;
    private PieChart pieChartType;
    private BarChart barChart4Cs;
    private AppCompatImageView ivInitialDate;
    private AppCompatImageView ivFinalDate;
    private AppCompatTextView tvInitialDate;
    private AppCompatTextView tvFinalDate;
    ChartBusiness<PieData, PieChart> graphicsSatisfaction;
    ChartBusiness<PieData, PieChart> graphicsType;
    ChartBusiness<BarData, BarChart> graphics4Cs;
    int year;
    int month;
    int day;
    Date initialDate;
    Date finalDate;

    private final static int TOTAL_GRAPHICS = 3;
    //endregion Variables

    public ChartFragment() {
        super(R.layout.fragment_chart);
    }

    //region Methods
    @Override
    protected void initializeComponents(View rootView) {
        pieChartSatisfaction = rootView.findViewById(R.id.pie_chart_satisfaction);
        pieChartType = rootView.findViewById(R.id.pie_chart_type);
        barChart4Cs = rootView.findViewById(R.id.barchart_4c);
        ivInitialDate = rootView.findViewById(R.id.iv_initial_date);
        ivFinalDate = rootView.findViewById(R.id.iv_final_date);
        tvInitialDate = rootView.findViewById(R.id.tv_initial_date);
        tvFinalDate = rootView.findViewById(R.id.tv_final_date);
        //createGraphic();
    }

    @Override
    protected void addEvents() {
        //region Pick Date
        ivInitialDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = 2018;
                month = 0;
                day = 1;
                final DatePickerDialog datePickerDialogInitial = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        int aux = 1 + i1;
                        tvInitialDate.setText(i2 + "/" + aux + "/" + i);
                        initialDate = getDate(i, i1, i2);
                        updateCharts();
                    }
                }, year, month, day);
                datePickerDialogInitial.show();
            }
        });
        ivFinalDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = 2018;
                month = 0;
                day = 29;
                DatePickerDialog datePickerDialogFinal = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        int aux = 1 + i1;
                        tvFinalDate.setText(i2 + "/" + aux + "/" + i);
                        finalDate = getDate(i, i1, i2);
                        updateCharts();
                    }
                }, year, month, day);
                datePickerDialogFinal.show();
            }
        });
        //endregion Pick Date
        //region Chart Satisfaction
        graphicsSatisfaction = new ChartBusiness(messageServices, navigationServices, ChartBusiness.PIE_DATA, ChartBusiness.SATISFACTION_TYPE);
        graphicsSatisfaction.loadChartData(new ChartBusiness.OnDataChangeListener<PieData>() {
            @Override
            public void onDataChange(PieData chartData) {
                Legend legend = pieChartSatisfaction.getLegend();
                legend.setFormSize(10f);
                legend.setForm(Legend.LegendForm.CIRCLE);
                //legend.setPosition(Legend.LegendPosition.PIECHART_CENTER);
                legend.setTextSize(12f);
                legend.setTextColor(Color.BLACK);
                legend.setYEntrySpace(5f);
                legend.setXEntrySpace(5f);
                chartData.setValueFormatter(new ValueFormatter());
                pieChartSatisfaction.setData(chartData);
                pieChartSatisfaction.setDrawEntryLabels(false);
                pieChartSatisfaction.getData().setValueTextSize(16f);
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
        //endregion Chart Satisfaction
        //region Chart Type
        graphicsType = new ChartBusiness(messageServices, navigationServices, ChartBusiness.PIE_DATA, ChartBusiness.COMMENT_TYPE);
        graphicsType.loadChartData(new ChartBusiness.OnDataChangeListener<PieData>() {
            @Override
            public void onDataChange(PieData chartData) {
                int total = graphicsType.getTotal();
                AppCompatTextView tvTotal = viewRoot.findViewById(R.id.tv_total_chart);
                tvTotal.setText(String.valueOf(total));
                Legend legendType = pieChartType.getLegend();
                legendType.setFormSize(10f);
                legendType.setForm(Legend.LegendForm.CIRCLE);
                //legendType.setPosition(Legend.LegendPosition.PIECHART_CENTER);
                legendType.setTextSize(12f);
                legendType.setTextColor(Color.BLACK);
                legendType.setYEntrySpace(5f);
                legendType.setXEntrySpace(5f);
                chartData.setValueFormatter(new ValueFormatter());
                pieChartType.setData(chartData);
                pieChartType.setDrawEntryLabels(false);
                pieChartType.getDescription().setEnabled(false);
                pieChartType.setExtraOffsets(5, 10, 5, 5);
                pieChartType.setDragDecelerationFrictionCoef(0.95f);
                pieChartType.setDrawHoleEnabled(true);
                pieChartType.setHoleColor(Color.WHITE);
                pieChartType.setEntryLabelColor(getResources().getColor(R.color.colorPrimaryDark));
                pieChartType.setTransparentCircleRadius(60f);
                pieChartType.animateX(1000, Easing.EasingOption.EaseInCirc);
                pieChartType.getData().setValueTextSize(16f);
            }
        });
        //endregion Chart Type
        //region Chart 4Cs
        graphics4Cs = new ChartBusiness(messageServices, navigationServices, ChartBusiness.BAR_DATA, ChartBusiness.NOTE_TYPE);
        graphics4Cs.loadChartData(new ChartBusiness.OnDataChangeListener<BarData>() {
            @Override
            public void onDataChange(BarData chartData) {
                //chartData.setValueFormatter(new ValueFormatter());
                barChart4Cs.setData(chartData);
                barChart4Cs.getData().setValueTextSize(16f);
                barChart4Cs.getAxisRight().setEnabled(false);
                barChart4Cs.getXAxis().setEnabled(false);
                barChart4Cs.getAxisLeft().setAxisMinimum(0);
                barChart4Cs.getAxisLeft().setAxisMaximum(5);
                //yAxis.setEnabled(false);
                barChart4Cs.notifyDataSetChanged();
                barChart4Cs.invalidate();
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
        //endregion Chart 4Cs
    }

    private void updateCharts() {
        graphicsSatisfaction.onData(initialDate, finalDate);
        graphicsType.onData(initialDate, finalDate);
        graphics4Cs.onData(initialDate, finalDate);
    }

    private Date getDate(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date, 00, 00, 00);
        //calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date _date = calendar.getTime();
        Log.i("Get Date", _date.toString());
        return _date;
    }
    //region Methods

    private class AxisValueFormatter implements IAxisValueFormatter {

        private String[] mValues;

        public AxisValueFormatter(String[] values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return "";
        }
    }

    private class ValueFormatter implements IValueFormatter {

        private DecimalFormat decimalFormat;

        public ValueFormatter() {
            decimalFormat = new DecimalFormat("0");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return decimalFormat.format(value);
        }
    }
}