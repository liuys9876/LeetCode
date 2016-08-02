package leetcode;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums={1,3,5,6};
		int target= 5;
		Solution35 solu = new Solution35();
		System.out.println(solu.searchInsert(nums,target));
	}

}
class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int ans = 0;
        for(int i =0;i<nums.length;i++)
        {
        	if(target<=nums[i])
        	{
        		ans=i;
        		break;
        	}else
        	{
        		if(i==(nums.length-1))
        		{
        			ans=i+1;
        			break;
        		}
        		else
        		{
        			continue;
        		}
        	}
        }
        return ans;
    }
}
