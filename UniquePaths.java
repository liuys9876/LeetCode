package leetcode;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=10,n=10;
		Solution62 solu = new Solution62();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.uniquePaths(m, n));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));
	}

}


/**
 * 
 * @author cmcc
 *	@param C (M+N) M 
 */
class Solution62 {
    public int uniquePaths(int m, int n) {
        long Path = 1;
        m-=1;
        n-=1;
        int sum = m+n ;
        if(m>n)
        {
        	for(int i = 1 ;i<=n ;i++)
        	{
        		Path=Path*(sum+1-i)/i;
        	}
        }else
        {
        	for(int i = 1 ;i<=m ;i++)
        	{
        		Path=Path*(sum+1-i)/i;
        	}
        }
        return (int)Path;
    }
}