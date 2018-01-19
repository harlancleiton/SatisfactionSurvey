package br.harlan.satisfactionsurvey.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class CurrentDateTime {

    private CurrentDateTime(){}

    private static String currentDate;
    private static SimpleDateFormat simpleDateFormat;
    private static Date date;

    public static String getCurrentDate() {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = Calendar.getInstance().getTime();
        currentDate = simpleDateFormat.format(date);
        return currentDate;
    }

    public static String getCurrentTime() {
        simpleDateFormat = new SimpleDateFormat("HH:mm");
        date = Calendar.getInstance().getTime();
        currentDate = simpleDateFormat.format(date);
        return currentDate;
    }
}
