package Test;

import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws Exception {

        System.out.println(LocalDate.now().with(WeekFields.of(DayOfWeek.MONDAY, 1).getFirstDayOfWeek()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("/**************************************************/");
        Date date = sdf.parse("2020-12-26");
        System.out.println(sdf.format(date) + "     （周六）");
        System.out.println("Calendar: " + sdf.format(getTimesWeekMorning(date)));
        System.out.println("Calendar: " + getWeek(date));
        System.out.println("LocalDate: " + getTimesWeekLocalDate(sdf.format(date)));
        System.out.println("LocalDate: " + getWeekLocalDate(sdf.format(date)));
        System.out.println("hutool_DateUtil: " + DateUtil.beginOfWeek(date).toDateStr());
        System.out.println("hutool_DateUtil: " + DateUtil.weekOfYear(date));
        System.out.println("/**************************************************/");
        Date date1 = sdf.parse("2020-12-27");
        System.out.println(sdf.format(date1) + "     （周日）");
        System.out.println("Calendar: " + sdf.format(getTimesWeekMorning(date1)));
        System.out.println("Calendar: " + getWeek(date1));
        System.out.println("LocalDate: " + getTimesWeekLocalDate(sdf.format(date1)));
        System.out.println("LocalDate: " + getWeekLocalDate(sdf.format(date1)));
        System.out.println("hutool_DateUtil: " + DateUtil.beginOfWeek(date1).toDateStr());
        System.out.println("hutool_DateUtil: " + DateUtil.weekOfYear(date1));
        System.out.println("/**************************************************/");
        Date date2 = sdf.parse("2020-12-28");
        System.out.println(sdf.format(date2) + "     （周一）");
        System.out.println("Calendar: " + sdf.format(getTimesWeekMorning(date2)));
        System.out.println("Calendar: " + getWeek(date2));
        System.out.println("LocalDate: " + getTimesWeekLocalDate(sdf.format(date2)));
        System.out.println("LocalDate: " + getWeekLocalDate(sdf.format(date2)));
        System.out.println("hutool_DateUtil: " + DateUtil.beginOfWeek(date2).toDateStr());
        System.out.println("hutool_DateUtil: " + DateUtil.weekOfYear(date2));
        System.out.println("/**************************************************/");
        Date date3 = sdf.parse("2021-01-01");
        System.out.println(sdf.format(date3) + "     （周五）");
        System.out.println("Calendar: " + sdf.format(getTimesWeekMorning(date3)));
        System.out.println("Calendar: " + getWeek(date3));
        System.out.println("LocalDate: " + getTimesWeekLocalDate(sdf.format(date3)));
        System.out.println("LocalDate: " + getWeekLocalDate(sdf.format(date3)));
        System.out.println("hutool_DateUtil: " + DateUtil.beginOfWeek(date3).toDateStr());
        System.out.println("hutool_DateUtil: " + DateUtil.weekOfYear(date3));
        System.out.println("/**************************************************/");
        Date date4 = sdf.parse("2021-01-03");
        System.out.println(sdf.format(date4) + "     （周日）");
        System.out.println("Calendar: " + sdf.format(getTimesWeekMorning(date4)));
        System.out.println("Calendar: " + getWeek(date4));
        System.out.println("LocalDate: " + getTimesWeekLocalDate(sdf.format(date4)));
        System.out.println("LocalDate: " + getWeekLocalDate(sdf.format(date4)));
        System.out.println("hutool_DateUtil: " + DateUtil.beginOfWeek(date4).toDateStr());
        System.out.println("hutool_DateUtil: " + DateUtil.weekOfYear(date4));
    }

    public static Date getTimesWeekMorning(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY); // Calendar默认每周的第一天是周日，不是周一，所以在周日时获取本周周一需要特殊处理
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    public static int getWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }


    public static String getTimesWeekLocalDate(String dateStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter weekTimeFormatter = DateTimeFormatter.ofPattern("w");
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,1);
        return LocalDate.parse(dateStr, dateTimeFormatter).with(weekFields.getFirstDayOfWeek()).toString();
    }

    public static int getWeekLocalDate(String dateStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter weekTimeFormatter = DateTimeFormatter.ofPattern("w");
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,1);
        return Integer.parseInt(LocalDate.parse(dateStr, dateTimeFormatter).with(weekFields.dayOfWeek(), 1).format(weekTimeFormatter));
    }

}
