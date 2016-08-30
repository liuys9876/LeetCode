package leetcode;

public class UniquePaths2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] obstacleGrid={{0,0},{1,1},{0,0}};
		Solution63 solu = new Solution63();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.uniquePathsWithObstacles(obstacleGrid));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));
	}

}
class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ans = 1;
        int m=obstacleGrid.length;
        if(m==0)
        {
        	ans=0;
        	return ans;
        }
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)
        {
        	ans=0;
        	return ans;
        }
        int val[][]=new int[m][n];
        for(int i =0;i<n;i++)
        {
        	if(obstacleGrid[0][i]==1)
        	{
        		val[0][i]=0;
        		for(int j=i+1;j<n;j++)
        		{
        			val[0][j]=0;
        		}
        		break;
        	}
        	else
        	{
        		val[0][i]=1;
        	}
        }
        for(int i =0;i<m;i++)
        {
        	if(obstacleGrid[i][0]==1)
        	{
        		val[i][0]=0;
        		for(int j =i+1;j<m;j++)
        		{
        			val[j][0]=0;
        		}
        		break;
        	}
        	else
        	{
        		val[i][0]=1;
        	}
        }
        
        int temp =0;
        for(int i = 1;i<m;i++)
        {
        	for(int j = 1;j<n;j++)
        	{
        		if(obstacleGrid[i][j]!=1)
        		{
        		if(obstacleGrid[i-1][j]==1)
        		{
        			temp=0;
        		}
        		else
        		{
        			temp=val[i-1][j];
        		}
        		if(obstacleGrid[i][j-1]!=1)
        		{
        			temp+=val[i][j-1];
        		}
        		val[i][j]=temp;
        	}else
        	{
        		val[i][j]=0;
        	}
        		}
        }
        
        return val[m-1][n-1];
    }
}