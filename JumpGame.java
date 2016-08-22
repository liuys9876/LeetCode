package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,0};
		Solution55 solu = new Solution55();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.canJump(nums));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));
	}

}

class Solution55 {
    public boolean canJump(int[] nums) {
    	boolean ans = true;    	
    	int len = nums.length;
    	if(len<2)
    	{
    		return ans;
    	}
    	int count =1;
    	for(int i = len-2;i>=0;i--)
    	{
    		if(nums[i]>=count)
    		{
    			count=1;
    		}else
    		{
    			if(i==0)
    			{
    				ans=false;
    			}else
    			{
    				count++;
    			}
    		}
    	}
    	return ans;
        
    }
   }

/**
 * 
 * @author 
 * @param runtime error
 *
 */
/*
class Solution55 {
    public boolean canJump(int[] nums) {
    	boolean ans = false;    	
    	
    	List<Integer>  l = new ArrayList<Integer>();
    	if(nums.length<2)
    	{
    		ans=true;
    		return ans;
    	}
    	for(int i = 0; i<nums.length;i++)
    	{
    		l.add(nums[i]);
    	}
    	if(charge(l).size()==0)
    	{
    		ans=true;
    	}
    	
    	
    	
    	
    	
    	return ans;
        
    }
    private List<Integer> charge(List<Integer> l)
    {
    	int len = l.size();
    	if(len!=0)
    	{
    		if(len==1)
    		{
    			l.remove(0);
    		}else
    		{
    			l.remove(len-1);
    			for(int i =len-2 ;i>=0;i--)
    			{
    				if(l.get(i)==len-i-1)
    				{
    					l=charge(l);
    					break;
    				}
    				else
    				{
    					if(i!=0)
    					{
    						l.remove(i);
    					}else
    					{
    						break;
    					}
    				}
    			}
    		}
    	}
    	return l;
    }
    
    
    
    
}*/