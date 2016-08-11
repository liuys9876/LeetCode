package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height={9,6,8,8,5,6,3,9,6,8,8,5,6,3,9,6,8,8,5,6,3,9,6,8,8,5,6,3,9,6,8,8,5,6,3,9,6,8,8,5,6,3,9,6,8,8,5,6,3,9,6,8,8,5,6,3,9,6,8,8,5,6,3,9,6,8,8,5,6,3,};
		Solution42 solu = new Solution42();
		long timestart=System.currentTimeMillis();
		System.out.println(solu.trap(height));
		long timeend = System.currentTimeMillis();
		System.out.println("s:"+timestart+"e:"+timeend+"t:"+(timeend-timestart));
	}

}

class Solution42
{
	public int trap(int[] height)
	{
		int ans=0;
		int left =0;
		int right =height.length-1;
		int secondHigh = 0;
		while(left<right)
		{
			if(height[left]>height[right])
			{
				secondHigh=Math.max(height[right], secondHigh);
				ans+=secondHigh-height[right];
				right--;
			}else
			{
				secondHigh=Math.max(height[left], secondHigh);
				ans+=secondHigh-height[left];
				left++;
			}
		}
		return ans;
	}
}



/*
 *125ms 
 * 
 
class Solution42 {
    public int trap(int[] height) {
        int Sum = 0;
        List<Integer> l = new ArrayList<Integer>();
        int Max = 0;
        if(height.length<3)
        {
        	return Sum;
        }        	
        for (int i = 0;i<height.length;i++) 
        {
        	if(height[i]>Max)
        	{
        		if(l.size()>1)
        		{
        		for(int j :l)
        		{
        			Sum+=(Max-j);
        		}
        		}
        		Max=height[i];
        		l.clear();
        		l.add(height[i]);
        	}
        	else
        	{
        		int len =l.size();
        		if(i==height.length-1)
        		{
        			int temp = height[i];
        			for(int k :l)
        			{
        				if(temp>k)
        				{
        				Sum+=(temp-k);
        				}
        			}
        		}
        		else
        		{
        			if(len>1&&height[i]>height[i-1]&&height[i]>=height[i+1])
        			{
        				int temp = height[i];
        				for(int k=0;k<len ; k++)
            			{
            				if(temp>l.get(k))
            				{
            				Sum+=(temp-l.get(k));
            				l.set(k, height[i]);
            				}
            			}
        			}
        			l.add(height[i]);
        		}
        	}
        }
        return Sum;
    }
}
*/