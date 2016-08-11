package leetcode;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="a ";
		Solution58 solu = new Solution58();
		long timestart=System.currentTimeMillis();
		System.out.println(solu.lengthOfLastWord(s));
		long timeend = System.currentTimeMillis();
		System.out.println("s:"+timestart+"e:"+timeend+"t:"+(timeend-timestart));
	
	}

}



class Solution58 {
    public int lengthOfLastWord(String s) {
    	s=s.trim();
     int len = s.length();
     int lastWordLength = 0;
     for(int k=0;k<len;k++)
     {
    	 if(s.charAt(k)!=' ')
    	 {
    		 lastWordLength++;
    	 }else
    	 {
    		 lastWordLength=0;
    	 }
     }
    return lastWordLength;
    		
    }
}