package pers.rush.test.sdf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App2 {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public static void main(String[] args) throws InterruptedException {
		for(; ;) {
			new MyThread().start();
		}
	}
}

class MyThread extends Thread { 
	String dateStr = "2020-12-27 22:11:33.444";
	
	@Override
	public void run() {
		Date d = null;
		try {
			d = App2.sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "--" + d);
	}
};
