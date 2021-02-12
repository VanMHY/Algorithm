package kmp;

public class ViolenceMatch {

	public static void main(String[] args) {
		//����
		String str1 = "";
		String str2 = "";
		int index = violenceMatch(str1, str2);
		System.out.println("index=" +index);
	}
	//����ƥ���㷨
	public static int violenceMatch(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int s1Len = s1.length;
		int s2Len = s2.length;
		int i = 0;//i ָ��s1
		int j = 0;//j ָ��s2
		while(i < s1Len && j < s2Len) {//��֤ƥ�䲻Խ��
			if(s1[i] == s2[j]) {//ƥ��ok
				i++;
				j++;
			}else {//û��ƥ��ɹ�
				i = i - (j -1);
				j = 0;
			}
		}
		//�ж��Ƿ�ƥ��ɹ�
		if(j == s2Len) {
			return i - j;
		}else {
			return -1;
		}
	}
}
