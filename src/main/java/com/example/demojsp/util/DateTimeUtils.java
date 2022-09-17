package com.example.demojsp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

    public static Date parseDateFromString(String strDateTime){
        try {
            return simpleDateFormat.parse(strDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Calendar.getInstance().getTime();
    }

    public static String formatDateToString(Date date){
        return simpleDateFormat.format(date);
    }

    public static Date parteTimeFromString(String timeStr) throws ParseException {
        return time.parse(timeStr);
    }
}
