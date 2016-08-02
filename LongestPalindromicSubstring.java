package leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "bb";
		Solution5 solu = new Solution5() {
		};
		System.out.println(solu.longestPalindrome(s));

	}

}

class Solution5 {
	public String longestPalindrome(String s) {
		int max_length = 0;// 目前最大拓展长度
		String ans = null;
		int j = 0; // 拓展长度
		if (s.length() == 1 || s.length() == 2) {
			ans = s;
		} else {
			//ABA的形式
			for (int i = 1; i < s.length() - 1; i++) {
				j = 1;
				while ((i - j) >= 0 && (i + j) < s.length()) {
					if (s.charAt(i - j) == s.charAt(i + j)) {
						j++;
					} else {
						break;
					}

				}
				if (j > 1 && j > max_length) {
					max_length = --j;
					ans = s.substring(i - j, i + j + 1);
				}

			}
			//AA的形式
			for (int i = 0; i < s.length() - 1; i++) {
				j = 0;
				while ((i - j) >= 0 && (i + j + 1) < s.length()) {
					if (s.charAt(i - j) == s.charAt(i + j + 1)) {
						j++;
					} else {
						break;
					}

				}
				if (j > 0 && j > max_length) {
					max_length = j;
					ans = s.substring(i - j+1, i + j +1);
				}

			}
		}
		return ans;

	}
}