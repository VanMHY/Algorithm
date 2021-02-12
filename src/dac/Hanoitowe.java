package dac;
//分治算法

public class Hanoitowe {

	public static void main(String[] args) {
		hanoiTowe(5, 'A','B', 'C');
	}
	//汉诺塔的移动方法	使用分治算法
	public static void hanoiTowe(int num, char a, char b, char c) {
		//如果只有一个盘
		if(num == 1) {
			System.out.println("第1个盘从 " + a + "->" + c);
		}else {//如果有n>=2的情况  总是可以看成是两个盘1.最下边的一个盘2.上面所有的盘
			//1.先把上面所有的盘a->b,移动过程会使用到c
			hanoiTowe(num - 1, a, c, b);
			//2.把最下边的盘a->c
			System.out.println("第" + num +"个盘从 " + a + "->" + c);
			//把塔的所有的盘移动到c盘， 移动过程使用到a塔
			hanoiTowe(num - 1, b, a, c);	
			
		}
	}

}
