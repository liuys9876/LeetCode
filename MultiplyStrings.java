package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1="65787657567577777777776666666666666666666666666666666666666666666666";
		String num2="5017988888888888888888888888888888888888888888888888888888888888889";
		Solution43 solu = new Solution43();
		long timestart=System.currentTimeMillis();
		System.out.println(solu.multiply(num1, num2));
		long timeend = System.currentTimeMillis();
		System.out.println("s:"+timestart+"e:"+timeend+"t:"+(timeend-timestart));
	}

}
class Solution43 {
    public String multiply(String num1, String num2) {
	        String ans ="";
	        int num1len = num1.length();
	        int num2len = num2.length();
	        if("0".equals(num1)||"0".equals(num2))
	        {
	        	ans="0";
	        	return ans;
	        }
	        int[] arrPoint = new int[num1len+num2len+1];//临时记录每个数位位置的值,a*b的结果长度必然小于a与b的长度之和
	        for(int i =0 ;i <num2len;i++)
	        {
	        	for(int j = 0;j<num1.length();j++)
	        	{
	        		arrPoint[i+j]+=Integer.parseInt(String.valueOf(num1.charAt(num1len-j-1)))*Integer.parseInt(String.valueOf(num2.charAt(num2len-i-1)));
	        	}
	        }
	        
	        for(int k=0;k<arrPoint.length;k++)
	        {
	        		ans=arrPoint[k]%10+ans;
	        		if(k!=arrPoint.length-1)
	        		arrPoint[k+1]+=arrPoint[k]/10;
	        }
	        while(ans.charAt(0)=='0')
	        {
	        	ans=ans.substring(1,ans.length());
	        }
	        
	        return ans;
    }
}


/*
class Solution43 {
    public String multiply(String num1, String num2) {
        String ans ="";
        String up ="";//乘法进位错位
        int len2 = num2.length();
        if(num2.length()>1)
        {
        for(int i=0;i<len2;i++)
        {
        	String temp=multiply(num1,num2.substring(len2-i-1,len2-i));
        	if(!"0".equals(temp))
        	{
        		ans=add(ans,temp+up);
        	}
        	up+="0";
        }
        if("".equals(ans))
        {
        	ans="0";
        }
        }
        else
        {
        	int cycleNum=Integer.parseInt(num2);       	
        	for(int i =0;i<cycleNum;i++)
        	{
        		ans=add(ans,num1);
        	}
        	if("".equals(ans))
            {
            	ans="0";
            }
        }
        return ans;
    }
    //加法运算
    private String add(String num1, String num2)
    {
    	String ans="";
    	int len1=num1.length();
    	int len2=num2.length();
    	int len = Math.min(len1,len2);
    	int up =0;//进位
    	for(int i = 0;i<len;i++)
    	{
    		int num1Temp=Integer.parseInt(num1.substring(len1-i-1,len1-i));
    		int num2Temp=Integer.parseInt(num2.substring(len2-i-1,len2-i));
    		int sum=num1Temp+num2Temp+up;
    		ans=sum%10+ans;
    		up=sum/10;
    	}
    	if(up>0)
    	{
    	if(len==len1)
    	{
    		ans=add(num2.substring(0,len2-len),String.valueOf(up))+ans;
    	}
    	else
    	{
    		ans=add(num1.substring(0,len1-len),String.valueOf(up))+ans;
    	}
    	}else
    	{
    		if(len==len1)
        	{
        		ans=num2.substring(0,len2-len)+ans;
        	}
        	else
        	{
        		ans=num1.substring(0,len1-len)+ans;
        	}
    	}
    	
    	return ans;
    }
}


*/