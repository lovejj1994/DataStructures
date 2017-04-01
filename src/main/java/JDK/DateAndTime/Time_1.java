package JDK.DateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * JDK8 新日期API
 * Created by panqian on 2017/3/6.
 */
public class Time_1 {
    public static void main(String[] args) {



        // 代替System.currentTimeMillis()
        //Instant主要是表示一个瞬时点在时间线上
        Instant start = Instant.now();
        for (int i = 0; i < 100000000; i++) {
        }
        Instant end = Instant.now();

        Duration between = Duration.between(start, end);
        long l = between.toMillis();
        System.out.println("程序执行了" + l + "毫秒");


        //代替 Calendar
        LocalDate now = LocalDate.now();
        System.out.println("今天的日期" + now.toString());
        LocalDate after5days = now.plusDays(5);
        System.out.println("五天后的日期" + after5days.toString());

        //计算今天是星期几
        int value = now.getDayOfWeek().getValue();

        switch (value) {
            case 1:
                System.out.println("今天星期一");
                break;
            case 2:
                System.out.println("今天星期二");
                break;
            case 3:
                System.out.println("今天星期三");
                break;
            case 4:
                System.out.println("今天星期四");
                break;
            case 5:
                System.out.println("今天星期五");
                break;
            case 6:
                System.out.println("今天星期六");
                break;
            case 7:
                System.out.println("今天星期日");
                break;
            default:
                System.out.println("出错了");
        }

        //计算下个星期五(从今天开始算，如果今天是星期五，就会返回今天的日期)
        //LocalDate不带时区概念
        LocalDate nextFriday = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        System.out.println("下一个星期五是:" + nextFriday);

        //计算这个月的第一天
        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("这个月的第一天是:" + firstDayOfMonth);

        //格式化时间
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分");
        String formatTime = formatter.format(now1);
        System.out.println("格式化的时间" + formatTime);

        //字符串转时间
        LocalDateTime parse = LocalDateTime.parse("2017年03月06日 06时56分32秒", DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒"));
        System.out.println("解析的时间" + parse);

    }
}
