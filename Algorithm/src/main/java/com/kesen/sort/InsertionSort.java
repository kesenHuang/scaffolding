package com.kesen.sort;

/**
 * @Auther: kesen
 * @Date: 2020/4/1 21:48
 * @Description: 插入算法步骤
 * 从第一个元素开始，该元素可以认为已经被排序
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 将新元素插入到该位置后
 * 重复步骤2~5
 **/
public class InsertionSort {

	public  static  void sort(int[] arr) {
		int n = arr.length;
		if (n <= 1) return;
		for (int i =1; i < n; i++) {
			int currentValue= arr[i];
			int j = i - 1 ;
			// 插入排序，前面都已经从小到大排序完成，如果未进入while，所以当前元素只能放到最后
			// 先对j范围进行校验，避免超出INDEX范围
			while (  j>=0 && arr[j]> currentValue) {
				//
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = currentValue;
		}
	}
}
