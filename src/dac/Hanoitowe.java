package dac;
//�����㷨

public class Hanoitowe {

	public static void main(String[] args) {
		hanoiTowe(5, 'A','B', 'C');
	}
	//��ŵ�����ƶ�����	ʹ�÷����㷨
	public static void hanoiTowe(int num, char a, char b, char c) {
		//���ֻ��һ����
		if(num == 1) {
			System.out.println("��1���̴� " + a + "->" + c);
		}else {//�����n>=2�����  ���ǿ��Կ�����������1.���±ߵ�һ����2.�������е���
			//1.�Ȱ��������е���a->b,�ƶ����̻�ʹ�õ�c
			hanoiTowe(num - 1, a, c, b);
			//2.�����±ߵ���a->c
			System.out.println("��" + num +"���̴� " + a + "->" + c);
			//���������е����ƶ���c�̣� �ƶ�����ʹ�õ�a��
			hanoiTowe(num - 1, b, a, c);	
			
		}
	}

}
