package sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		//shellSort(arr);
		shellSort2(arr);
		
	}
	//shell排序
	//插入用的是交换法
	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				// 遍历各组之间的元素（共gap组），步长为gap
				for (int j = i - gap; j >= 0; j -= gap) {
					// 如果当前元素大于加上步长后的元素，需要交换
					if (arr[j] > arr[j + gap]) {// 交换
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			System.out.println("希尔排序" + (++count) + "轮后=" + Arrays.toString(arr));
		}
	}
	//对交换法进行优化->移位法
	public static void shellSort2(int[] arr) {
		//增量gap，并逐步缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素，逐个对其进行插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						//移动
						arr[j] = arr[j - gap];
						j -= gap;
					}
					//退出while，就找到了temp的位置
					arr[j] = temp;
				}
			}
		}
		System.out.println("希尔排序轮后=" + Arrays.toString(arr));
	}

}
