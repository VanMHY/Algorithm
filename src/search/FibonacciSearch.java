package search;

import java.util.Arrays;

public class FibonacciSearch {
	
	public static int maxSize = 20;

	public static void main(String[] args) {
		int[] arr = {1, 8, 10, 89, 1000,1234 };
		System.out.println("index=" + fibSeardh(arr, 1234));
	}
	//后面需要使用到斐波那契数列，所有先获取一个
	public static int[] fib() {// 非递归方式
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}
	//编写斐波那契查找算法
	//使用非递归方法
	/**
	 * 
	 * @param a 数组
	 * @param key 需要找的关键码（值）
	 * @return 找到返回下标，未找到返回-1
	 */
	public static int fibSeardh(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		int k = 0;//表示斐波那契分割数值
		int mid = 0;//存放mid值
		int f[] = fib();//获取斐波那契数列
		//获取到斐波那契分割值的下标
		while(high > f[k] - 1) {
			k++;
		}
		//因为发f[k]值可能大于a的长度；所有需要使用Arrays类，构造一个新的数组，并指向a[]
		//不足的部分会用0填充
		int[] temp = Arrays.copyOf(a, f[k]);
		//需要使用a数组最后一个数来填充temp数组
		for(int i = high + 1; i < temp.length; i++) {
			temp[i] = a[high];
		}
		//使用循环来找数
		while(low <= high) {//只要这个条件满足，就可以找
			mid = low + f[k ] - 1;
			if(key < temp[mid]) {//向数组左边查找
				high = mid - 1;
				k--;//向发f[k-1]前面继续查找
			}else if(key > temp[mid]){//向数组右边查找
				low = mid + 1;
				k -= 2;//后面相差两个
			}else {//找到
				if(mid <= high) {
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;
	}
}
