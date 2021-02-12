package recursion;

public class Queue8 {
	//定义一个max表示一共有多少个皇后
	int max = 8;
	//定义一个数组array，保存皇后放置的结果；比如arr={0，4，7，5，2，6，1，3}
	int[] array = new int[max];
	static int count = 0;
	public static void main(String[] args) {
		//测试一把，看8皇后是否有问题
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("一共有%d解法",count);
	}
	//编写一个方法，放置第n个皇后
	//特别注意：check是	每一次递归时，进入到check中都有一套for(int i = 0; i < max; i++)，因此会有回溯
	private void check(int n) {
		if(n == max) {//n=8,8个皇后已经放好
			print();
			return;
		}
		//依次放入皇后，并判断是否冲突
		for(int i = 0; i < max; i++) {
			//先把当前皇后n，放到第1列
			array[n] = i;
			//判断当放置第n个皇后到i列时，是否冲突
			if(judge(n)) {//不冲突
				//接着放第n+1个皇后，即开始递归
				check(n+1);
			}
			//如果冲突就继续执行array[n]=i;	即将第n个皇后，放置在本行的后移一个位置
		}
	}
	
	//查看当摆放第n个皇后时，检测与前一个皇后是否冲突
	private boolean judge(int n) {//表示放第你个皇后
		for(int i = 0; i < n; i++) {
			//说明
			//1.array[i] == array[n] 表示第n个皇后与前n-1个皇后是否在同一列
			//2. Math.abs(n - i) == Math.abs(array[n]) - array[i]表示判断地n个皇后与第i个皇后是否在同一斜线
			//3.是否在同一行，没不要判断，n会递增表示行不可能在同一行
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {//不好理解？拿值试试
				return false;
			}
		}
		return true;
	}
	//写一个方法，可以将皇后摆放的位置输出
	private void print() {
		count++;
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
