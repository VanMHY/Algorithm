package sort;
//��������
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {-9,78,0,23,-567,70,-1,900};
		quicksort(arr, 0, arr.length-1);
		System.out.println("arr=" + Arrays.toString(arr));
	}
	public static void quicksort(int[] arr, int left, int right) {
		int l = left;//���±�
		int r = right;//���±�
		int pivot = arr[(left + right)/2];//����ֵ
		int temp = 0;//��ʱ����������ʹ��
		while(l < r) {//�ñ�pivotС�ķ���ߣ���pivot��ķ��ұ�
			while(arr[l] < pivot) {//��pivot���һֱ�ң��ҵ���pivot��Ļ�Ȳ��˳�
				l += 1;
			}
			while(arr[r] > pivot) {//��pivot�ұ�һֱ�ң��ҵ���pivotС�Ļ�Ȳ��˳�
				r -= 1;
			}
			if( l >= r) {//���l >= r,˵��pivot���������ߵ�ֵ�Ѿ������ȫС��pivot���ұ�ȫ����pivot����
				break;
			}
			//����
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			if(arr[l] == pivot) {//�����������arr[l]==pivot,r--,ǰ��
				r -= 1;
			}
			if(arr[r] == pivot) {//�����������arr[r]==pivot,l++,����
				l += 1;
			}
			//���l==r������l++��r--������ջ���
			if(l == r) {
				l += 1;
				r -= 1;
			}
			//��ݹ�
			if(left < r) {
				quicksort(arr, left, r);
			}
			//�ҵݹ�
			if(right > l) {
			quicksort(arr, l, right);
			}
		}
	}

}
