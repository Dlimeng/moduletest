package com.lm;

import org.quartz.CronExpression;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: limeng
 * @Date: 2019/6/14 19:15
 */
public class Demo {
    public static List<String> parser(String cronExpression) {
        List<String> result = new ArrayList<String>();
        if (cronExpression == null || cronExpression.length() < 1) {
            return result;
        } else {
            CronExpression exp = null;
            try {
                exp = new CronExpression(cronExpression);
            } catch (ParseException e) {
                e.printStackTrace();
                return result;
            }
            Calendar calendar = Calendar.getInstance();
            String cronDate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE);
            String sStart = cronDate + " 00:00:00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dStart = null;
            Date dEnd = null;
            try {
                dStart = sdf.parse(sStart);
                calendar.setTime(dStart);
                calendar.add(Calendar.DATE, 1);
                dEnd = calendar.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date dd = new Date();
            dd = exp.getNextValidTimeAfter(dd);
            while (dd.getTime() < dEnd.getTime()) {
                result.add(sdf.format(dd));
                dd = exp.getNextValidTimeAfter(dd);
            }
            exp = null;
        }
        return result;
    }

    public static void main(String[] args) {
        String CRON_EXPRESSION = "0/30 * * * * ? *";
        System.out.println(CRON_EXPRESSION);
        List<String> lTime = new ArrayList<String>();
        lTime = parser(CRON_EXPRESSION);
        for (int i = 0; i < lTime.size(); i++) {
            System.out.println(lTime.get(i));
        }

    }

}
