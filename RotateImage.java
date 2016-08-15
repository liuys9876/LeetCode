package leetcode;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		Solution48 solu = new Solution48();
		long timestart = System.currentTimeMillis();
		solu.rotate(matrix);
		System.out.println(matrix);
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));
	}

}



class Solution48 {
    public void rotate(int[][] matrix) {
    	int len = matrix.length;
    	if(len==1)
    	{
    		return ;
    	}
    	if(len==2)
    	{
    		int temp = matrix[0][0];
			matrix[0][0]=matrix[1][0];
			matrix[1][0]=matrix[1][1];
			matrix[1][1]=matrix[0][1];
			matrix[0][1]=temp;
			return ;
    	}
    	for(int i = 0; i<len/2;i++)
    	{
    		for(int j = i;j<len-1-i;j++)
    		{
    			int temp = matrix[i][j];
    			int temp1=len-1-i,temp2=len-1-j;    			
    			matrix[i][j]=matrix[temp2][i];
    			matrix[temp2][i]=matrix[temp1][temp2];
    			matrix[temp1][temp2]=matrix[j][temp1];
    			matrix[j][temp1]=temp;
    			
    		}
    	}
    	
        
    	
    	
    	
    	
    }
}