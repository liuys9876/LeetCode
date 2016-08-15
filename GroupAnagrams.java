package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"and","dan"};
		Solution49 solu = new Solution49();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.groupAnagrams(strs));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));

	}

}



class Solution49 {
	 public List<List<String>> groupAnagrams(String[] strs) {
		 List<List<String>> ls = new ArrayList<List<String>>();
		 Map<String,Integer> lsOfEachType = new HashMap<String,Integer>();
		 for(int i = 0 ;i<strs.length;i++)
		 {
			 boolean addOrNot = true;//判断是否需要新增加类型
			 String strsNew= Order(strs[i]);
			 if(lsOfEachType.containsKey(strsNew))
						 {
					 		ls.get(lsOfEachType.get(strsNew)).add(strs[i]);
					 		addOrNot=false;
						 }
			 
			 if(addOrNot)
			 {
				 lsOfEachType.put(strsNew,lsOfEachType.size());
				 List<String> temp = new ArrayList<String>();
				 temp.add(strs[i]);
				 ls.add(temp);
			 
			 }
		 }
		 return ls;
	 }
	 private String Order (String s)
	 {
		 char[] c = s.toCharArray();
		 Arrays.sort(c);
		 return String.valueOf(c);
	 }
	 }
/*
	public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ls = new ArrayList<List<String>>();
        List<List<Character>> lc = new ArrayList<List<Character>>();//记录每种类型的String中的每一个char
        List<Integer>  lenOfEachList= new ArrayList<Integer>();//记录每种类型的String的长度
        boolean addOrNot =true;//判断是否需要新建一种类型
        for(int i = 0 ;i <strs.length ; i++)
        {
        	addOrNot=true;
        	int lenOfStr = strs[i].length();
        	for(int l = 0 ; l<lc.size();l++)
        	{
        		if(lenOfStr==lenOfEachList.get(l))
        		{
        			boolean temp=true;
        			for(int j = 0;j<lenOfStr;j++)
        			{
        				if(!lc.get(l).contains(strs[i].charAt(j)))
        				{
        					temp=false;
        					break;
        				}
        			}
        			if(temp)
        			{
        				ls.get(l).add(strs[i]);
        				addOrNot=false;
        				break;
        			}
        		}
        	}
        	if(addOrNot)
        	{
        	lenOfEachList.add(lenOfStr);
        	List<Character> charOfList = new ArrayList<Character>();
        	for(int k =0;k<lenOfStr;k++)
        	{
        		charOfList.add(strs[i].charAt(k));
        	}
        	lc.add(charOfList);
        	List<String> s = new ArrayList<String>();
        	s.add(strs[i]);
        	ls.add(s);
        	}
        }
        
        
        
        return ls;
    }
	
}
*/