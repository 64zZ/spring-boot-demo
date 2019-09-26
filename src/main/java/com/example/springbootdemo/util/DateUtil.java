package com.example.springbootdemo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: 时间格式类
 * @author: liuhang
 * @create: 2019-09-21 11:45
 **/
public class DateUtil {

    private final static String DEFAULT_FULL_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    private final static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public final static String START_DAY = "00:00:00";
    public final static String MIDDAY = "12:00:00";
    public final static String END_DAY = "23:59:59";
    public LocalDateTime localDateTime = LocalDateTime.now();

    /**
     * 默认格式解析日期
     */
    public static DateUtil now() {
        DateUtil dateUtil = new DateUtil();
        dateUtil.localDateTime = LocalDateTime.now();
        return dateUtil;
    }

    /**
     * 默认格式解析日期
     */
    public static DateUtil date(TemporalAdjuster date) {
        DateUtil dateUtil = new DateUtil();
        dateUtil.localDateTime = dateUtil.localDateTime.with(date);
        return dateUtil;
    }

    /**
     * 默认格式解析日期
     */
    public static DateUtil date(String date) {
        DateUtil dateUtil = new DateUtil();
        return dateUtil.parseOf(date);
    }

    /**
     * 默认格式解析日期
     */
    public static DateUtil date(String date, String pattern) {
        DateUtil dateUtil = new DateUtil();
        dateUtil.localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        return dateUtil;
    }

    /**
     * 默认格式解析日期 格式不对返回当前时间
     */
    public DateUtil parseOf(String srcDate) {
        String patStr;
        int startOfHour = 11;
        if (srcDate.contains(" ")) {
            patStr = DEFAULT_FULL_PATTERN.substring(0, srcDate.length());
            localDateTime = LocalDateTime.parse(srcDate, DateTimeFormatter.ofPattern(patStr));
        } else if (srcDate.contains("-") && srcDate.length() <= startOfHour - 1) {
            patStr = DEFAULT_FULL_PATTERN.substring(0, startOfHour - 1);
            LocalDate localDate = LocalDate.parse(srcDate, DateTimeFormatter.ofPattern(patStr));
            localDateTime = localDateTime.with(localDate).with(LocalTime.parse(START_DAY));
        } else if (srcDate.contains(":") && startOfHour + srcDate.length() <= DEFAULT_FULL_PATTERN.length()) {
            patStr = DEFAULT_FULL_PATTERN.substring(startOfHour);
            LocalTime localTime = LocalTime.parse(srcDate, DateTimeFormatter.ofPattern(patStr));
            localDateTime = localDateTime.with(localTime);
        } else {
            System.out.println();
            return now();

        }
        return this;
    }

    /**
     * 按指定格式解析日期
     */
    public DateUtil parseOf(String date, String pattern) {
        localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        return this;
    }

    /**
     * 一天的开始
     *
     * @return yyyy-MM-dd HH:mm:ss格式字符串
     */
    public String startOfDay() {
        return localDateTime.toLocalDate() + " " + START_DAY;
    }

    /**
     * 正中
     *
     * @return yyyy-MM-dd HH:mm:ss格式字符串
     */
    public String midOfDay() {
        return localDateTime.toLocalDate() + " " + MIDDAY;
    }

    /**
     * 一天的结束
     *
     * @return yyyy-MM-dd HH:mm:ss格式字符串
     */
    public String endOfDay() {
        return localDateTime.toLocalDate() + " " + END_DAY;
    }

    /**
     * 月第一天 1
     */
    public DateUtil firstDayOfMonth() {
        localDateTime = localDateTime.withDayOfMonth(1);
        return this;
    }

    /**
     * 月最后一天 28/31
     */
    public DateUtil lastDayOfMonth() {
        localDateTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        return this;
    }

    /**
     * 获得周几
     *
     * @return 数字 1 - 7
     */
    public int getDayOfWeek() {
        return localDateTime.getDayOfWeek().getValue();
    }

    /**
     * 获得号
     *
     * @return 数字号 1 - 28/31
     */
    public int getDayOfMonth() {
        return localDateTime.getDayOfMonth();
    }

    /**
     * 获得一年中的第几天
     *
     * @return 数字月
     */
    public int getDayOfYear() {
        return localDateTime.getDayOfYear();
    }

    /**
     * 获得月
     *
     * @return 数字月
     */
    public int getMonth() {
        return localDateTime.getMonth().getValue();
    }

    /**
     * 获得月字符串，小于10 带 0
     *
     * @return 数字月
     */
    public String getMonthStr() {
        int month = getMonth();
        if (month > 9) {
            return month + "";
        } else {
            return "0" + month;
        }
    }

    /**
     * 获得年
     *
     * @return 数字年
     */
    public int getYear() {
        return localDateTime.getYear();
    }

    /**
     * 格式化输出
     *
     * @return 格式字符串
     */
    public String format() {
        return format(DEFAULT_PATTERN);
    }

    /**
     * 自定义格式化输出
     *
     * @return 格式字符串
     */
    public String format(String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = DEFAULT_PATTERN;
        }
        return DateTimeFormatter.ofPattern(pattern).format(localDateTime);
    }

    /**
     * 设置时间
     */
    public DateUtil with(TemporalAdjuster adjuster) {
        localDateTime = localDateTime.with(adjuster);
        return this;
    }

    /**
     * 比较时间
     *
     * @param other 要比较的时间
     * @return 负数比other小，正数为大，零相等
     */
    public int compareTo(DateUtil other) {
        return localDateTime.compareTo(other.localDateTime);
    }

    /**
     * 比较时间
     *
     * @param other 要比较的时间
     * @return true比other小，false比other大
     */
    public boolean isBefore(DateUtil other) {
        return localDateTime.isBefore(other.localDateTime);
    }

    /**
     * 比较时间
     *
     * @param other 要比较的时间
     * @return true比other大，false比other小
     */
    public boolean isAfter(DateUtil other) {
        return localDateTime.isAfter(other.localDateTime);
    }

    /**
     * 指定 {@code Year}
     *
     * @param year 年份
     */
    public DateUtil setYear(int year) {
        localDateTime = localDateTime.withYear(year);
        return this;
    }

    /**
     * 指定月 ValueRange.of(1, 12)
     *
     * @param month 月
     */
    public DateUtil setMonth(int month) {
        localDateTime = localDateTime.withMonth(month);
        return this;
    }

    /**
     * 指定一月中的第几天 ValueRange.of(1, 28-31)
     *
     * @param dayOfMonth 一月中的第几天
     */
    public DateUtil setDayOfMonth(int dayOfMonth) {
        localDateTime = localDateTime.withDayOfMonth(dayOfMonth);
        return this;
    }

    /**
     * 指定一年中的第几天 ValueRange.of(1, 365, 366))
     *
     * @param dayOfYear 一年中的第几天
     */
    public DateUtil setDayOfYear(int dayOfYear) {
        localDateTime = localDateTime.withDayOfYear(dayOfYear);
        return this;
    }

    /**
     * 指定小时 ValueRange.of(0, 23)
     *
     * @param hour 小时
     */
    public DateUtil setHour(int hour) {
        localDateTime = localDateTime.withHour(hour);
        return this;
    }

    /**
     * 指定分钟 ValueRange.of(0, 59)
     *
     * @param minute 分钟
     */
    public DateUtil setMinute(int minute) {
        localDateTime = localDateTime.withMinute(minute);
        return this;
    }

    /**
     * 指定秒 ValueRange.of(0, 59)
     *
     * @param second 秒
     */
    public DateUtil setSecond(int second) {
        localDateTime = localDateTime.withSecond(second);
        return this;
    }

    /**
     * 指定毫秒 ValueRange.of(0, 999999999))
     *
     * @param nanoOfSecond 毫秒
     */
    public DateUtil setNano(int nanoOfSecond) {
        localDateTime = localDateTime.withNano(nanoOfSecond);
        return this;
    }

    /**
     * 加多少年
     *
     * @param years 要加的年数
     */
    public DateUtil plusYears(long years) {
        localDateTime = localDateTime.plusYears(years);
        return this;
    }

    /**
     * 加多少月
     *
     * @param months 要加的月数
     */
    public DateUtil plusMonths(long months) {
        localDateTime = localDateTime.plusMonths(months);
        return this;
    }

    /**
     * 加多少周
     *
     * @param weeks 周数
     */
    public DateUtil plusWeeks(long weeks) {
        localDateTime = localDateTime.plusWeeks(weeks);
        return this;
    }

    /**
     * 加多少天
     *
     * @param days 天数
     */
    public DateUtil plusDays(long days) {
        localDateTime = localDateTime.plusDays(days);
        return this;
    }

    /**
     * 加多少小时
     *
     * @param hours 小时数
     */
    public DateUtil plusHours(long hours) {
        localDateTime = localDateTime.plusHours(hours);
        return this;
    }

    /**
     * 加多少分钟
     *
     * @param minutes 分钟数
     */
    public DateUtil plusMinutes(long minutes) {
        localDateTime = localDateTime.plusMinutes(minutes);
        return this;
    }

    /**
     * 加多少秒
     *
     * @param seconds 秒数
     */
    public DateUtil plusSeconds(long seconds) {
        localDateTime = localDateTime.plusSeconds(seconds);
        return this;
    }

    /**
     * 加多少毫秒
     *
     * @param nanos 毫秒数
     */
    public DateUtil plusNanos(long nanos) {
        localDateTime = localDateTime.plusNanos(nanos);
        return this;
    }

    /**
     * 减去一个日期 Period.of(2018,1,18) Duration
     *
     * @param amountToSubtract 日期
     */
    public DateUtil minus(TemporalAmount amountToSubtract) {
        localDateTime = localDateTime.minus(amountToSubtract);
        return this;
    }

    /**
     * 减去一个日期 Period.of(2018,1,18) Duration
     *
     * @param amountToSubtract 日期
     * @param unit             单位
     */
    public DateUtil minus(long amountToSubtract, TemporalUnit unit) {
        localDateTime = localDateTime.minus(amountToSubtract, unit);
        return this;
    }

    /**
     * 减多少年
     *
     * @param years 年数
     */
    public DateUtil minusYears(long years) {
        return (years == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1) : plusYears(-years));
    }

    /**
     * 减多少月
     *
     * @param months 月数
     */
    public DateUtil minusMonths(long months) {
        return (months == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1) : plusMonths(-months));
    }

    /**
     * 减多少周
     *
     * @param weeks 周数
     */
    public DateUtil minusWeeks(long weeks) {
        return (weeks == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1) : plusWeeks(-weeks));
    }

    /**
     * 减多少天
     *
     * @param days 天数
     */
    public DateUtil minusDays(long days) {
        return (days == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1) : plusDays(-days));
    }

    /**
     * 减多少小时
     *
     * @param hours 小时数
     */
    public DateUtil minusHours(long hours) {
        localDateTime = localDateTime.minusHours(hours);
        return this;
    }

    /**
     * 减多少分钟
     *
     * @param minutes 分钟数
     */
    public DateUtil minusMinutes(long minutes) {
        localDateTime = localDateTime.minusMinutes(minutes);
        return this;
    }

    /**
     * 减多少秒
     *
     * @param seconds 秒数
     */
    public DateUtil minusSeconds(long seconds) {
        localDateTime = localDateTime.minusSeconds(seconds);
        return this;
    }

    /**
     * 减多少毫秒
     *
     * @param nanos 毫秒数
     */
    public DateUtil minusNanos(long nanos) {
        localDateTime = localDateTime.minusNanos(nanos);
        return this;
    }

    @Override
    public String toString() {
        return format();
    }

    /**
     * 转时间戳
     *
     * @return 时间戳
     */
    public long getTime() {
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param date1 时间1
     * @param date2 时间2
     * @return 时间间隔（天）
     */
    public static int dayBetween(String date1, String date2) {
        int days = 0;
        try {
            DateUtil dateUtil1 = date(date1);
            DateUtil dateUtil2 = date(date2);
            days = (int) ((dateUtil1.getTime() - dateUtil2.getTime()) / (1000 * 3600 * 24));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return days;
    }


    /**
     * 根据出发日期得到年龄
     *
     * @param birthday  出生日期
     * @param startDate 出团日期
     */
    public static int getAge(String birthday, String startDate) {
        int returnAge;
        DateUtil birthdate = DateUtil.date(birthday);
        int birthYear = birthdate.getYear();
        int birthMonth = birthdate.getMonth();
        int birthDay = birthdate.getDayOfMonth();
        DateUtil date = DateUtil.date(startDate);
        int startYear = date.getYear();
        int startMonth = date.getMonth();
        int startDay = date.getDayOfMonth();
        if (startYear == birthYear) {
            returnAge = 0;//同年 则为0岁
        } else {
            int ageDiff = startYear - birthYear; //年之差
            if (ageDiff > 0) {
                if (startMonth == birthMonth) {
                    int dayDiff = startDay - birthDay;//日之差
                    if (dayDiff < 0) {
                        returnAge = ageDiff - 1;
                    } else {
                        returnAge = ageDiff;
                    }
                } else {
                    int monthDiff = startYear - birthMonth;//月之差
                    if (monthDiff < 0) {
                        returnAge = ageDiff - 1;
                    } else {
                        returnAge = ageDiff;
                    }
                }
            } else {
                returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天
            }
        }
        return returnAge;//返回周岁年龄
    }
}
