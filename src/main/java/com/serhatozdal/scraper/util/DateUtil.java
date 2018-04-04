package com.serhatozdal.scraper.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author serhatozdal
 */
public class DateUtil {

    public static Date getDate(String date) {
        try {
            return new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String format(Date date) {
        return format(date, "dd/MM/yyyy");
    }

    public static String format(Date date, String dateFormat) {
        return new SimpleDateFormat(dateFormat).format(date);
    }
}
