package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=-2147483648;
		Solution51 solu = new Solution51();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.solveNQueens(n));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));

	}

}

class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        return ans;
    }
}