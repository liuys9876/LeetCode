package leetcode;

public class CountAndSay {

	public static void main(String[] args) {
		int n = 5;
		Solution38 solu = new Solution38();
		System.out.println(solu.countAndSay(n));

	}

}


class Solution38 {
    public String countAndSay(int n) {
    	String ans = "";
    	if(n==1)
    		ans="1";
    	else
    	{
    		String str=countAndSay(n-1);
    		char tempChar=str.charAt(0);;
    		int count=1;    		
    		for(int i = 1 ;i<str.length();i++)
    		{
    			if(str.charAt(i)==tempChar)
    			{
    				count++;
    			}
    			else
    			{
    				ans=ans+count+tempChar;
    				tempChar=str.charAt(i);
    				count=1;
    			}
    		}
    		ans=ans+count+tempChar;
       	}
    	return ans;
        
    }
}