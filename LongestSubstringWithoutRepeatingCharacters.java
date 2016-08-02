package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "c";
		Solution3 solu = new Solution3() {
		};
		int ans = 0;
		ans = solu.lengthOfLongestSubstring(s);
		System.out.println(ans);
	}

}


/**
 * 
 * @author ys
 *
 * ���β��ң��ظ���ȥ
 *
 *
 */

class Solution3 {
	public int lengthOfLongestSubstring(String s) {
		int nums = 0; // ��󳤶�
		int length = s.length();
		if (length == 1) {
			nums = 1;
		} else {
			int point_now = 1;// Ŀǰ��
			int point_start = 0;// ������󳤶ȳ�ʼ��
			while (point_now < length) {
				for (int i = point_start; i < point_now; i++) {
					if (s.charAt(i) == s.charAt(point_now)) {

						if ((point_now - point_start) > nums) {
							nums = point_now - point_start;
						}
						point_start = i + 1;
						break;
					} else if (i == (point_now - 1)) {
						if ((point_now - point_start + 1) > nums) {
							nums = point_now - point_start + 1;
						}
					}

				}
				point_now++;

			}
		}
		return nums;

	}
}