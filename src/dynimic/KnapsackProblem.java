package dynimic;
//动态规划算法

public class KnapsackProblem {

	public static void main(String[] args) {
		int[] w = {1, 4, 3};//物品的重量
		int[] val = {1500, 3000, 2000};//物品的价值
		int m = 4;//背包容量
		int n = val.length;//物品个数
		//创建一个二维数组，v[i][j]表示在前一个物品中能够装入容量为j的背包中的最大价值
		int[][] v = new int[n + 1][m + 1];
		//记录放入商品情况，设置一个二维数组
		int[][] path = new int[n + 1][m + 1];
		//初始化第一行第一列，在本程序中可以不处理，因为默认为0
		for(int i = 0; i < v.length; i++) {
			v[i][0] = 0;//将第一列设置为0
		}
		for(int i = 0; i < v[0].length; i++) {
			v[0][i] = 0;//将第一列设置为0
		}
		//根据公式动态规划处理
		for(int i = 1; i < v.length; i++) {//不处理第一行 i从1开始
			for(int j = 1; j < v[0].length; j++) {//不处理第一列 j从1开始
				//公式
				if(w[i-1]>j) {//因为i从1开始
					v[i][j] = v[i-1][j];
				}else {//因为i从1开始
					//v[i][j] = Math.max(v[i-1][j], val[i-1] + v[i-1][j-w[i-1]]);
					//为了记录商品放到背包的情况，不能直接使用简单的公式，需要使用到if-else来处理
					if(v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]]) {
						v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
						//把当前情况记录到path
						path[i][j] = 1;
					}else {
						v[i][j] = v[i-1][j];
					}
				}
			}
		}
		//输出看看v 当前情况
		for(int i = 0; i < v.length; i++) {
			for(int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=========================");
		//输出最后放入的商品
		//遍历path,这样输出会有把所有的放入情况都得到，其实只需要最后的放入
//		for(int i = 0; i < path.length; i++) {
//			for(int j = 0; j < path[i].length; j++) {
//				if(path[i][j] == 1) {
//					System.out.printf("第%d个商品放入背包\n",i);
//				}	
//			}
//		}
		int i = path.length - 1;//行的最大下标
		int j = path[0].length - 1;//列的最大下标
		while(i > 0 && j > 0) {//从path的最后开始找
			if(path[i][j] == 1) {
				System.out.printf("第%d个商品放入背包\n",i);
				j -= w[i-1];
			} 
			i--;
		}
		
	}
	
}
