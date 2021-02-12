package recursion;

public class Queue8 {
	//����һ��max��ʾһ���ж��ٸ��ʺ�
	int max = 8;
	//����һ������array������ʺ���õĽ��������arr={0��4��7��5��2��6��1��3}
	int[] array = new int[max];
	static int count = 0;
	public static void main(String[] args) {
		//����һ�ѣ���8�ʺ��Ƿ�������
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("һ����%d�ⷨ",count);
	}
	//��дһ�����������õ�n���ʺ�
	//�ر�ע�⣺check��	ÿһ�εݹ�ʱ�����뵽check�ж���һ��for(int i = 0; i < max; i++)����˻��л���
	private void check(int n) {
		if(n == max) {//n=8,8���ʺ��Ѿ��ź�
			print();
			return;
		}
		//���η���ʺ󣬲��ж��Ƿ��ͻ
		for(int i = 0; i < max; i++) {
			//�Ȱѵ�ǰ�ʺ�n���ŵ���1��
			array[n] = i;
			//�жϵ����õ�n���ʺ�i��ʱ���Ƿ��ͻ
			if(judge(n)) {//����ͻ
				//���ŷŵ�n+1���ʺ󣬼���ʼ�ݹ�
				check(n+1);
			}
			//�����ͻ�ͼ���ִ��array[n]=i;	������n���ʺ󣬷����ڱ��еĺ���һ��λ��
		}
	}
	
	//�鿴���ڷŵ�n���ʺ�ʱ�������ǰһ���ʺ��Ƿ��ͻ
	private boolean judge(int n) {//��ʾ�ŵ�����ʺ�
		for(int i = 0; i < n; i++) {
			//˵��
			//1.array[i] == array[n] ��ʾ��n���ʺ���ǰn-1���ʺ��Ƿ���ͬһ��
			//2. Math.abs(n - i) == Math.abs(array[n]) - array[i]��ʾ�жϵ�n���ʺ����i���ʺ��Ƿ���ͬһб��
			//3.�Ƿ���ͬһ�У�û��Ҫ�жϣ�n�������ʾ�в�������ͬһ��
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {//������⣿��ֵ����
				return false;
			}
		}
		return true;
	}
	//дһ�����������Խ��ʺ�ڷŵ�λ�����
	private void print() {
		count++;
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
