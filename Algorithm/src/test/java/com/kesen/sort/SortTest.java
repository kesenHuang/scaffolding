package com.kesen.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: kesen
 * @Date: 2020/4/1 21:56
 * @Description:
 **/
public class SortTest {
	@Test
	public void insertionTest() {
		int [] arr = new int[] {5,8,1,2,4,7,6,9,3};
		InsertionSort.sort(arr);
		System.out.println(Arrays.toString(arr));
		Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, arr);
	}

	@Test
	public void selectSortTest() {
		int [] arr = new int[] {5,8,1,2,4,7,6,9,3};
		SelectSort.sort(arr);
		System.out.println(Arrays.toString(arr));
		Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, arr);
	}

	@Test
	public void mergeSortTest() {
		int [] arr = new int[] {5,8,1,2,4,7,6,9,3};
		MergeSort.sort(arr);
		System.out.println(Arrays.toString(arr));
		Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, arr);
	}

	@Test
	public void quickSortTest() {
		int [] arr = new int[] {5,8,1,2,4,7,6,9,3};
		QuickSort.sort(arr);
		System.out.println(Arrays.toString(arr));

		Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, arr);
	}
}
