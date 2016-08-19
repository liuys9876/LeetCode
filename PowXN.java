package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PowXN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x=-1.00000;
		int n=-2147483648;
		Solution50 solu = new Solution50();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.myPow(x,n));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));

	}

}



class Solution50 {
    public double myPow(double x, int n) {
    	if(n==0)
    	{
    		x=1;
    		return x;
    	}
    	else if(n>0)
    	{
    		int[] arr ={};
    		double ans=1;
    		arr=div(Math.abs(n));
    		double temp=x;
    		for(int i = 0;i<arr.length;i++)
    		{
    			if(arr[i]==0)
    			{
    				temp=temp*temp;
    			}
    			else
    			{
    				ans=ans*temp;
    				temp=temp*temp;
    			}
    		}
    		return ans;
    	}else
    	{
    		int[] arr ={};
    		double ans=1;
    		arr=div(Math.abs((long)n));
    		double temp=x;
    		for(int i = 0;i<arr.length;i++)
    		{
    			if(arr[i]==0)
    			{
    				temp=temp*temp;
    			}
    			else
    			{
    				ans=ans*temp;
    				temp=temp*temp;
    			}
    		}
    		return 1/ans;
    	}
    }
    //将n分解成2^i的相加的形式，n=l1*2^0+l2*2^1+……+ln*2^n;
    private int[] div(long n)
    {
    	int MaxPow = 0;
    	long tempN=n;
    	while(n>1)
    	{
    		n=n>>1;
    		MaxPow++;
    	}
    	int[] arr = new int[MaxPow+1];
    	for(int j =MaxPow;j>=0 ;j--)
    	{
    		//强转1为long类型，默认1为int类型，防止1<<31超过数位大小变为负值
    		if(tempN>((long)1<<j))
    		{
    			arr[j]=1;
    			tempN-=(1<<j);
    		}else if(tempN<((long)1<<j))
    		{
    			arr[j]=0;
    		}
    		else
    		{
    			arr[j]=1;
    			break;
    		}
    	}
    	
    	return arr;
    }
}