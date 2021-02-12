package sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 1};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	//��������
	public static void insertSort(int[] arr) {
		for(int i = 1; i < arr.length; i ++) {
			int insertVal = arr[i];//������������
			int insertIndex = i-1;//������ǰһ�������±�
			//insertIndex >= 0��֤��λ�ò�Խ��
			//insertVal < arr[insertIndex��û���ҵ�λ�ã���Ҫ��arr[insertIndex]����
			while(insertIndex >= 0 && insertVal < arr[insertIndex]) {//��insertVal�Ҳ���λ��
				arr[insertIndex + 1] = arr[insertIndex];//����
				insertIndex --;//�˳�while
				}
			arr[insertIndex+1] = insertVal;
			//System.out.println("��"+ i +"�ֲ���");
			//System.out.println(Arrays.toString(arr));
			}
		}
		
}


