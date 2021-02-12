package sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = {53, 3, 542, 748, 14, 214};
		radixSort(arr);
	}
	//�������򷽷�
	public static void radixSort(int[] arr) {
		//�õ����ĵ�����λ��
		int max = arr[0];//�����һ��Ϊ����
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		//�õ�������Ǽ�λ��
		int maxLength = ("" + max).length();
		//��һ���������ÿ������ĸ�λ����)
		//����һ����ά���飬��ʾ10��Ͱ��ÿ��Ͱ��һ��һά����
		//��ֹ�������,���͵Ŀռ任ʱ��
		int[][] bucket = new int[10][arr.length];
		//��¼Ͱ�����ݣ�����һ��һά��������¼ÿ��Ͱÿ�ηŵ����ݸ���
		int[] bucketElementCounts = new int[10];
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			for (int j = 0; j < arr.length; j++) {
				// ȡ��ÿ��Ԫ�ض�Ӧλֵ
				int digitOfElement = arr[j] / n % 10;
				// ���뵽��Ӧ��Ͱ
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			// ����Ͱ��˳�򣬷��뵽ԭ������
			int index = 0;
			// ����ÿ��Ͱ������ÿ���������η��뵽ԭ����
			for (int k = 0; k < bucketElementCounts.length; k++) {
				// ���Ͱ�������ݣ����ǲŷ��뵽ԭ����
				if (bucketElementCounts[k] != 0) {
					// ѭ����Ͱ�������ݷ���
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						// ȡ��Ԫ�ط��뵽arr
						arr[index++] = bucket[k][l];
					}
				}
				// �����Ҫ��bucketElementCounts[k] = 0
				bucketElementCounts[k] = 0;
			}
			System.out.println("��" + (i + 1) + "�֣��Ը�λ���Ĵ���arr=" + Arrays.toString(arr));
		}
	}

}
