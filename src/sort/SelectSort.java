package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {
		//int [] arr = {101, 34 , 119 , 1};
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random()*80000);//生成[0~80000）的随机数
		}
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间=" + date1Str);
		selectSort(arr);
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间=" + date2Str);
		//排序前
//		System.out.println("排序前~~");
//		System.out.println(Arrays.toString(arr));
//		selectSort(arr);
//		System.out.println("排序后~~");
//		System.out.println(Arrays.toString(arr));
	}
	//选择排序时间复杂度n^2
	public static void selectSort(int[] arr) {
		//第i轮
		for (int i = 0; i < arr.length; i++) {

			int minIndex = i;
			int min = arr[minIndex];
			for (int j = 0 + i; j < arr.length; j++) {
				if (min > arr[j]) {// 说明假定的最小值，并不是最小
					min = arr[j];// 重置min
					minIndex = j;// 重置minIndex
				}
			}
			// 交换
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
			//System.out.println("第" + (i + 1) + "轮后~~");
			//System.out.println(Arrays.toString(arr));
		}
	}

}
