package leetcode;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[({(())}[()])]";// "[({(())}[()])]";
		Solution20 solu = new Solution20() {
		};
		System.out.println(solu.isValid(s));
	}

}

class Solution20 {
	public boolean isValid(String s) {

		boolean ans = false;
		String pre_s = "";
		for (int i = 0; i < s.length(); i++) {
			char temp_char = s.charAt(i);
			if (temp_char == '(' || temp_char == '[' || temp_char == '{') {
				pre_s += temp_char;
			} else if (pre_s.isEmpty()) {
				return ans;
			} else {
				switch (temp_char) {
				case ')':
					if (pre_s.charAt(pre_s.length() - 1) == '(') {
						pre_s=pre_s.substring(0, pre_s.length() - 1);
						break;
					} else {
						return ans;
					}
				case ']':
					if (pre_s.charAt(pre_s.length() - 1) == '[') {
						pre_s=pre_s.substring(0, pre_s.length() - 1);
						break;
					} else {
						return ans;
					}
				case '}':
					if (pre_s.charAt(pre_s.length() - 1) == '{') {
						pre_s=pre_s.substring(0, pre_s.length() - 1);
						break;
					} else {
						return ans;
					}
				}
			}

		}
		if (pre_s.isEmpty()) {
			ans = true;
		}
		return ans;

	}
}
