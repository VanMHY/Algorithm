package sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 1};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	//插入排序
	public static void insertSort(int[] arr) {
		for(int i = 1; i < arr.length; i ++) {
			int insertVal = arr[i];//定义待插入的数
			int insertIndex = i-1;//待插入前一个数的下标
			//insertIndex >= 0保证找位置不越界
			//insertVal < arr[insertIndex还没有找到位置，需要将arr[insertIndex]后移
			while(insertIndex >= 0 && insertVal < arr[insertIndex]) {//给insertVal找插入位置
				arr[insertIndex + 1] = arr[insertIndex];//后移
				insertIndex --;//退出while
				}
			arr[insertIndex+1] = insertVal;
			//System.out.println("第"+ i +"轮插入");
			//System.out.println(Arrays.toString(arr));
			}
		}
		
}


