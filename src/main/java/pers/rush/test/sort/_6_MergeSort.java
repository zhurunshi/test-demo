package pers.rush.test.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 利用分治和递归的思想
 * @author Rush
 *
 */
public class _6_MergeSort {

	/**
	 * 
	 * @param arr 待排序数组
	 * @param n 数组大小
	 */
	private static void sort(int[] arr, int n) {
		// 分配一个辅助数组
		int[] tempArr = new int[n];
		divide(arr, tempArr, 0, n-1);
	}
	
	/**
	 * 划分
	 * @param arr
	 * @param tempArr
	 * @param i
	 * @param j
	 */
	private static void divide(int[] arr, int[] tempArr, int left, int right) {
		// 如果只有一个元素，则停止
		if (left < right) {
			// 找中间点
			int mid = (left+right)/2;
			// 递归划分左半区
			divide(arr, tempArr, left, mid);
			// 递归划分右半区
			divide(arr, tempArr, mid+1, right);
			// 合并已经排序的部分
			merge(arr, tempArr, left, mid, right);
		}
		
	}

	/**
	 * 合并
	 * @param arr 
	 * @param tempArr
	 * @param left 左半区起始下标
	 * @param mid 中间点
	 * @param right 右半区结束下标
	 */
	private static void merge(int[] arr, int[] tempArr, int left, int mid, int right) {
		// 标记左半区第一个未排序的元素
		int lPos = left;
		// 标记右半区第一个未排序的元素
		int rPos = mid + 1;
		// 临时数组元素的下标
		int pos = left;
		// 合并（当左半区有元素，右半区也有元素）
		while (lPos <= mid && rPos <= right) {
			if (arr[lPos] < arr[rPos]) {
				tempArr[pos++] = arr[lPos++];
			} else {
				tempArr[pos++] = arr[rPos++];
			}
		}
		// 合并左半区剩余的元素
		while(lPos <= mid) {
			tempArr[pos++] = arr[lPos++];
		}
		// 合并右半区剩余的元素
		while(rPos <= right) {
			tempArr[pos++] = arr[rPos++];
		}
		// 把临时数组中合并后的元素复制回原来的数组
		while (left <= right) {
			arr[left] = tempArr[left];
			left++;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(Const.nums1));
		sort(Const.nums1, Const.nums1.length);
		System.out.println(Arrays.toString(Const.nums1));
	}

}
