package com.luqiancheng.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

//日期工具类型的封装
public class DateUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //1.字符串转换为util.Date
    public static java.util.Date strToUtil(String str){
        try {
            java.util.Date date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //2.util.Date转换为sql.Date
    public static java.sql.Date utilToSql(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }
    //3.util.Date 转换为字符串形式
    public static String utilToStr(java.util.Date date){
        return sdf.format(date);
    }
}
