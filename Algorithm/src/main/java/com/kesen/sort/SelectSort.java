package com.kesen.sort;

/**
 * @Auther: kesen
 * @Date: 2020/4/1 22:11
 * @Description: 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
 * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 **/
public class SelectSort {

	public static void sort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {

			// 从未排序中找到最小的值
			int j = i;
			int minIndex = i;
			for (; j < n - 1; j++) {
				if (arr[j + 1] < arr[minIndex]) {
					minIndex = j + 1;
				}
			}
			//交换
			int tmp;
			tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		}
	}
}
