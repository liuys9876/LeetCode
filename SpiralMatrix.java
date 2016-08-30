package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		Solution54 solu = new Solution54();
		long timestart=System.currentTimeMillis();
		System.out.println(solu.spiralOrder(matrix));
		long timeend = System.currentTimeMillis();
		System.out.println("s:"+timestart+"e:"+timeend+"t:"+(timeend-timestart));
	}

}
class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer>  spiral  = new ArrayList<Integer>();
    	int rows = matrix.length;
    	if(rows==0)
    	{
    		return spiral;
    	}
    	int collums = matrix[0].length; 
    	
    	int rowsStart=0,rowsEnd=rows-1;
    	int collumsStart=0,collumsEnd=collums-1;
    	while((rowsEnd>rowsStart)&&(collumsEnd>collumsStart))
    	{
    		List<Integer>  tempList1 = new ArrayList<Integer>();
            List<Integer>  tempList2 = new ArrayList<Integer>();
    		for(int i=collumsStart;i<collumsEnd;i++)
    		{
    			spiral.add(matrix[rowsStart][i]);
    			tempList1.add(matrix[rowsEnd][collums-1-i]);
    		}
    		for(int i=rowsStart;i<rowsEnd;i++)
    		{
    			spiral.add(matrix[i][collumsEnd]);
    			tempList2.add(matrix[rows-1-i][collumsStart]);
    		}
    		spiral.addAll(tempList1);
    		spiral.addAll(tempList2);
    		rowsStart++;
    		rowsEnd--;
    		collumsStart++;
    		collumsEnd--;
    	}
    	if(rowsStart==rowsEnd)
    	{
    		if(collumsStart==collumsEnd)
    		{
    			spiral.add(matrix[rowsStart][collumsStart]);
    		}
    		else if(collumsStart<collumsEnd)
    		{
    			for(int i = collumsStart;i<=collumsEnd;i++)
    			{
    				spiral.add(matrix[rowsStart][i]);
    			}
    		}
    	}else if(rowsStart<rowsEnd)
    	{
    		if(collumsStart==collumsEnd)
    		{
    			for(int i = rowsStart;i<=rowsEnd;i++)
    			{
    				spiral.add(matrix[i][collumsStart]);
    			}
    		}
    			
    	}
    	return spiral;
    	
    	
    	/*
        List<Integer>  ansList = new ArrayList<Integer>();
        List<Integer>  tempList1 = new ArrayList<Integer>();
        List<Integer>  tempList2 = new ArrayList<Integer>();
        int rowsLen = matrix.length;
        int collumsLen = matrix[0].length;
        int m =rowsLen-1,n=collumsLen-1;
        int mPoint=0,nPoint=0;
        int count =0;
        while(true)
        {
        	mPoint=count;
        	nPoint=count;
        	for(;nPoint<n;nPoint++)
        	{
        		ansList.add(matrix[mPoint][nPoint]);
        		tempList1.add(matrix[rowsLen-mPoint-1][collumsLen-nPoint-1]);
        	}
        	nPoint++;
        	for(;mPoint<m;mPoint++)
        	{
        		ansList.add(matrix[mPoint][nPoint]);
        		tempList2.add(matrix[rowsLen-mPoint-1][collumsLen-nPoint-1]);
        	}
        	ansList.addAll(tempList1);
        	ansList.addAll(tempList2);
        	m-=2;
        	n-=2;
        	count++;
        	*/
        	
        }
    }
