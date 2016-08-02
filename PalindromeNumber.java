package leetcode;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 818;
		Solution9 solu = new Solution9() {
		};
		System.out.println(solu.isPalindrome(x));
	}

}

class Solution9 {
	public boolean isPalindrome(int x) {
		long sum = 0;
		int native_x = x;
		if (x < 0) {
			return false;
		} else if (x == 0) {
			return true;
		} else {
			while (x > 0) {
				sum = sum * 10 + x % 10;
				x /= 10;
			}
			if (sum == native_x) {
				return true;
			} else {
				return false;
			}
		}
	}
}