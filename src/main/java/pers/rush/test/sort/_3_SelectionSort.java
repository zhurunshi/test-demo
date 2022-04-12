package pers.rush.test.sort;

import java.util.Arrays;

public class _3_SelectionSort {
	static void asc(int[] a) {
		for(int i = 0; i < a.length; ++i) {
			int min = i;
			for (int j = i+1; j < a.length; ++j) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			// 遍历一遍后，找到最小的再交换 
			SortUtils.swap(a, min, i);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Const.nums1));
		asc(Const.nums1);
		System.out.println(Arrays.toString(Const.nums1));
	}
}
