package sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		//shellSort(arr);
		shellSort2(arr);
		
	}
	//shell����
	//�����õ��ǽ�����
	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				// ��������֮���Ԫ�أ���gap�飩������Ϊgap
				for (int j = i - gap; j >= 0; j -= gap) {
					// �����ǰԪ�ش��ڼ��ϲ������Ԫ�أ���Ҫ����
					if (arr[j] > arr[j + gap]) {// ����
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			System.out.println("ϣ������" + (++count) + "�ֺ�=" + Arrays.toString(arr));
		}
	}
	//�Խ����������Ż�->��λ��
	public static void shellSort2(int[] arr) {
		//����gap��������С����
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// �ӵ�gap��Ԫ�أ����������в�������
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						//�ƶ�
						arr[j] = arr[j - gap];
						j -= gap;
					}
					//�˳�while�����ҵ���temp��λ��
					arr[j] = temp;
				}
			}
		}
		System.out.println("ϣ�������ֺ�=" + Arrays.toString(arr));
	}

}
