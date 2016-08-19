package leetcode;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
		Solution53 solu = new Solution53();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.maxSubArray(nums));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));

	}

}
class Solution53 {
	public int maxSubArray(int[] nums) {
		int sum = nums[0];
		int max =nums[0];
		for(int i = 1;i<nums.length;i++)
		{
			if(sum<0)
			{
				sum=nums[i];
				max=Math.max(sum, max);
			}
			else
			{
				sum+=nums[i];
				max=Math.max(sum, max);
			}
		}
        return max;
	}
}
/**
 * Ð§ÂÊ½ÏµÍ
 
class Solution53 {
	public int maxSubArray(int[] nums) {
		int sumMax = nums[0];
        for(int i = 0 ;i<nums.length;i++)
        {
        	sumMax=Math.max(sumMax,nums[i]);
        	int tempsum=nums[i];
        	for(int j =i+1;j<nums.length;j++)
        	{
        		tempsum+=nums[j];
        		sumMax=Math.max(sumMax,tempsum);
        	}
        }
        return sumMax;
	}
}
*/