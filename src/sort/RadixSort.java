package sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = {53, 3, 542, 748, 14, 214};
		radixSort(arr);
	}
	//基数排序方法
	public static void radixSort(int[] arr) {
		//得到最大的的数的位数
		int max = arr[0];//假设第一个为最大的
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		//得到最大数是几位数
		int maxLength = ("" + max).length();
		//第一轮排序（针对每个排序的个位进行)
		//定义一个二维数组，表示10个桶，每个桶是一个一维数组
		//防止数据溢出,典型的空间换时间
		int[][] bucket = new int[10][arr.length];
		//记录桶中数据，定义一个一维数组来记录每个桶每次放的数据个数
		int[] bucketElementCounts = new int[10];
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			for (int j = 0; j < arr.length; j++) {
				// 取出每个元素对应位值
				int digitOfElement = arr[j] / n % 10;
				// 放入到对应的桶
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			// 按照桶的顺序，放入到原理数组
			int index = 0;
			// 遍历每个桶，并将每个数据依次放入到原数组
			for (int k = 0; k < bucketElementCounts.length; k++) {
				// 如果桶中有数据，我们才放入到原数组
				if (bucketElementCounts[k] != 0) {
					// 循环该桶，将数据放入
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						// 取出元素放入到arr
						arr[index++] = bucket[k][l];
					}
				}
				// 处理后要将bucketElementCounts[k] = 0
				bucketElementCounts[k] = 0;
			}
			System.out.println("第" + (i + 1) + "轮，对个位数的处理arr=" + Arrays.toString(arr));
		}
	}

}
