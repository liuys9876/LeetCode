package leetcode;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 2 };
		int val =3;
		Solution27 solu = new Solution27() {
		};
		System.out.println(solu.removeElement(nums, val));
	}

}


class Solution27 {
    public int removeElement(int[] nums, int val) {
        int ans=0;
        if(nums.length==0)
        {
        	ans=0;
        }
        else 
        {
        	for(int i =0;i<nums.length;i++)
        	{
        		
        		 if(nums[i]!=val)
        		 {
        			 nums[ans]=nums[i];
        			 ans++;
        		 }
        	}
        }
        return ans;
    }
}