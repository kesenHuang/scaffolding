package com.kesen.search;

/**
 * @Auther: kesen
 * 二分法查找：
 * 二分查找应用场景的局限性：
 * 1、依赖的是顺序表结构，简单点说就是数组。
 * 2、其次，二分查找针对的是有序数据。
 * 3、再次，数据量太小不适合二分查找
 * 4、最后，数据量太大也不适合二分查找。：二分查找的底层需要依赖数组这种数据结构，而数组为了支持随机访问的特性，要求内存空间连续，对内存的要求比较苛刻。比如，我们有1GB大小的数据，如果希望用数组来存储，那就需要1GB的连续内存空间。
 * @Date: 2020/4/12 19:33
 * @Description:
 **/
public class B2Search {

	public static int search(int arr[], int value) {
		return search(arr, 0, arr.length - 1, value);
	}

	/**
	 * *
	 *
	 * @Description: 循环方式实现
	 * 注意是low<=high，而不是low<high。
	 * 实际上，mid=(low+high)/2这种写法是有问题的。因为如果low和high比较大的话，两者之和就有可能会溢出。改进的方法是将mid的计算方式写成low+(high-low)/2
	 * @Param: [arr, left, right, value]
	 * @return: int
	 * @Author: kesen
	 * @Date: 2020/4/12 19:40
	 */
	private static int search(int arr[], int left, int right, int value) {

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == value) {
				return mid;
			} else if (arr[mid] < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * *
	 *
	 * @Description: 递归方式
	 * @Param: [a, low, high, value]
	 * @return: int
	 * @Author: kesen
	 * @Date: 2020/4/12 19:42
	 */
	private int bsearchInternally(int[] a, int low, int high, int value) {
		if (low > high) return -1;

		int mid = low + ((high - low) >> 1);
		if (a[mid] == value) {
			return mid;
		} else if (a[mid] < value) {
			return bsearchInternally(a, mid + 1, high, value);
		} else {
			return bsearchInternally(a, low, mid - 1, value);
		}
	}
}
