package pers.rush.test.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public static void main(String[] args) {
		Object t = new Object();
		
		ThreadLocal<SimpleDateFormat> threadlocal = new ThreadLocal<SimpleDateFormat>();
		String s = "2020-12-27 22:11:33.444";
		for (; ;) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Date formattedDate = null;
					try {
//						formattedDate = sdf.parse(s);
						threadlocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
						formattedDate = threadlocal.get().parse(s);
						System.out.println(formattedDate);
					} catch (ParseException e) {
						e.printStackTrace();
					} finally {
						threadlocal.remove();
//						threadlocal = null;
					}
				}
			}).start();
		}
	}
}
