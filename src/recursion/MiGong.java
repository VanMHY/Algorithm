package recursion;
//�ݹ��㷨

public class MiGong {

	public static void main(String[] args) {
		//����һ����ά���飬ģ���Թ�
		int[][] map = new int[8][7];//��ͼ
		for(int i = 0; i < 7; i ++) {
			map[0][i] = 1;//1��ʾǽ������ȫ����Ϊһ
			map[7][i] = 1;	
		}
		for(int i = 0; i < 8; i ++) {
			map[i][0] = 1;//������Ϊһ
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		System.out.println("��ͼ�����");//�����ͼ
		for(int i = 0; i < 8; i ++) {
			for(int j = 0; j < 7; j ++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		//ʹ�õݹ���ݸ�С����·
		setWay(map, 1, 1);
		//����µ�ͼ��С���߹�����ʶ���ĵ�ͼ
		System.out.println("С���߹�����ʶ���ĵ�ͼ�����");//�����ͼ
		for(int i = 0; i < 8; i ++) {
			for(int j = 0; j < 7; j ++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	//ʹ�õݹ��������С����·
	//˵����
	//1.map��ʾ��ͼ
	//2.i��j��ʾ�ӵ�ͼ���ĸ�λ�ó�����1��1��
	//3.���С���ܵ�λ�ã�6��5������˵��ͨ·�ҵ�
	//4.Լ������map[i][j]Ϊ0��ʾ�õ�û���߹� 1��ʾǽ��2��ʾͨ·  ������ 3��ʾ�߹� ��ͨ
	//5.�����Թ�ʱ����Ҫһ��������->��->��->������õ��߲�ͨ�������
	public static boolean setWay(int[][] map, int i, int j) {
		if(map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j] == 0) {//�����ǰ�㻹û���߹�
				//���ղ�����
				map[i][j] = 2;//�õ����ͨ��
				if(setWay(map, i+1, j)) {//������
					return true;
				}else if(setWay(map, i, j+1)){//������
					return true;
				}else if(setWay(map, i-1, j)){//������
					return true;
				}else if(setWay(map, i, j-1)){//������
					return true;
				}else {
					//�õ��߲�ͨ������·
					map[i][j] = 3;
					return false;
				}
			}else {//���map[i][j]!=0,������1��2��3
				return false;
			}
		}
		
	}
	//�޸Ĳ����ֻ������أ�

}
