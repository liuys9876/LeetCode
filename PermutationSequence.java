package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3,k=6;
		Solution60 solu = new Solution60();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.getPermutation(n, k));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));
	}

}
class Solution60 {
    public String getPermutation(int n, int k) {
    	List<Integer> l = new ArrayList<Integer>();
    	if(n<2)
    	{
    		return "1";
    	}
    	
    	int factorial=1;
    	for(int i = 1 ;i<=n;i++)
    	{
    		l.add(i);
    		factorial*=i;
    	}
    	factorial/=n;
    	return getPermutation2(l, k-1, "", factorial, n);
        
    }
    private String getPermutation2(List<Integer> l,int k,String s,int factorial,int n)
    {
    	if(n>0)
    	{
    	int temp = k/factorial;
    		s+=l.get(temp);
    		l.remove(temp);
    		k%=factorial;
    		n--;
    		factorial/=n;
    		if(k!=0)
    		{
    			s=getPermutation2(l, k,s,factorial,n);
    		}else
    		{
    			for(int i : l)
    			{
    				s+=i;
    			}
    			return s;
    		}
    	}
    	//s+=l.get(0);
    	
    	
        return s;
    }
}