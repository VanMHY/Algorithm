package sort;

import java.util.Arrays;

public class MergetSort {

	public static void main(String[] args) {
		int arr[] = {8,4,5,7,1,3,6,2};
		int temp[] = new int[arr.length];//�ж���ռ�����
		mergeSort(arr, 0, arr.length -1, temp);
		System.out.println("�鲢�����="+Arrays.toString(arr));
	}
	//��+�Ϸ���
	public static void mergeSort(int[] arr,int left, int right, int[] temp) {
		if(left < right) {
			int mid =( left + right)/2;//�м�����
			//����ݹ�ֽ�
			mergeSort( arr, left, mid, temp);
			//���ҵݹ�ֽ�
			mergeSort( arr, mid + 1, right, temp);
			//�ϲ�
			merge(arr, left, mid, right, temp);
			
		
		}

	}
	//�ϲ�����
	public static void merge(int[] arr,int left, int mid, int right, int[] temp) {
		int i = left;//��ʼ��i������������еĳ�ʼ����
		int j = mid+1;//��ʼ��j���ұ��������еĳ�ʼ����
		int t = 0;//ָ��temp����ĵ�ǰ����
		//���Ȱ�����������������ݰ��չ�����䵽temp���飬ֱ���������ߵ�����������һ�ߴ�����Ϊֹ
		while(i <= mid && j <= right) {//����
			if(arr[i] <= arr[j]) {//������С�ڻ�����ұߣ��������䵽temp
				temp[t] = arr[i];
				t+=1;
				i+=1;
			}else {
				temp[t] = arr[j];//����ұ�С�ڻ������ߣ����ұ���䵽temp
				t+=1;
				j+=1;
			}
		}
		//�ڰ�ʣ������һ�ߵ���������ȫ����䵽temp����
		while(i<=mid) {//��ߵ��������л���ʣ��Ԫ�أ�����䵽temp��
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}
		while(j<=right) {//�ұߵ��������л���ʣ��Ԫ�أ�����䵽temp��
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		//�۽�temp������Ԫ����䵽arr������ÿ�ζ�Ҫ����
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}
	}

}
