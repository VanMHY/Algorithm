package recursion;
//递归算法

public class MiGong {

	public static void main(String[] args) {
		//创建一个二维数组，模拟迷宫
		int[][] map = new int[8][7];//地图
		for(int i = 0; i < 7; i ++) {
			map[0][i] = 1;//1表示墙，上下全部置为一
			map[7][i] = 1;	
		}
		for(int i = 0; i < 8; i ++) {
			map[i][0] = 1;//左右置为一
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		System.out.println("地图的情况");//输出地图
		for(int i = 0; i < 8; i ++) {
			for(int j = 0; j < 7; j ++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		//使用递归回溯给小球找路
		setWay(map, 1, 1);
		//输出新地图，小球走过并标识过的地图
		System.out.println("小球走过并标识过的地图的情况");//输出地图
		for(int i = 0; i < 8; i ++) {
			for(int j = 0; j < 7; j ++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	//使用递归回溯来给小球找路
	//说明：
	//1.map表示地图
	//2.i，j表示从地图的哪个位置出发（1，1）
	//3.如果小球能到位置（6，5），则说明通路找到
	//4.约定：当map[i][j]为0表示该点没有走过 1表示墙；2表示通路  可以走 3表示走过 不通
	//5.在走迷宫时，需要一个策略下->右->上->左，如果该点走不通，则回溯
	public static boolean setWay(int[][] map, int i, int j) {
		if(map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j] == 0) {//如果当前点还没有走过
				//按照策略走
				map[i][j] = 2;//该点可以通过
				if(setWay(map, i+1, j)) {//向下走
					return true;
				}else if(setWay(map, i, j+1)){//向右走
					return true;
				}else if(setWay(map, i-1, j)){//向上走
					return true;
				}else if(setWay(map, i, j-1)){//向左走
					return true;
				}else {
					//该点走不通，是死路
					map[i][j] = 3;
					return false;
				}
			}else {//如果map[i][j]!=0,可能是1，2，3
				return false;
			}
		}
		
	}
	//修改策略又会怎样呢？

}
