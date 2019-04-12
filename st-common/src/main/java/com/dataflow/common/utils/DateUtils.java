package com.dataflow.common.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * 日期功能类
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils{
    private static final String DEFAULT_TIME_PATTER = "yyyy-MM-dd HH:mm:ss";
    private static final String DEFAULT_SHORT_DATE_PATTER = "yyyy-MM-dd";
    public static final String CHINA_DATE_PATTER = "yyyy年MM月dd日";
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
    public static final String DATE_FORMAT_FOR_RECORD = "yyyyMMdd";
    public static final String DATE_FORMAT_FOR_NAME = "yyyyMMddHHmmss";
    /**
     * default format YYYY-MM-dd HH:mm:ss
     * @param source
     * @return
     */
    public static Date parseDate(String source) {
        String format = DEFAULT_SHORT_DATE_PATTER;
        if(StringUtils.isNotBlank(source) && source.trim().length() > 10){
            format = DEFAULT_TIME_PATTER;
        }
        FastDateFormat fastDateFormat = FastDateFormat.getInstance(format);

        Date result = null;
        try {
            if (source != null) {
                result = fastDateFormat.parse(source);
            }
        } catch (ParseException ex) {
            System.out.println("Date format must be " + format);
        }
        return result;
    }


    public static String format(String pattern, Date date) {
        FastDateFormat format =FastDateFormat.getInstance(pattern);
        return format.format(date);
    }

    public static String format(Date date) {
        FastDateFormat format =FastDateFormat.getInstance(DEFAULT_TIME_PATTER);
        return format.format(date);
    }


}
