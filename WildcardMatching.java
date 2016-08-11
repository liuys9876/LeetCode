package leetcode;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="",p="";
		Solution44 solu = new Solution44();
		long timestart=System.currentTimeMillis();
		System.out.println(solu.isMatch(s, p));
		long timeend = System.currentTimeMillis();
		System.out.println("s:"+timestart+"e:"+timeend+"t:"+(timeend-timestart));
	}

}
class Solution44 {
    public boolean isMatch(String s, String p) {
        boolean ans =false;
        int sPoint=0;//记录s的位置
        int pPoint=0;//记录p的位置
        int sLen = s.length();
        int pLen = p.length();
        if((sLen==0&&pLen!=0)||(sLen!=0&&pLen==0))
        {
        	return ans;
        }
        if((sLen==0&&pLen==0))
        {
        	ans=true;
        	return ans;
        }
        if(sPoint<sLen&&pPoint<pLen)
        	{
        		if(s.charAt(sPoint)=='?')
        		{
        			if(p.charAt(pPoint)=='?')
            		{
            			ans=isMatch(s.substring(sPoint+1,sLen),p.substring(pPoint+1,pLen));
            		}else if(s.charAt(pPoint)=='*')
            		{
            			
            		}else
            		{
            			
            		}
        		}else if(s.charAt(sPoint)=='*')
        		{
        			
        		}else
        		{
        			
        		}
        	}
        return ans;
    }
}