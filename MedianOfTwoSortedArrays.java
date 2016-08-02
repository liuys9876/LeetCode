package leetcode;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution4 solu = new Solution4() {
		};
		int[] nums1={1,2,5};
		int[] nums2={3,4,6,7};
		System.out.println(solu.findMedianSortedArrays(nums1, nums2));
	}

}
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length= nums1.length+nums2.length;
		
		int target =0;
		double ans=0;
    	int[] temp  = new int[length];
    	int i=0,j=0;    //i为nums1当前point,j为nums2当前point
    	while(i<nums1.length&&j<nums2.length)
    	{
    		if(nums1[i]<=nums2[j])
    		{
    			temp[i+j]=nums1[i];
    			i++;
    		}
    		else
    		{
    			temp[i+j]=nums2[j];
    			j++;
    		}
    	}
    	while(i==nums1.length&&j<nums2.length)
    	{
    		temp[i+j]=nums2[j];
			j++;
    	}
    	while(i<nums1.length&&j==nums2.length)
    	{
    		temp[i+j]=nums1[i];
			i++;
    	}
    	if(length%2==0)
		{target=length/2;
		ans=(double)(temp[target]+temp[target-1])/2;}
		else{target=length/2;
		ans=temp[target];}
    		
    
    	
    	return ans;
        
    }
}