package dynimic;
//��̬�滮�㷨

public class KnapsackProblem {

	public static void main(String[] args) {
		int[] w = {1, 4, 3};//��Ʒ������
		int[] val = {1500, 3000, 2000};//��Ʒ�ļ�ֵ
		int m = 4;//��������
		int n = val.length;//��Ʒ����
		//����һ����ά���飬v[i][j]��ʾ��ǰһ����Ʒ���ܹ�װ������Ϊj�ı����е�����ֵ
		int[][] v = new int[n + 1][m + 1];
		//��¼������Ʒ���������һ����ά����
		int[][] path = new int[n + 1][m + 1];
		//��ʼ����һ�е�һ�У��ڱ������п��Բ�������ΪĬ��Ϊ0
		for(int i = 0; i < v.length; i++) {
			v[i][0] = 0;//����һ������Ϊ0
		}
		for(int i = 0; i < v[0].length; i++) {
			v[0][i] = 0;//����һ������Ϊ0
		}
		//���ݹ�ʽ��̬�滮����
		for(int i = 1; i < v.length; i++) {//�������һ�� i��1��ʼ
			for(int j = 1; j < v[0].length; j++) {//�������һ�� j��1��ʼ
				//��ʽ
				if(w[i-1]>j) {//��Ϊi��1��ʼ
					v[i][j] = v[i-1][j];
				}else {//��Ϊi��1��ʼ
					//v[i][j] = Math.max(v[i-1][j], val[i-1] + v[i-1][j-w[i-1]]);
					//Ϊ�˼�¼��Ʒ�ŵ����������������ֱ��ʹ�ü򵥵Ĺ�ʽ����Ҫʹ�õ�if-else������
					if(v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]]) {
						v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
						//�ѵ�ǰ�����¼��path
						path[i][j] = 1;
					}else {
						v[i][j] = v[i-1][j];
					}
				}
			}
		}
		//�������v ��ǰ���
		for(int i = 0; i < v.length; i++) {
			for(int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=========================");
		//������������Ʒ
		//����path,����������а����еķ���������õ�����ʵֻ��Ҫ���ķ���
//		for(int i = 0; i < path.length; i++) {
//			for(int j = 0; j < path[i].length; j++) {
//				if(path[i][j] == 1) {
//					System.out.printf("��%d����Ʒ���뱳��\n",i);
//				}	
//			}
//		}
		int i = path.length - 1;//�е�����±�
		int j = path[0].length - 1;//�е�����±�
		while(i > 0 && j > 0) {//��path�����ʼ��
			if(path[i][j] == 1) {
				System.out.printf("��%d����Ʒ���뱳��\n",i);
				j -= w[i-1];
			} 
			i--;
		}
		
	}
	
}
