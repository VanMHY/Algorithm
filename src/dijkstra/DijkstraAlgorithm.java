package dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {

	public static void main(String[] args) {
		char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		//邻接矩阵
		int[][] matrix = new int[vertex.length][vertex.length];
		final int N = 65535;//表示不可连接
		matrix[0]=new int[]{N,5,7,N,N,N,2};
		matrix[1]=new int[]{5,N,N,9,N,N,3};
		matrix[2]=new int[]{7,N,N,N,8,N,N};
		matrix[3]=new int[]{N,9,N,N,N,4,N};
		matrix[4]=new int[]{N,N,8,N,N,5,4};
		matrix[5]=new int[]{N,N,N,4,5,N,6};
		matrix[6]=new int[]{2,3,N,N,4,6,N};
		//创建Graph对象
		Graph graph = new Graph(vertex,matrix);
		//测试图
		graph.showGraph();
		//测试迪杰斯特拉算法;控制起点
		graph.dsj(6);
		graph.showDijkstra();
	}

}

class Graph {
	private char[] vertex;// 顶点数组
	private int[][] matrix;// 邻接矩阵
	private VisitedVertes vv;//已经访问的顶点集合
	// 构造器
	public Graph(char[] vertex, int[][] matrix) {
		this.vertex = vertex;
		this.matrix = matrix;
	}
	//显示结果
	public void showDijkstra() {
		vv.show();
	}

	// 显示图的方法
	public void showGraph() {
		for (int[] link : matrix) {
			System.out.println(Arrays.toString(link));
		}
	}
	//迪杰斯特拉算法实现
	/**
	 * 
	 * @param index 表示出发顶点对应的下标
	 */
	public void dsj(int index) {
		vv = new VisitedVertes(vertex.length, index);
		updata(index);//更新index顶点到周围顶点的距离和前驱结点；debug测试
		for(int j = 1; j < vertex.length; j++) {
			index = vv.updataArr();//选择并返回新的访问顶点
			updata(index);//更新index顶点到周围顶点的距离和前驱结点
		}
	}
	//更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
	private void updata(int index) {
		int len = 0;
		//根据遍历邻接矩阵的matrix[index]行
		for(int j = 0; j < matrix[index].length; j++) {
			//len含义是出发顶点到index顶点的距离+从index顶点到j顶点距离的和
			len = vv.getDis(index) + matrix[index][j];
			//如果j结点没用被访问过，并且len小于出发点到j顶点的距离，就需要更新
			if(!vv.in(j) && len < vv.getDis(j)) {
				vv.updataPre(j, index);//更新j顶点的前驱结点为index结点
				vv.updataDis(j, len);//更新出发点到j顶点的距离
			}
		}
	}
}
//已访问顶点集合
class VisitedVertes{
	public int[] already_arr;//记录每个顶点是否被访问；1表示访问；0表示未访问，会动态更新
	public int[] pre_visited;//每个下标对应前一个顶点下标；会动态更新
	public int[] dis;//记录出发点到各点的距离；求得的最短距离放入dis；会动态更新
	//构造器
	/**
	 * 
	 * @param lenght :表示顶点个数
	 * @param index ：出发顶点对应的下标
	 */
	public VisitedVertes(int lenght, int index) {
		this.already_arr = new int[lenght];
		this.pre_visited = new int[lenght];
		this.dis = new int[lenght];
		//初始化，dis数组
		Arrays.fill(dis, 65535);
		this.already_arr[index] = 1;//设置出发顶点被访问过
		this.dis[index] = 0;//设置出发点的访问距离为0
	}
	/**
	 * 功能：判断index顶点是否被访问过
	 * @param index
	 * @return 如果被访问过返回ture，否则返回false
	 */
	public boolean in(int index) {
		return already_arr[index] == 1;
	}
	/**
	 * 功能：更新出发点到index的距离
	 * @param index
	 * @param len
	 */
	public void updataDis(int index, int len) {
		dis[index] = len;
	}
	/**
	 * 功能：更新pre这个顶点的前驱顶点为index结点
	 * @param pre
	 * @param index
	 */
	public void updataPre(int pre, int index) {
		pre_visited[pre] = index;
	}
	/**
	 * 功能：返回出发顶点到index顶点的距离
	 * @param index
	 */
	public int getDis(int index) {
		return dis[index];
	}
	//继续选择并返回新的访问结点，如G完后，就是A作为新的结点(不是出发顶点)
	public int updataArr() {
		int min = 65535, index = 0;
		for(int i = 0; i < already_arr.length; i++) {
			if(already_arr[i] == 0 && dis[i] < min) {
				min = dis[i];
				index = i;
			}
		}
		//更新index顶点被访问过
		already_arr[index] = 1;
		return index;
	}
	//显示最后的结果
	public void show() {
		System.out.println("==========================");
		//输出already_arr
		for(int i : already_arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		//输出pre_visited
		for(int i : pre_visited) {
			System.out.print(i + " ");
		}
		System.out.println();
		//输出dis
		for(int i : dis) {
			System.out.print(i + " ");
		}
		System.out.println();
		//格式化最短距离
		char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int count = 0;
		for(int i : dis) {
			if(i != 65535) {
				System.out.print(vertex[count] + "("+ i +")");
			}else {
				System.out.println("N ");
			}
			count++;
		}
		System.out.println();
	}
}