package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
				{ '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
				{ '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
				{ '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
				{ '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };
		Solution37 solu = new Solution37();
		//System.out.println(solu.isValidSudoku(board));

	}

}



class Solution37 {
    public void solveSudoku(char[][] board) {
    	List<Character> content = new ArrayList<Character>();
    	Map<Integer,List<Character>> row = new HashMap<Integer,List<Character>>();
    	Map<Integer,List<Character>> column = new HashMap<Integer,List<Character>>();
    	Map<Integer,List<Character>> box = new HashMap<Integer,List<Character>>();
    	
        for(int i = 0 ; i < 9 ; i++)
        {
        	content.add((char)i);        	
        }
        for(int i = 0 ; i < 9 ; i++)
        {
        	row.put(i,content);
        	column.put(i,content);
        	box.put(i,content);
        }
        for(int i = 0 ;i< 9;i++)
    	{
    		for(int j = 0 ; j<9 ;j++)
    		{
    			if(board[i][j]!='.')
    			{
    				row.get(i).remove(board[i][j]);
    				column.get(j).remove(board[i][j]);
    				box.get(i*3+j).remove(board[i][j]);
    			}
    		}
    	}
        board =ChargeSudoku(board, row, column, box,0,0);
        
        
        
    }
    private char[][] ChargeSudoku (char[][] board,Map<Integer,List<Character>> row ,Map<Integer,List<Character>> column,Map<Integer,List<Character>> box,int StartRow, int StartColum)
    {
    	
    	for(int i = StartRow ;i< 9;i++)
    	{
    		for(int j = StartColum ; j<9 ;j++)
    		{
    			if(board[i][j]=='.')
    			{
    				for(char temp:row.get(i))
    				{
    					if(column.get(j).contains(temp)&&box.get(i*3+j).contains(temp))
    					{
    						board[i][j]=temp;
    						row.get(i).remove(board[i][j]);
    	    				column.get(j).remove(board[i][j]);
    	    				box.get(i*3+j).remove(board[i][j]);
    						board=ChargeSudoku(board, row, column, box, i, j);
    					}
    				}
    				
    			}
    		}
    	}
    	
    	
    	return board;
    }
}