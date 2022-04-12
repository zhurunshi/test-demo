package pers.rush.test.sort;

/**
 * 排序工具类
 * @author Rush
 *
 */
public class SortUtils {
	
	/**
	 * 将a[l]和a[r]元素交换
	 * @param a
	 * @param l
	 * @param r
	 */
	public static void swap(int[] a, int l, int r) {
		int t = a[l];
		a[l] = a[r];
		a[r] = t;
	}
}
