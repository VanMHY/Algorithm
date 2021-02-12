package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

	public static void main(String[] args) {
		//int arr[] = {3, 9, -1, 10, 20};
//		System.out.println("����ǰ");
//		System.out.println(Arrays.toString(arr));
		//�����ٶȣ���80000������
		//����80000���������
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random()*80000);//����[0~80000���������
		}
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ��=" + date1Str);
		bubbleSort(arr);
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ��=" + date2Str);
//		System.out.println("�����");
//		System.out.println(Arrays.toString(arr));
	}
	//��i�����򣬾��ǽ���i��������ں�
	//ʱ�临�Ӷ�n^2
	public static void bubbleSort(int arr[]) {
		int temp = 0;//��ʱ����
		boolean flag = false;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length -1 - i; j++) {
				//����������С���򽻻�
				if(arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			//System.out.println("��" + (i+1) + "������������");
			//System.out.println(Arrays.toString(arr));
			if(!flag) {//�����һ��ѭ���У�һ��û�з���
				break;
			}else {
				flag = false;//����flag��������һ��ѭ��
			}
		}
	}

}