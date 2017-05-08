package com.dky.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/15.
 */
public class DateUtils {

    public static String FORMAT_YYYYMMDD = "YYYY-MM-dd";
    public static String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String formatNowDate(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date now = new Date();
        return sdf.format(now);
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDD));
    }
}
