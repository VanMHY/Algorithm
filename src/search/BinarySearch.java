package search;

import java.util.ArrayList;
import java.util.List;

//���ֲ��ҵ�����������򣡣���
public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 1, 8, 10, 89, 1000, 1000, 1000, 1234 };
		//int resIndex = binarySearch(arr, 0, arr.length-1, 1);
		//stem.out.println("resIndex="+ resIndex);
		List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
		System.out.println("resIndexList=" + resIndexList);
	}
	//���ֲ����㷨
	/**
	 * 
	 * @param arr ����
	 * @param left �������
	 * @param right �ұ�����
	 * @param findVal Ҫ���ҵ�ֵ
	 * @return�ҵ������±꣬û���ҵ�����-1
	 */
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		//��left > rightʱ��˵���ݹ������û���ҵ�
		if(left > right) {
			return -1;
		}
		int mid = (left + right)/2;
		int midVal = arr[mid];
		if(findVal > midVal) {//�ҵݹ�
			return binarySearch(arr, mid + 1, right, findVal);
		}else if(findVal < midVal){
			return binarySearch(arr, left, mid - 1, findVal);
		}else {
			return mid;
		}
	}

	public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
		// ��left > rightʱ��˵���ݹ������û���ҵ�
		if (left > right) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (findVal > midVal) {// �ҵݹ�
			return binarySearch2(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) {
			return binarySearch2(arr, left, mid - 1, findVal);
		} else {
			// �� ���ҵ�mid����ֵ,��Ҫ���Ϸ���
			List<Integer> resIndexlist = new ArrayList<Integer>();
			// ��mid����ֵ�����ɨ�裬����������1000����Ԫ�ص��±꣬���뵽����ArrayList
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != findVal) {// �˳�
					break;
				}
				// ���򣬾�temp���뵽resIndexlist
				resIndexlist.add(temp);
				temp -= 1;// temp����
			}
			resIndexlist.add(mid);
			// ��mid����ֵ���ұ�ɨ�裬����������1000����Ԫ�ص��±꣬���뵽����ArrayList
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || arr[temp] != findVal) {// �˳�
					break;
				}
				// ���򣬾�temp���뵽resIndexlist
				resIndexlist.add(temp);
				temp += 1;// temp����
			}
			return resIndexlist;
		}
	}
}
