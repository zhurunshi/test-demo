package pers.rush.test.sort;

public class Const {
	static int[] nums1 = {
			19,9,23,21,46,26,88,43,23,98
	};
	
	public static String toString(int[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; ++i) {
			if (i == 0) {
				sb.append(a[i]);
			} else {
				sb.append(a[i] + ",");
			}
		}
		return sb.toString();
	}
}
