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
 * 依次查找，重复舍去
 *
 *
 */

class Solution3 {
	public int lengthOfLongestSubstring(String s) {
		int nums = 0; // 最大长度
		int length = s.length();
		if (length == 1) {
			nums = 1;
		} else {
			int point_now = 1;// 目前点
			int point_start = 0;// 计算最大长度初始点
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