package com.cc.rd.util;

import org.springframework.util.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: DateTimeUtils
 * @description: 时间工具类
 * @author: cchen
 * @create: 2019-03-05 18:44
 */
public class DateTimeUtils {
    /**
     * 一分钟多少毫秒
     */
    private static final Long SEC = 60 * 1000L;

    /**
     * 昨天0点
     *
     * @return long
     */
    public static Long getStartOfYesterday() {
        return LocalDate.now(ZoneOffset.UTC)
                .minusDays(1)
                .atTime(0, 0, 0)
                .toInstant(ZoneOffset.UTC)
                .toEpochMilli();
    }

    /**
     * 今天凌晨
     *
     * @return long
     */
    public static Long getStartOfToday() {
        return LocalDateTime.now(ZoneOffset.UTC)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0)
                .toInstant(ZoneOffset.UTC)
                .toEpochMilli();
    }

    /**
     * 明天凌晨
     *
     * @return
     */
    public static Long getStartOfTomorrow() {
        return LocalDateTime
                .now(ZoneOffset.UTC)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0)
                .plusDays(1)
                .toInstant(ZoneOffset.UTC)
                .toEpochMilli();
    }

    public static Long getStartOfLastWeek() {
        return LocalDate.now(ZoneOffset.UTC)
                .minusWeeks(1)
                .atTime(0, 0, 0)
                .toInstant(ZoneOffset.UTC)
                .toEpochMilli();
    }

    public static Long getStartOfLastMonth() {
        return LocalDate.now(ZoneOffset.UTC)
                .minusMonths(1)
                .atTime(0, 0, 0)
                .toInstant(ZoneOffset.UTC)
                .toEpochMilli();
    }

    /**
     * 这个跟
     * LocalDateTime
     * .now(ZoneOffset.UTC)
     * .toInstant(ZoneOffset.UTC)
     * .toEpochMilli()
     * 是一个效果
     *
     * @return
     */
    public static long utcNow() {
        return System.currentTimeMillis();
    }

    /**
     * 获取今天结束时间
     *
     * @return
     */
    @Deprecated
    public static Long getTodayLastTime() {
        return LocalDate.now(ZoneOffset.UTC)
                .plusDays(1)
                .atTime(0, 0, 0)
                .toInstant(ZoneOffset.UTC)
                .toEpochMilli();
    }


    public static Long getEndOfDay() {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(utcNow()), ZoneId.systemDefault());
        ;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return endOfDay.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获得该时区当地时间的晚上0点 对应的 UTC时间戳
     *
     * @param timezone 例如 "+08:00"
     * @return utc时间戳
     */
    public static Long getEndOfDay(String timezone) {
        if (StringUtils.isEmpty(timezone)) {
            timezone = "+08:00";
        }

        return 1000 * ZonedDateTime
                .now(ZoneId.of(timezone))
                .plusDays(1)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .toEpochSecond();
    }


    public static Long getStartOfDay() {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(utcNow()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return startOfDay.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static Long getMillisByMins(int duration) {
        return duration * SEC;
    }

    public final static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public static String toChinaDateTime(long utcTimestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(utcTimestamp), ZoneOffset.ofHours(8)).format(df);
    }


    /**
     * 根据时区转换为本时区时间
     *
     * @param utc      utc 时间
     * @param timeZone 时区
     * @return
     */
    public static String utcToLocal(Long utc, String timeZone) {
        LocalDateTime localDateTime = new Date(utc).toInstant().atZone(ZoneId.of(timeZone)).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    private static String addZero(int param) {
        String paramStr = param < 10 ? "0" + param : "" + param;
        return paramStr;
    }

    /**
     * 将毫秒字符串转成时间格式yyyy-MM-dd HH:mm
     */
    public static String getMil2mmTimeFormat(String timeStr) {
        long time = Long.parseLong(timeStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String monthStr = addZero(month);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String dayStr = addZero(day);
        //24小时制
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String hourStr = addZero(hour);
        int minute = calendar.get(Calendar.MINUTE);
        String minuteStr = addZero(minute);
        int second = calendar.get(Calendar.SECOND);
        String secondStr = addZero(second);
        return (year + "-" + monthStr + "-" + dayStr + " " + hourStr + ":" + minuteStr);
    }

}
    