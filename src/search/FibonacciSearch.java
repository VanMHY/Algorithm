package search;

import java.util.Arrays;

public class FibonacciSearch {
	
	public static int maxSize = 20;

	public static void main(String[] args) {
		int[] arr = {1, 8, 10, 89, 1000,1234 };
		System.out.println("index=" + fibSeardh(arr, 1234));
	}
	//������Ҫʹ�õ�쳲��������У������Ȼ�ȡһ��
	public static int[] fib() {// �ǵݹ鷽ʽ
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}
	//��д쳲����������㷨
	//ʹ�÷ǵݹ鷽��
	/**
	 * 
	 * @param a ����
	 * @param key ��Ҫ�ҵĹؼ��루ֵ��
	 * @return �ҵ������±꣬δ�ҵ�����-1
	 */
	public static int fibSeardh(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		int k = 0;//��ʾ쳲������ָ���ֵ
		int mid = 0;//���midֵ
		int f[] = fib();//��ȡ쳲���������
		//��ȡ��쳲������ָ�ֵ���±�
		while(high > f[k] - 1) {
			k++;
		}
		//��Ϊ��f[k]ֵ���ܴ���a�ĳ��ȣ�������Ҫʹ��Arrays�࣬����һ���µ����飬��ָ��a[]
		//����Ĳ��ֻ���0���
		int[] temp = Arrays.copyOf(a, f[k]);
		//��Ҫʹ��a�������һ���������temp����
		for(int i = high + 1; i < temp.length; i++) {
			temp[i] = a[high];
		}
		//ʹ��ѭ��������
		while(low <= high) {//ֻҪ����������㣬�Ϳ�����
			mid = low + f[k ] - 1;
			if(key < temp[mid]) {//��������߲���
				high = mid - 1;
				k--;//��f[k-1]ǰ���������
			}else if(key > temp[mid]){//�������ұ߲���
				low = mid + 1;
				k -= 2;//�����������
			}else {//�ҵ�
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
