package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

	public static void main(String[] args) {
		//int arr[] = {3, 9, -1, 10, 20};
//		System.out.println("排序前");
//		System.out.println(Arrays.toString(arr));
		//测试速度，给80000个数据
		//创建80000个随机数据
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random()*80000);//生成[0~80000）的随机数
		}
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间=" + date1Str);
		bubbleSort(arr);
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间=" + date2Str);
//		System.out.println("排序后");
//		System.out.println(Arrays.toString(arr));
	}
	//第i趟排序，就是将第i大的数排在后
	//时间复杂度n^2
	public static void bubbleSort(int arr[]) {
		int temp = 0;//临时变量
		boolean flag = false;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length -1 - i; j++) {
				//如果后面的数小，则交换
				if(arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			//System.out.println("第" + (i+1) + "趟排序后的数组");
			//System.out.println(Arrays.toString(arr));
			if(!flag) {//如果在一趟循环中，一都没有发生
				break;
			}else {
				flag = false;//重置flag；进行下一次循环
			}
		}
	}

}
