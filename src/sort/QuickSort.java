package sort;
//快速排序
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {-9,78,0,23,-567,70,-1,900};
		quicksort(arr, 0, arr.length-1);
		System.out.println("arr=" + Arrays.toString(arr));
	}
	public static void quicksort(int[] arr, int left, int right) {
		int l = left;//左下标
		int r = right;//右下标
		int pivot = arr[(left + right)/2];//中轴值
		int temp = 0;//临时变量，交换使用
		while(l < r) {//让比pivot小的放左边；比pivot大的放右边
			while(arr[l] < pivot) {//在pivot左边一直找，找到比pivot大的或等才退出
				l += 1;
			}
			while(arr[r] > pivot) {//在pivot右边一直找，找到比pivot小的或等才退出
				r -= 1;
			}
			if( l >= r) {//如果l >= r,说明pivot的左右两边的值已经按左边全小于pivot，右边全大于pivot排列
				break;
			}
			//交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			if(arr[l] == pivot) {//如果交换后发现arr[l]==pivot,r--,前移
				r -= 1;
			}
			if(arr[r] == pivot) {//如果交换后发现arr[r]==pivot,l++,后移
				l += 1;
			}
			//如果l==r，必须l++，r--，否则栈溢出
			if(l == r) {
				l += 1;
				r -= 1;
			}
			//左递归
			if(left < r) {
				quicksort(arr, left, r);
			}
			//右递归
			if(right > l) {
			quicksort(arr, l, right);
			}
		}
	}

}
