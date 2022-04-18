package pers.rush.test.sort;

import java.util.Arrays;

public class _8_CountingSort {
	public static void sort(int[] arr) {
		int n = arr.length;
		if (n < 2) {
			return;
		}
		// 寻找最大的元素
		int max = arr[0];
		for (int i = 1; i < n; ++i) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		// 创建计数数组
		int[] count = new int[max+1];
		// 计数
		for (int i = 0; i < n; ++i) {
			count[arr[i]]++;
		}
		// 统计计数累计值
		for (int i = 1; i <= max; ++i) {
			count[i] += count[i-1];
		}
		// 结果数组
		int[] output = new int[n];
		// 将元素放到正确的位置上
		for(int i = 0; i < n; ++i) {
			output[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		// 将结果复制回原数组
		for (int i = 0; i < n; ++i) {
			arr[i] = output[i];
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Const.nums1));
		sort(Const.nums1);
		System.out.println(Arrays.toString(Const.nums1));
	}
}
