package leetcode;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "-2147483649";
		Solution8 solu = new Solution8() {
		};
		System.out.println(solu.myAtoi(str));
	}

}

class Solution8 {
	public int myAtoi(String str) {
		int ans = 0;
		String ans_temp = "";
		char temp;
		int length = str.length();
		if (length == 0) {
			ans = 0;
		} else {
			for (int i = 0; i < length; i++) {
				temp = str.charAt(i);
				if (ans_temp.isEmpty()) {
					if (temp == ' ') {
						continue;
					} else if (temp == '+') {
						ans_temp += "+";
					} else if (temp == '-') {
						ans_temp += "-";
					} else if (temp <= '9' && temp >= '0') {
						ans_temp += temp;
					} else {
						ans = 0;
						return ans;
					}
				} else {
					if (temp <= '9' && temp >= '0') {
						ans_temp += temp;
					} else if (ans_temp == "+" || ans_temp == "-") {
						ans = 0;
						return ans;
					} else {
						break;
					}
				}

			}
			try {
				ans = Integer.valueOf(ans_temp);

			} catch (Exception e) {
				if (ans_temp.charAt(0) == '-') {
					if (ans_temp.length() == 1) {
						ans = 0;
					} else {
						ans = Integer.MIN_VALUE;

					}
				} else {
					if (ans_temp.length() == 1) {
						ans = 0;
					} else {
						ans = Integer.MAX_VALUE;
					}
				}

			}
		}

		return ans;

	}
}