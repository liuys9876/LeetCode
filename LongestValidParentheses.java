package leetcode;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(()(((()";
		Solution32 solu = new Solution32();
		System.out.println(solu.longestValidParentheses(s));
	}

}

class Solution32 {
	public int longestValidParentheses(String s) {
		int[] temp = charge(s);
		return temp[1];
	}

	/**
	 * 
	 * @param s
	 * @return ����int[] Ϊ ��Ч�ĳ�ʼλ���Ƿ���0λ������Ϊ0������Ϊ1���Լ�����s����Ч���ȣ��Լ���0λ��ʼ����Ч����
	 */
	private int[] charge(String s) {

		int ValidPoint[] = { 0, 0 , 0};
		int left = 0;
		int right = 0;
		int temp_left=0; //��¼left�������ж��Ƿ����䶯
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
				if (right > left) {
					
					if (i < s.length() - 1) {
						ValidPoint[0]=1;
						int[] temp = charge(s.substring(i + 1, s.length()));
						ValidPoint[1] = ValidPoint[1] < temp[1] ? temp[1] : ValidPoint[1];
						break;
						
					}

				} else {
					ValidPoint[0] = 1;
					
					if (left == right) {
						ValidPoint[0] = 0;
						ValidPoint[1] += 2*right;
						if (i < s.length() - 1) {
							
							int[] temp = charge(s.substring(i + 1, s.length()));
							if (temp[0] == 0) {
								ValidPoint[1] += temp[1];
								break;
							} else {
								ValidPoint[0]=temp[0];
								ValidPoint[2]=temp[2]+ValidPoint[1];
								ValidPoint[1] = ValidPoint[2] < temp[1] ? temp[1] : ValidPoint[2];
								break;
							}
						} else {
							break;
						}
					}
					else
					{
						if(left==temp_left)
						{
							ValidPoint[1] += 2*right;
						}
						else
						{
							temp_left=left;
							
							
							
						}
					}
				}
			}

		}
		return ValidPoint;

	}
}