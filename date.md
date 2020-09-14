
使用Calendar获取当前周周一零点时间戳或日期
```
public static Date getTimesWeekMorning(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.setFirstDayOfWeek(Calendar.MONDAY); // Calendar默认每周的第一天是周日，不是周一，所以在周日时获取本周周一需要特殊处理
    cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    return cal.getTime();
}
```

使用Calendar获取当前周是本年的第几周
```
public static int getWeek(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.setFirstDayOfWeek(Calendar.MONDAY);
    return cal.get(Calendar.WEEK_OF_YEAR);
}
```

使用LocalDate/LocalDateTime获取当前周周一零点时间戳或日期

```
// 日常使用时，LocalDate.parse(dateStr, dateTimeFormatter)可用LocalDate.now()代替
// LocalDate.now().with(weekFields.getFirstDayOfWeek()).toString();
public static String getTimesWeekLocalDate(String dateStr) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,1);
    return LocalDate.parse(dateStr, dateTimeFormatter).with(weekFields.getFirstDayOfWeek()).toString();
    // return LocalDate.parse(dateStr, dateTimeFormatter).with(weekFields.dayOfWeek(), 1).toString();  两种写法都可以
}
```

使用LocalDate/LocalDateTime获取当前周是本年的第几周
```
public static int getWeekLocalDate(String dateStr) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter weekTimeFormatter = DateTimeFormatter.ofPattern("w");
    WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,1);
    return Integer.parseInt(LocalDate.parse(dateStr, dateTimeFormatter).with(weekFields.getFirstDayOfWeek()).format(weekTimeFormatter));

    // return Integer.parseInt(LocalDate.parse(dateStr, dateTimeFormatter).with(weekFields.dayOfWeek(), 1).format(weekTimeFormatter));  两种写法都可以
}
```

使用第三方工具包，王嘉哲大佬推荐的包，亲测可用 ==【推荐】==
```
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.3.10</version>
</dependency>
```
使用该包工具类DateUtil获取当前周周一零点时间戳或日期

```
DateUtil.beginOfWeek(date).toDateStr();
```

使用该包工具类DateUtil获取当前周是本年的第几周
```
DateUtil.weekOfYear(date1);
```

运行结果：
```
/**************************************************/
2020-12-26     （周六）
Calendar: 2020-12-21
Calendar: 52
LocalDate: 2020-12-21
LocalDate: 52
hutool_DateUtil: 2020-12-21
hutool_DateUtil: 52
/**************************************************/
2020-12-27     （周日）
Calendar: 2020-12-21
Calendar: 52
LocalDate: 2020-12-21
LocalDate: 52
hutool_DateUtil: 2020-12-21
hutool_DateUtil: 52
/**************************************************/
2020-12-28     （周一）
Calendar: 2020-12-28
Calendar: 1
LocalDate: 2020-12-28
LocalDate: 1
hutool_DateUtil: 2020-12-28
hutool_DateUtil: 1
/**************************************************/
2021-01-01     （周五）
Calendar: 2020-12-28
Calendar: 1
LocalDate: 2020-12-28
LocalDate: 1
hutool_DateUtil: 2020-12-28
hutool_DateUtil: 1
/**************************************************/
2021-01-03     （周日）
Calendar: 2020-12-28
Calendar: 1
LocalDate: 2020-12-28
LocalDate: 1
hutool_DateUtil: 2020-12-28
hutool_DateUtil: 1
```

