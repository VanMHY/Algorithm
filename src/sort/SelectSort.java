package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {
		//int [] arr = {101, 34 , 119 , 1};
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random()*80000);//����[0~80000���������
		}
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ��=" + date1Str);
		selectSort(arr);
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ��=" + date2Str);
		//����ǰ
//		System.out.println("����ǰ~~");
//		System.out.println(Arrays.toString(arr));
//		selectSort(arr);
//		System.out.println("�����~~");
//		System.out.println(Arrays.toString(arr));
	}
	//ѡ������ʱ�临�Ӷ�n^2
	public static void selectSort(int[] arr) {
		//��i��
		for (int i = 0; i < arr.length; i++) {

			int minIndex = i;
			int min = arr[minIndex];
			for (int j = 0 + i; j < arr.length; j++) {
				if (min > arr[j]) {// ˵���ٶ�����Сֵ����������С
					min = arr[j];// ����min
					minIndex = j;// ����minIndex
				}
			}
			// ����
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
			//System.out.println("��" + (i + 1) + "�ֺ�~~");
			//System.out.println(Arrays.toString(arr));
		}
	}

}
