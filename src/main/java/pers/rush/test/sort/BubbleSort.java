package pers.rush.test.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 对存放原始数据的数组，按从前往后的方向进行多次扫描，每次扫描称为一趟。
 * 当发现相邻两个数据的次序与排序要求的大小不符合时，将这两个数据进行互换。
 * 如果从小到大排序，这时，较小的数据就会逐个向前移动，好像气泡向上漂浮一样。
 * @author Rush
 *
 */
public class BubbleSort {
	static void asc(int[] a) {
		// 外层循环控制总共循环几轮 
		// 对n个数进行排序，需要n-1轮比较
		for (int i = 0; i < a.length-1; ++i) {
			// 内层循环 
			for (int j = 0; j < a.length-1-i; ++j ) {
				if (a[j] > a[j+1]) {
					int t = a[j+1];
					a[j+1] = a[j];
					a[j] = t;
				}
			}
		}
	}
	static void desc(int[] a) {
		// 外层循环控制总共循环几轮 
		// 对n个数进行排序，需要n-1轮比较
		for (int i = 0; i < a.length-1; ++i) {
			// 内层循环 
			for (int j = 0; j < a.length-1-i; ++j ) {
				if (a[j] < a[j+1]) {
					int t = a[j+1];
					a[j+1] = a[j];
					a[j] = t;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Const.nums1));
		BubbleSort.asc(Const.nums1);
		System.out.println(Arrays.toString(Const.nums1));
		BubbleSort.desc(Const.nums1);
		System.out.println(Arrays.toString(Const.nums1));
	}
}
