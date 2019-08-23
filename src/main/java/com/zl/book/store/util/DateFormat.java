package com.zl.book.store.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    private static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置时间格式
    private static SimpleDateFormat date=new SimpleDateFormat("yyyyMMdd");//设置时间格式
    public static String getDateFormat(){
        return dateFormat.format(new Date());
    }
    public static String getDate(){
        return date.format(new Date());
    }
}
