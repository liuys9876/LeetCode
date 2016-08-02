package leetcode;

public class Implement_strStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "";
		String needle = "a";
		Solution28 solu = new Solution28();
		System.out.println(solu.strStr(haystack, needle));
	}

}

class Solution28 {
	public int strStr(String haystack, String needle) {
		int ans = -1;
		int count = 0;
		if(haystack.length()==0&&needle.length()!=0)
		{
			return ans;
		}
		else if(needle.length()==0)
		{
			ans=0;
			return ans;
		}
		else{
		while ( haystack.length() >= needle.length()) {
			if (haystack.charAt(0) == needle.charAt(0))
			{
				
				if(campared(haystack, needle))
				{
				ans = count;
				break;
				}
				else
				{
					haystack=haystack.substring(1,haystack.length());
					count++;
				}
			} else {
				haystack=haystack.substring(1,haystack.length());
				count++;
			}
		}

		return ans;
		}
	}

	private boolean campared(String h, String n) {
		boolean ans = false;

		for (int i = 0; i < n.length(); i++) {
			if (h.charAt(i) != n.charAt(i)) {
				break;
			}

			if(i==n.length()-1)
			{
				ans=true;
			}
		}
		return ans;
	}
}