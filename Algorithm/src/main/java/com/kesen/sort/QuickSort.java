package com.kesen.sort;

/**
 * @Auther: kesen
 * @Date: 2020/4/12 15:43
 * @Description:
 **/
public class QuickSort {

	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotIndex = partition(arr, left, right);
		sort(arr, left, pivotIndex - 1);
		sort(arr, pivotIndex + 1, right);
	}

	/**
	 * 分治（双边循环法）
	 * 思想：即从左到右找到一个大于基准值的数和从右往左找到一个小于基准值的数进行交换‘
	 * 终止条件：i == j
	 * 交换完成后将i == j 时候的值和基准值进行交换，就将数组分成了三部分。
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int i = left;
		int j = right;
		// 控制j向左移动
		while (i != j) {
			while (i < j && arr[j] > pivot) {
				j--;
			}
			while (i < j && arr[i] <= pivot) {
				i++;
			}
			if (i < j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}

		}
		arr[left] = arr[i];
		arr[i] = pivot;
		return i;


	}
}
