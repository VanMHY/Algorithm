package search;

import java.util.ArrayList;
import java.util.List;

//二分查找的数组必须有序！！！
public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 1, 8, 10, 89, 1000, 1000, 1000, 1234 };
		//int resIndex = binarySearch(arr, 0, arr.length-1, 1);
		//stem.out.println("resIndex="+ resIndex);
		List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
		System.out.println("resIndexList=" + resIndexList);
	}
	//二分查找算法
	/**
	 * 
	 * @param arr 数组
	 * @param left 左边索引
	 * @param right 右边索引
	 * @param findVal 要查找的值
	 * @return找到返回下标，没有找到返回-1
	 */
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		//当left > right时，说明递归结束，没有找到
		if(left > right) {
			return -1;
		}
		int mid = (left + right)/2;
		int midVal = arr[mid];
		if(findVal > midVal) {//右递归
			return binarySearch(arr, mid + 1, right, findVal);
		}else if(findVal < midVal){
			return binarySearch(arr, left, mid - 1, findVal);
		}else {
			return mid;
		}
	}

	public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
		// 当left > right时，说明递归结束，没有找到
		if (left > right) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (findVal > midVal) {// 右递归
			return binarySearch2(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) {
			return binarySearch2(arr, left, mid - 1, findVal);
		} else {
			// ① 在找到mid索引值,不要马上返回
			List<Integer> resIndexlist = new ArrayList<Integer>();
			// 向mid索引值的左边扫描，将所有满足1000，的元素的下标，加入到集合ArrayList
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != findVal) {// 退出
					break;
				}
				// 否则，就temp放入到resIndexlist
				resIndexlist.add(temp);
				temp -= 1;// temp左移
			}
			resIndexlist.add(mid);
			// 向mid索引值的右边扫描，将所有满足1000，的元素的下标，加入到集合ArrayList
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || arr[temp] != findVal) {// 退出
					break;
				}
				// 否则，就temp放入到resIndexlist
				resIndexlist.add(temp);
				temp += 1;// temp左移
			}
			return resIndexlist;
		}
	}
}
