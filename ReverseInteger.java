package leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1000000003;
		Solution7 solu = new Solution7() {
		};
		System.out.println(solu.reverse(x));

	}

}

class Solution7 {
	public int reverse(int x) {
		long sum = 0;
		while (x != 0) {
			int temp = x % 10;
			sum = sum * 10 + temp;
			if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
				sum = 0;
				break;
			}
			x /= 10;
		}
		return (int) sum;

	}
}