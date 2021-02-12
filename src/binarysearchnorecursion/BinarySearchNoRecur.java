package binarysearchnorecursion;

public class BinarySearchNoRecur {

	public static void main(String[] args) {
		//测试
		int[] arr = {1,3,8,10,11,67,100};
		int index = binarySearch(arr, -8);
		System.out.println("index=" + index);
	}
	//二分查找的非递归实现
	/**
	 * 
	 * @param arr  待查找的数组
	 * @param target 需要查找的值
	 * @return 返回下标，没有找到返回-1
	 */
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {//说明继续查找
			int mid = (left + right)/2;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] > target) {
				right = mid -1;//需要向左查找
			}else {
				left = mid + 1;//需要向右查找
			}
		}
		return -1;
	}
}
