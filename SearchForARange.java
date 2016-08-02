package leetcode;

public class SearchForARange {

	public static void main(String[] args) {
		int[] nums={1,5};
		int target= 4;
		Solution34 solu =  new Solution34();
		System.out.println(solu.searchRange(nums,target));

	}

}
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
    	int[] ans ={-1,-1};
    loop:
    	for(int i = 0 ;i<nums.length;i++)
    	{
    		if(target==nums[i])
    		{
    			ans[0]=i;
    			for(int j =i+1;j<nums.length;j++)
    			{
    				if(target<nums[j])
    				{
    					ans[1]=j-1;
    					break loop;
    				}
    			}
    			ans[1]=nums.length-1;
    			break;
    			
    		}
    	}
    	return ans;
        
    }
}