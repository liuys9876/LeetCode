package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
				{ '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
				{ '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
				{ '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
				{ '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };
		Solution36 solu = new Solution36();
		System.out.println(solu.isValidSudoku(board));
	}

}

class Solution36 {
	public boolean isValidSudoku(char[][] board) {
		boolean ans = false;
		int MaxBoard = board.length;
		for (int i = 0; i < MaxBoard; i++) {
			List<Character> temp1 = new ArrayList<Character>();
			List<Character> temp2 = new ArrayList<Character>();
			for (int j = 0; j < MaxBoard; j++) {
				if ('.' != board[i][j]) {
					if (temp1.contains(board[i][j])) {
						return ans;
					} else {
						temp1.add(board[i][j]);
					}
				}
				if ('.' != board[j][i]) {
					if (temp2.contains(board[j][i])) {
						return ans;
					} else {
						temp2.add(board[j][i]);
					}
				}
			}
			temp1.clear();
			temp2.clear();
		}

		for (int i = 0; i < MaxBoard / 3; i++) {
			for (int j = 0; j < MaxBoard / 3; j++) {
				List<Character> temp = new ArrayList<Character>();
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if ('.' != board[i * 3 + k][j * 3 + l]) {
							if (temp.contains(board[i * 3 + k][j * 3 + l])) {
								return ans;
							} else {
								temp.add(board[i * 3 + k][j * 3 + l]);
							}
						}
					}
				}
				temp.clear();
			}
		}
		ans = true;

		return ans;
	}
}