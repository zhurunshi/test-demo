package pers.rush.test.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 因为每趟排序间隔逐渐缩小，希尔排序也叫缩小增量排序
 * @author Rush
 *
 */ 
public class _7_ShellSort {
	
	public static void sort(int[] arr) {
		int n = arr.length;
		int i, j, inc, key;
		//初始增量：n/2，每一趟之后除以二
		for (inc = n/2; inc > 0; inc /= 2) {
			// 每一趟采用插入排序
			for (i = inc; i < n; ++i) {
				key = arr[i];
				for (j = i; j >= inc && key < arr[j-inc]; j-=inc) {
					arr[j] = arr[j-inc];
				}
				arr[j] = key;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Const.nums1));
		sort(Const.nums1);
		System.out.println(Arrays.toString(Const.nums1));
	}
}
