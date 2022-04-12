package pers.rush.test.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 1.选定中心轴
 * 2.将大于中心轴的数字放在中心轴的右边
 * 3.将小于中心轴的数字放在中心轴的左边
 * 4.分别对左右子序列重复前三步操作，直到序列长度为1，完成排序
 * @author Rush
 *
 */
public class _2_QuickSort {

	public static void qsort(int[] a, int low, int high) {
		if (low < high) { // 当low和high重合时，就不需要继续循环
			int mid = partition(a, low, high);
			qsort(a, low, mid-1);
			qsort(a, mid+1, high);
		}
	}
	
	private static int partition(int[] a, int low, int high) {
		// 取最后一位作为基准
		int pivot = a[high];
		int i = low;
		
		for (int j = low; j < high; ++j) {
			// 比pivot小的，全部换到前面去
			if (a[j] < pivot) {
				// 将a[j]和a[i]交换，并且i+1
				SortUtils.swap(a, j, i++);
			}
		}
		// 最后将i指向的元素和pivot元素互换
		SortUtils.swap(a, i, high);
		return i;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(Const.nums1));
		qsort(Const.nums1, 0, Const.nums1.length-1);
		System.out.println(Arrays.toString(Const.nums1));
	}

}
