package kruskal;

import java.util.Arrays;

public class KruskalCase {
	private int edgeNum;//�ߵĸ���
	private char[] vertexs;//��������
	private int[][] matrix;//�ڽӾ���
	//ʹ��INF��ʾ���㲻����ͨ
	private static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		char[] vertexs = {'A','B','C','D','E','F','G'};
		int matrix[][] = {
				/*A*//*B*//*C*//*D*//*E*//*F*//*G*/
				/*A*/{  0, 12,INF,INF,INF, 16, 14},
				/*B*/{ 12,  0, 10,INF,INF,  7,INF},
				/*C*/{INF, 10,  0,  3,  5,  6,INF},
				/*D*/{INF,INF,  3,  0,  4,INF,INF},
				/*E*/{INF,INF,  5,  4,  0,  2,  8},
				/*F*/{16 ,  7,  6,INF,  2,  0,  9},
				/*G*/{ 14,INF,INF,INF,  8,  9, 0}};
		//����KruskalCase�Ķ���ʵ��
		KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
		//��������Ƿ���ȷ
		kruskalCase.print();
		kruskalCase.kruskal();
		//EData[] edges = kruskalCase.getEdges();
		//System.out.println("xx=" + Arrays.toString(kruskalCase.getEdges()));//û������
		//System.out.println("����ǰ=" + Arrays.toString(edges));//û������
		//kruskalCase.sortEdata(edges);
		//System.out.println("�����=" + Arrays.toString(edges));//û������
		}
	//������
	public KruskalCase(char[] vertexs, int[][] matrix) {
		//��ʼ���������ͱߵĸ���
		int vlen = vertexs.length;
		//��ʼ������,���ƿ����ķ�ʽ
		this.vertexs = new char[vlen];
		for(int i = 0; i < vertexs.length; i++) {
			this.vertexs[i] = vertexs[i];
		}
		//��ʼ����,ʹ�ø��ƿ�����ʽ
		this.matrix = new int[vlen][vlen];
		for(int i = 0; i < vlen; i++) {
			for(int j = 0; j < vlen; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
		//ͳ�Ʊߵ�����
		for(int i = 0; i < vlen; i++) {
			for(int j = i + 1; j < vlen; j++) {
				if(this.matrix[i][j] != INF) {
					edgeNum++;
				}
			}
		}
		
	}
	public void kruskal() {
		int index = 0;//��ʾ����������������
		int[] ends = new int[edgeNum];//���ڱ���"������С������"�е�ÿ����������С�������е��յ�
		//����������飬���� ������С������
		EData[] rets = new EData[edgeNum];
		//��ȡͼ�����бߵļ��ϣ�һ����12����
		EData[] edges = getEdges();
		System.out.println("ͼ�ıߵļ���=" + Arrays.toString(edges) + "��" + edges.length);
		//���ձߵ�Ȩֵ��С�������򣨴Ӵ�С��
		sortEdata(edges);
		//����edges���飬������ӵ���С������ʱ���ж�׼������ı��Ƿ��γɻ�·�����û�оͼ���rets�������ܼ���
		for(int i = 0; i < edgeNum; i++) { 
			//��ȡ����i���ߵĵ�һ������(���)
			int p1 = getPosition(edges[i].start);//p1=4
			//��ȡ����i���ߵĵڶ�������
			int p2 = getPosition(edges[i].end);//p2=5
			//��ȡp1���������������С���������յ�
			int m = getEnd(ends, p1);//m=4
			//��ȡp2���������������С���������յ�
			int n =  getEnd(ends, p2);//n=5
			//�Ƿ��γɻ�·
			if(m != n) {//û�й��ɻ�·
				ends[m] = n;//����m��"������С������"�е��յ�<E,F>[0,0,0,0,0,5,0,0,0,0,0,0]
				rets[index++] = edges[i]; //��һ���߼��뵽rets����
			}
		}
		//ͳ�Ʋ���ӡ"��С������"�����rets����
		System.out.println("��С������Ϊ");
		for(int i = 0; i < index; i++) {
			System.out.println(rets[i]);
		}
		//System.out.println("��С������Ϊ=" + Arrays.toString(rets));
		
	}
	//��ӡ�ڽӾ���
	public void print() {
		System.out.println("�ڽӾ���Ϊ��\n");
		for(int i = 0; i < vertexs.length; i++) {
			for(int j = 0; j < vertexs.length; j++) {
				System.out.printf("%12d\t",matrix[i][j]);
			}
			System.out.println();//����
		}
	}
	//�Ա߽���������ð������
	/**
	 * ���ܣ��Ա߽���������ð������
	 * @param edges �ߵļ���
	 */
	private void sortEdata(EData[] edges) {
		for(int i = 0; i < edges.length - 1; i++) {
			for(int j = 0; j < edges.length - 1 - i; j++) {
				if(edges[j].weight > edges[j + 1].weight) {//����
					EData tmp = edges[j];
					edges[j] = edges[j +1];
					edges[j + 1] = tmp;
				}
			}
		}
	}
	/**
	 * 
	 * @param ch �����ֵ������'A','B'
	 * @return ����ch�����Ӧ���±꣬����Ҳ�������-1
	 */
	private int getPosition(char ch) {
		for(int i = 0; i < vertexs.length; i++) {
			if(vertexs[i] == ch) {//�ҵ�
				return i;
			}
		}
		//�Ҳ�������-1
		return -1;
	}
	/**
	 * ���ܣ���ȡͼ�еı߷ŵ�EData�����У�����Ҫ��������
	 * ͨ��matrix�ڽӾ����ȡ	
	 * EData��ʽ[['A','B',12],['B','F',7],......]
	 * @return
	 */
	private EData[] getEdges(){
		int index = 0;
		EData[] edges = new EData[edgeNum];
		for(int i = 0; i < vertexs.length; i++) {
			for(int j = i + 1; j < vertexs.length; j++) {
				if(matrix[i][j] != INF) {
					edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
				}
			}
		}
		return edges;
	}
	/**
	 * ���ܣ���ȡ�±�Ϊi�Ķ�����յ�()�����ں����ж�����������յ��Ƿ���ͬ
	 * @param ends :������Ǽ�¼�˸��������Ӧ���յ�����һ��������������ڱ��������У����γ� 
	 * @param i ����ʾ����Ķ����Ӧ���±�
	 * @return���صľ��� �±�Ϊi����������Ӧ���յ���±�
	 */
	private int getEnd(int[] ends, int i) {
		while(ends[i] != 0) {
			i = ends[i];
		}
		return i;
	}

}
//����һ����EData�����Ķ���ʵ���ͱ�ʾһ����
class EData{
	char start;//�ߵ����
	char end;//�ߵ�����һ����λ
	int weight;// �ߵ�Ȩֵ
	//������
	public EData(char start, char end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	//��дtoString,���ڱߵ����
	@Override
	public String toString() {
		return "EData [<" + start + "," + end +">=" + weight +"]";
	}
	
}
