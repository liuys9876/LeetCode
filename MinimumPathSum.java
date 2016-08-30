package leetcode;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] grid={{1,1},{1,1},{1,1}};
		Solution64 solu = new Solution64();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.minPathSum(grid));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));
	}

}
class Solution64 {
    public int minPathSum(int[][] grid) {
        int ans = 0;
        int rows= grid.length;
        if(rows==0){
        	return ans;
        }
        int collums = grid[0].length;
        if(rows>1)
        {
        	for(int i =1;i<rows;i++)
        	{
        		grid[i][0]+=grid[i-1][0];
        	}
        }
        if(collums>1)
        {
        	for(int i =1;i<collums;i++)
        	{
        		grid[0][i]+=grid[0][i-1];
        	}
        }
        //int[][] val = new int[rows][collums];
        for(int i =1;i<rows;i++)
        {
        	for(int j = 1;j<collums;j++)
        	{
        		grid[i][j]+=Math.min(grid[i-1][j], grid[i][j-1]);
        	}
        }
        return grid[rows-1][collums-1];
    }
}


