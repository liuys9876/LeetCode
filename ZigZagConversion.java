package leetcode;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "AB";
		int numRows = 1;
		Solution6 solu = new Solution6() {
		};
		System.out.println(solu.convert(s, numRows));

	}

}

class Solution6 {
	public String convert(String s, int numRows) {
		String ans = "";
		int length = s.length();
		if (numRows == 1) {
			ans = s;
		} else {
			for (int i = 0; i < numRows; i++)// ÖðÐÐµÝ½øÀÛ¼Ó
			{
				int j = i;

				if (i == 0) {
					int temp1 = 2 * (numRows - i - 1);
					while (j < length) {
						ans += s.charAt(j);
						j += temp1;
					}
				} else if (i == numRows - 1) {
					int temp2 = 2 * (numRows - 1);
					while (j < length) {
						ans += s.charAt(j);
						j += temp2;
					}
				} else {
					int temp3 = 2 * (numRows - i - 1);
					int temp4 = 2 * i;
					while (j < length) {
						ans += s.charAt(j);
						j += temp3;
						if (j < length) {
							ans += s.charAt(j);
							j += temp4;
						}
					}
				}
			}
		}
		return ans;

	}
}
