package leetcode;

public class JumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={2,3};
		Solution45 solu = new Solution45();
		long timestart=System.currentTimeMillis();
		System.out.println(solu.jump(nums));
		long timeend = System.currentTimeMillis();
		System.out.println("s:"+timestart+"e:"+timeend+"t:"+(timeend-timestart));
	}

}



class Solution45 {
    public int jump(int[] nums) {
    	int jumpStepNum = 1;
    	
    	int len = nums.length-1;
    	if(len<1)
    	{
    		jumpStepNum=0;
    		return jumpStepNum;
    	}
    	int pointPre = 1;
    	int point = nums[0];//记录当前最大位置
    	int maxPoint=0;//记录接下来最大数值的位置
		//int max=0;//记录最大值
    	while(point<len)
    	{
    		for(int i = 0 ;i<point-pointPre+1;i++)
    		{
    			if(nums[i+pointPre]+i+pointPre>maxPoint)
    			{
    				maxPoint=nums[i+pointPre]+pointPre+i;
    			}
    		}
    		pointPre=point;
    		point=maxPoint;
    		maxPoint=0;
    		jumpStepNum++;
    	}
    	
    	
    	return jumpStepNum;
        
    }
}