package leetcode;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		Solution22 solu = new Solution22() {
		};
		System.out.println(solu.generateParenthesis(n));
	}

}

class Solution22 {
	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<String>();
		
		if(n>2)
		{
			for( String s : generateParenthesis(n-1))
			{
				
				ans.add("()"+s);
				ans.add(s+"()");
				ans.add("("+s+")");
				
			}
			for(int i =1;i<(n/2);i++)
		{
			for( String s : generateParenthesis(n-i-1))
			{
				for(String s2 :generateParenthesis(i+1))
				{
				ans.add(s2+s);
				ans.add(s+s2);
				
				}
			}
		
		}	
			Set<String> s = new HashSet<String>(ans);
			List<String> l =new ArrayList<String>(s);
			return l;
		}else if (n==2)
		{
			ans.add("()()");
			ans.add("(())");
		}else if(n==1)
		{
			ans.add("()");
		}
		
		
		
		return ans;

	}
}