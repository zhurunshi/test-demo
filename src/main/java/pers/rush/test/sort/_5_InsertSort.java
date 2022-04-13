package pers.rush.test.sort;

import java.util.Arrays;

public class _5_InsertSort {
	static void sort(int[] a) {
		int n = a.length;
		// 从第1个元素开始，因为第0个本身有序
		for(int i = 1; i < n; ++i) {
			int key = a[i];
			int j = i-1;
			while (j >= 0 && a[j] > key) {
				a[j+1] = a[j];
				j--;
			}
			// 因为前面j--了，所以这里要+1
			a[j+1] = key;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Const.nums1));
		sort(Const.nums1);
		System.out.println(Arrays.toString(Const.nums1));
	}
}
