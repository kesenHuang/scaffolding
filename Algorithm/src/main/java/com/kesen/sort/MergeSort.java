package com.kesen.sort;

import java.util.Arrays;

/**
 * @Auther: kesen
 * @Date: 2020/4/12 14:49
 * @Description:
 **/
public class MergeSort {

	public static void sort(int[] arr) {
		int[] tmp = new int[arr.length];

		sort(arr, 0, arr.length - 1, tmp);
	}

	private static void sort(int[] arr, int left, int right, int[] tmp) {

		if (left < right) {
			int mid = (right + left) / 2;
			sort(arr, left, mid, tmp);
			sort(arr, mid + 1, right, tmp);
			merge(arr, left, mid, right, tmp);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right, int[] tmp) {

		int i = left;
		int j = mid +1 ;
		int t = 0;
		// 两边都有数据时，进行比较后再放入临时数组
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				tmp[t] = arr[i];
				t++;
				i++;
			} else {
				tmp[t] = arr[j];
				t++;
				j++;
			}
		}
		// 将剩余左边放入临时数组
		while (i<=mid) {
			tmp[t] = arr[i];
			t++;
			i++;
		}
		// 将剩余右边放入临时数组
		while (j<= right) {
			tmp[t] = arr[j];
			t++;
			j++;
		}
		t = 0;
		//将temp中的元素全部拷贝到原数组中
		while(left <= right){
			arr[left++] = tmp[t++];
		}
	}
	public static void main(String []args){
		int []arr = {9,8,7,6,5,4,3,2,1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
