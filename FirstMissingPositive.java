package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] nums={3,3,2,2,1,1};
			Solution41 solu = new Solution41();
			long timestart=System.currentTimeMillis();
			System.out.println(solu.firstMissingPositive(nums));
			long timeend = System.currentTimeMillis();
			System.out.println("s:"+timestart+"e:"+timeend+"t:"+(timeend-timestart));
	}

}
//1ms
class Solution41 {
public int firstMissingPositive(int[] nums) {  
    for(int i=0;i<nums.length;i++){  
        while(nums[i]!=i+1){  
            if(nums[i]<=0 ||nums[i]>=nums.length|| nums[i]==nums[nums[i]-1]) break;  
            int temp = nums[i];  
            nums[i] = nums[nums[i]-1];  
            nums[temp-1] = temp;  
        }  
          
    }  
    for(int i=0;i<nums.length;i++){  
        if(nums[i]!=i+1)  
            return i+1;  
    }  
    return nums.length+1;  
}  

}



/*
 
 

 //9ms
class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int ans = 1;
        Set<Integer> s = new TreeSet<Integer>();
        for(int k : nums)
        {
        	s.add(k);
        }
        int[] numsNew = new int[s.size()];
        int k=0;
        for(int j :s)
        {
        	numsNew[k++]=j;
        }
        int i = 0;
        int len = numsNew.length;
        if(len==0)
        {
        	return ans;
        }
        while(i<len&&numsNew[i]<=0)
        {
        	i++;
        }
        if(i<len)
        {
        	int temp = i;
        for(; i < len ;i++)
        {
        	if(numsNew[i]!=(i-temp+1))
        			{
        		return i-temp+1;
        			}
        }
        return len-temp+1;
        }
        return ans;
    }
}
*/