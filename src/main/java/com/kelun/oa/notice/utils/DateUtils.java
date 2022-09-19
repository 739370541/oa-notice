package com.kelun.oa.notice.utils;

import java.util.Calendar;

/**
 * 日期操作工具类
 * @author yale
 */
public class DateUtils {

    public static String getWeekString(Calendar calendar){
        if(null == calendar){
            calendar= Calendar.getInstance();
        }
        int weekOfDay = calendar.get(Calendar.DAY_OF_WEEK);
        switch (weekOfDay){
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
            default:
                return null;
        }
    }

    public static int getMonth(){
        Calendar calendar=Calendar.getInstance();
        return calendar.get(Calendar.MONTH)+1;
    }

    public static int getDay(){
        Calendar calendar=Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) {
        System.out.println(getWeekString(null));
    }
}
