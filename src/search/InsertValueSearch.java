package search;

import java.util.Arrays;

public class InsertValueSearch {

	public static void main(String[] args) {
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		//System.out.println(Arrays.toString(arr));
		int index = insertValueSearch(arr, 0, arr.length - 1, 100);
		System.out.println("index=" + index);
	}
	//编写插值查找算法
	//插值查找也要求有序
	/**
	 * 
	 * @param arr 数组 	
	 * @param left 左边索引
	 * @param right 右边索引
	 * @param findVal 查找值
	 * @return 如果找到，返回对应下标，没有返回-1
	 * findVal < arr[0]和findVal > arr[arr.length - 1]必须有，否则可能得到mid越界
	 */
	public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
		System.out.println("查找次数~~");
		if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
			return -1;
		}
		//求出mid，自适应
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right]- arr[left]);
		int midVal = arr[mid];
		if(findVal > midVal) {//向右递归
			return insertValueSearch(arr, mid + 1, right, findVal);
		}else if (findVal < midVal) {//向左递归
			return insertValueSearch(arr, left, mid - 1, findVal);
		}else {
			return mid;
		}
	}

}
