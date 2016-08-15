package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PowXN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x=8.003;
		int n=100;
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
    		int Pow = arr.length-1;
    		for(int i = Pow ;i>0;i--)
    		{
    			ans*=arr[i]*(1<<Pow);
    			Pow--;
    		}
    		return ans;
    	}else
    	{
    		int[] arr ={};
    		double ans=1;
    		arr=div(Math.abs(n));
    		int Pow = arr.length-1;
    		for(int i = Pow ;i>=0;i--)
    		{
    			ans*=arr[i]*(1<<Pow);
    			Pow--;
    		}
    		return 1/ans;
    	}
    }
    //将n分解成2^i的相加的形式，n=l1*2^0+l2*2^1+……+ln*2^n;
    private int[] div(int n)
    {
    	int MaxPow = 0;
    	int tempN=n;
    	while(n>1)
    	{
    		n=n>>1;
    		MaxPow++;
    	}
    	int[] arr = new int[MaxPow+1];
    	for(int j =MaxPow;j>=0 ;j--)
    	{
    		if(tempN>(1<<j))
    		{
    			arr[j]=1;
    			tempN-=(1<<j);
    		}else if(tempN<(1<<j))
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