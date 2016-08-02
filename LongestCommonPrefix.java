package leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[] { "aa", "a" };
		Solution14 solu = new Solution14() {
		};
		System.out.println(solu.longestCommonPrefix(strs));
	}

}

class Solution14 {
	public String longestCommonPrefix(String[] strs) {
		String ans = "";
		int count = 0;
		char temp = ' ';
		if (strs.length == 1) {
			ans = strs[0];
		}
		if (strs.length > 1) {
			loop: while (true) {
				if (count < strs[0].length()) {
					temp = strs[0].charAt(count);
				} else {
					break loop;
				}
				for (int i = 1; i < strs.length; i++) {
					if (count < strs[i].length()) {
						if (strs[i].charAt(count) != temp) {
							break loop;
						}
					} else {
						break loop;
					}
				}
				count++;
			}
			ans = strs[0].substring(0, count);
		}
		return ans;

	}
}