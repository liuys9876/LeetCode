package leetcode;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1="63068080726329880611684115603801120940144776974937025638198670884099005492080675397052881650850279";
		String num2="91851171339080006286661648785824201538663791893631297";
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