package br.harlan.satisfactionsurvey.view;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.Date;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.business.ChartBusiness;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.singleton.StatisticsSingleton;

public class ChartFragment extends BaseFragment {

    //region Variables
    private PieChart pieChartSatisfaction;
    private PieChart pieChartType;
    private BarChart barChart4Cs;
    private CardView cvInitialDate;
    private CardView cvFinalDate;
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
        cvInitialDate = rootView.findViewById(R.id.cv_initial_date);
        cvFinalDate = rootView.findViewById(R.id.cv_final_date);
        tvInitialDate = rootView.findViewById(R.id.tv_initial_date);
        tvFinalDate = rootView.findViewById(R.id.tv_final_date);
        //createGraphic();
    }

    @Override
    protected void addEvents() {
        cvInitialDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = 2018;
                month = 0;
                day = 1;
                final DatePickerDialog datePickerDialogInitial = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tvInitialDate.setText(i2 + "/" + 1 + i1 + "/" + i);
                        initialDate = getDate(i2, 1 + i1, i);
                        updateCharts();
                    }
                }, year, month, day);
                datePickerDialogInitial.show();
            }
        });
        cvFinalDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = 2018;
                month = 0;
                day = 29;
                DatePickerDialog datePickerDialogFinal = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Log.i("i", String.valueOf(i));
                        Log.i("i1", String.valueOf(i1));
                        Log.i("i2", String.valueOf(i2));
                        tvFinalDate.setText(i2 + "/" + 1 + i1 + "/" + i);
                        finalDate = getDate(i2, 1 + i1, i);
                        updateCharts();
                    }
                }, year, month, day);
                datePickerDialogFinal.show();
            }
        });
        graphicsSatisfaction = new ChartBusiness(messageServices, navigationServices, ChartBusiness.PIE_DATA, ChartBusiness.SATISFACTION_TYPE);
        graphicsSatisfaction.loadChartData(new ChartBusiness.OnDataChangeListener<PieData>() {
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
        graphicsType = new ChartBusiness(messageServices, navigationServices, ChartBusiness.PIE_DATA, ChartBusiness.COMMENT_TYPE);
        graphicsType.loadChartData(new ChartBusiness.OnDataChangeListener<PieData>() {
            @Override
            public void onDataChange(PieData chartData) {
                pieChartType.setData(chartData);
                pieChartType.setDrawCenterText(true);
                pieChartType.getDescription().setEnabled(false);
                pieChartType.setExtraOffsets(5, 10, 5, 5);
                pieChartType.setDragDecelerationFrictionCoef(0.95f);
                pieChartType.setDrawHoleEnabled(true);
                pieChartType.setHoleColor(Color.WHITE);
                pieChartType.setEntryLabelColor(getResources().getColor(R.color.colorPrimaryDark));
                pieChartType.setTransparentCircleRadius(60f);
                pieChartType.animateX(1000, Easing.EasingOption.EaseInCirc);
            }
        });
        graphics4Cs = new ChartBusiness(messageServices, navigationServices, ChartBusiness.BAR_DATA, ChartBusiness.NOTE_TYPE);
        graphics4Cs.loadChartData(new ChartBusiness.OnDataChangeListener<BarData>() {
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

    private void updateCharts() {
        //pieChartType.notifyDataSetChanged();
        graphicsSatisfaction.onData(initialDate, finalDate);
    }

    private Date getDate(int year, int month, int date) {
        Date _date = new Date(year, month, date);
        Log.i("Get Year", Integer.toString(_date.getYear()));
        Log.i("Get Date", _date.toString());
        return _date;
    }
    //region Methods

    private class AxisValueFormatter implements IAxisValueFormatter {

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