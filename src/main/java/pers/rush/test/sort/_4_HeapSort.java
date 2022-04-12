package pers.rush.test.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author Rush
 *
 */
public class _4_HeapSort {
	/*
	 * 下标为i的节点的父节点下标：(i-1)/2 取整
	 * 下标为i的节点的左孩子下标：i*2+1
	 * 下标为i的节点的右孩子下标：i*2+2
	 * 最上面根节点下标为0
	 * 大顶堆：父节点要大于等于两孩子
	 * 小顶堆：父节点要小于等于两孩子
	 * 升序用大顶堆
	 * 降序用小顶堆
	 */
	
	/**
	 * 
	 * @param a 待排序数组
	 * @param n 数组长度
	 * @param i 待维护节点下标
	 */
	static void heapify(int[] a, int n, int i) {
		// 假设父节点最大
		int largest = i;
		// 左孩子下标
		int lson = 2*i+1;
		// 右孩子下标
		int rson = lson+1;
		if (lson < n && a[largest] < a[lson]) {
			largest = lson;
		}
		if (rson < n && a[largest] < a[rson]) {
			largest = rson;
		}
		// 如果换过
		if (largest != i) {
			SortUtils.swap(a, i, largest);
			heapify(a, n, largest);
		}
	}
	
	/**
	 * 堆排序入口
	 * @param a
	 */
	public static void heap_entry(int[] a) {
		int n = a.length;
		// 1.建堆
		for(int i = ((n-1)-1)/2; i >=0; i--) {
			heapify(a, n, i);
		}
		// 2. 排序
		for(int i = n-1; i>0; i--) {
			// 将最后元素和堆顶元素交换
			SortUtils.swap(a, i, 0);
			heapify(a, i, 0);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Const.nums1));
		heap_entry(Const.nums1);
		System.out.println(Arrays.toString(Const.nums1));
	}
}
