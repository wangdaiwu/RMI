package com.wdw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String logDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return dateFormat.format(new Date());
    }
}
