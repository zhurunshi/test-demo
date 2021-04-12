package pers.rush.test.sdf;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	Calendar c = Calendar.getInstance();
    	c.set(2020, Calendar.DECEMBER, 27, 15, 30);
    	Date d = c.getTime();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    	System.out.println(sdf1.format(d));
    	SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
    	System.out.println(sdf2.format(d));
    	
    	/*
    	 * yyyy 正常年份
    	 * YYYY week year（周所在年份）
    	 * MM 月份
    	 * dd 日期
    	 * HH 24小时制
    	 * hh 12小时制
    	 * mm 分钟
    	 * ss 秒
    	 * SSS 毫秒
    	 */
    }
}
