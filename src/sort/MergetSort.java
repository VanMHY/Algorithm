package sort;

import java.util.Arrays;

public class MergetSort {

	public static void main(String[] args) {
		int arr[] = {8,4,5,7,1,3,6,2};
		int temp[] = new int[arr.length];//有额外空间消耗
		mergeSort(arr, 0, arr.length -1, temp);
		System.out.println("归并排序后="+Arrays.toString(arr));
	}
	//分+合方法
	public static void mergeSort(int[] arr,int left, int right, int[] temp) {
		if(left < right) {
			int mid =( left + right)/2;//中间索引
			//向左递归分解
			mergeSort( arr, left, mid, temp);
			//向右递归分解
			mergeSort( arr, mid + 1, right, temp);
			//合并
			merge(arr, left, mid, right, temp);
			
		
		}

	}
	//合并方法
	public static void merge(int[] arr,int left, int mid, int right, int[] temp) {
		int i = left;//初始化i，左边有序序列的初始索引
		int j = mid+1;//初始化j，右边有序序列的初始索引
		int t = 0;//指向temp数组的当前索引
		//①先把左右两边有序的数据按照规则填充到temp数组，直到左右两边的有序序列有一边处理完为止
		while(i <= mid && j <= right) {//继续
			if(arr[i] <= arr[j]) {//如果左边小于或等于右边，将左边填充到temp
				temp[t] = arr[i];
				t+=1;
				i+=1;
			}else {
				temp[t] = arr[j];//如果右边小于或等于左边，将右边填充到temp
				t+=1;
				j+=1;
			}
		}
		//②把剩余数据一边的数据依次全部填充到temp数组
		while(i<=mid) {//左边的有序序列还有剩余元素，就填充到temp！
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}
		while(j<=right) {//右边的有序序列还有剩余元素，就填充到temp！
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		//③将temp中数组元素填充到arr，不是每次都要拷贝
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}
	}

}
