package com.kesen.search;

/**
 * @Auther: kesen
 * @Date: 2020/4/12 19:52
 * @Description:
 **/
public class BSearchX {

	/**
	 * 变体一：查找第一个值等于给定值的元素
	 *
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int searchFirstEq(int arr[], int value) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) >> 1;
			if (arr[mid] > value) {
				right = mid - 1;
			} else if (arr[mid] < value) {
				left = mid + 1;
			} else {
				if (mid == 0 || arr[mid - 1] != value) return mid;
				else right = mid - 1;
			}
		}
		return -1;
	}

	/**
	** 
	* @Description:  变体二：查找最后一个值等于给定值的元素
	* @Param: [arr, value] 
	* @return: int 
	* @Author: kesen
	* @Date: 2020/4/12 20:10 
	*/ 
	public int searchLastEq(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] > value) {
				right = mid - 1;
			} else if (arr[mid] < value) {
				left = mid + 1;
			} else {
				if ((mid == arr.length - 1) || (arr[mid + 1] != value)) return mid;
				else left = mid + 1;
			}
		}
		return -1;
	}
}
