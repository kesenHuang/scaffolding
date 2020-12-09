package com.kesen.primary.array;

import java.util.Arrays;

/**
 * @Auther: kesen
 * @Date: 2020/4/21 07:55
 * @Description: 数组复制
 **/
public class ArrayUtils {
	public static void main(String[] args) {
		int a[] = new int[] { 18, 62, 68, 82, 65, 9 };

		// copyOfRange(int[] original, int from, int to)
		// 第一个参数表示源数组
		// 第二个参数表示开始位置(取得到)
		// 第三个参数表示结束位置(取不到)
		int[] b = Arrays.copyOfRange(a, 0, 3);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}


		// sort 排序
		System.out.println("排序之前 :");
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("排序之后:");
		System.out.println(Arrays.toString(a));


		//binarySearch
		//使用binarySearch之前，必须先使用sort进行排序
		System.out.println("数字 62出现的位置:"+Arrays.binarySearch(a, 62));

		//判断是否相同,比较两个数组的内容是否一样
		System.out.println(Arrays.equals(a, b));
	}
}
