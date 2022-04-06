package pers.rush.test.leapyear;

import java.time.Year;

public class LeapyearTest {
	static int[] b = {
			1,0,0,0,1,0,0,0,1,0,
			0,0,1,0,0,0,1,0,0,0,
			1,0,0,0,1,0,0,0,1,0,
			0,0,1,0,0,0,1,0,0,0,
			1,0,0,0,1,0,0,0,1,0,
			0,0,1,0,0,0,1,0,0,0,
			1,0,0,0,1,0,0,0,1,0,
			0,0,1,0,0,0,1,0,0,0,
			1,0,0,0,1,0,0,0,1,0,
			0,0,1,0,0,0,1,0,0,0,
			1,0,0,0,1,0,0,0,1,0,
			0,0,1,0,0,0,1,0,0,0
		};
	
	static int[] a = new int[120];
	static {
		for (int i = 1980; i < 2100; i += 4) {
			if (Year.isLeap(i)) {
				a[i % 1980] = 1;
			}
		}
	}
	
	static void originMethod (int left, int right) {
		for(int i = left; i <= right; ++i) {
			if (Year.isLeap(i));
		}
	}
	
	static void byrush(int left, int right) {
		for(int i = left; i <= right; ++i) {
			if (0 == a[i%1980]);
		}
	}
	
	public static void main(String[] args) {
		int num = 100000000;
		System.out.println("num=" + num);
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < num; ++i) {
			originMethod(1980, 2099);
//			if (Year.isLeap(2010));
		}
		long end1 = System.currentTimeMillis();
		System.out.println("originMethod="+ (end1-start1));
		
		
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < num; ++i) {
			byrush(1980,2099);
//			if(1 == a[2010%1980]);
		}
		long end2 = System.currentTimeMillis();
		System.out.println("byrush="+ (end2-start2));
	}
}
