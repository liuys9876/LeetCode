package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.Location;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","good"};
		Solution30 solu = new Solution30();
		System.out.println(solu.findSubstring(s, words));
	}

}
class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        
    	
    	
    	/**
    	
    	
    	List<Integer> ans = new ArrayList<Integer>();
        
        if(words.length==0)
        {
        	return ans;
        }
        int CountWords=words.length;
        int WordLength=words[0].length();
        int MinSize = WordLength*CountWords;
        if(s.length()<MinSize)
        {
        	return ans;
        }
        Map<String,Integer> Words= new HashMap<String,Integer>();
        for(int i =0;i<words.length;i++)
        {
        	if(Words.containsKey(words[i]))
        	{
        		Words.put(words[i],Words.get(words[i])+1);
        	}
        	else
        	{
        		Words.put(words[i], 1);
        
        	}
        }
        for(int i = 0;i<=s.length()-MinSize;i++)
        {
        	String TempWords =s.substring(i,i+WordLength);
        	Map<String,Integer> AppearWords= new HashMap<String,Integer>();   //记录出现的words
        	Map<String,Integer> AppearWordsNums= new HashMap<String,Integer>();   //记录出现的words的次数
        	if(Words.containsKey(TempWords))
        	{
        		int StartLocation = i;   //记录初始位置
        		int PointLocation = i;	 //记录当前指针位置	
        		int count = 0;	
        		while(Words.containsKey(TempWords))
        		{
        			if(AppearWords.containsKey(TempWords)&&(AppearWordsNums.get(TempWords)>=Words.get(TempWords)))
        			{
        				i=AppearWords.get(TempWords)+WordLength-1;
        				break;
        			}
        			else if(AppearWords.containsKey(TempWords)&&(AppearWordsNums.get(TempWords)<Words.get(TempWords)))
        			{
        				AppearWordsNums.put(TempWords,AppearWordsNums.get(TempWords)+1);
        				PointLocation+=WordLength;
        				count++;
        				if(count==CountWords)
            			{
            				ans.add(StartLocation);
            				i+=WordLength-1;
            				break;
            			}
        				if(PointLocation>(s.length()-WordLength))
            			{
            				return ans;
            			}
            			else
            			{
        				TempWords=s.substring(PointLocation,PointLocation+WordLength);
            			}	
        				
        			}
        			else
        			{
        				AppearWords.put(TempWords, PointLocation);
        				AppearWordsNums.put(TempWords, 1);
        				PointLocation+=WordLength;
        				count++;
        				if(count==CountWords)
            			{
            				ans.add(StartLocation);
            				i+=WordLength-1;
            				break;
            			}
        				if(PointLocation>(s.length()-WordLength))
            			{
            				return ans;
            			}
            			else
            			{
        				TempWords=s.substring(PointLocation,PointLocation+WordLength);
            			}	
        				}
        			
        			
        		}
        	
        	}
        	
        }
        
		return ans;
		
		
		
		*/
    	/**
    	 * 
    	 * 维护两个指针，分别为前后区间，和一个 map，跑前面的指针看看当前区间能不能恰好匹配，行的话就得到答案了
    	 * 
    	 * 
    	 */
    	List<Integer> ret = new ArrayList<Integer>();  
        int slen = s.length(), llen = words.length;  
        if (slen <= 0 || llen <= 0)  
            return ret;  
        int wlen = words[0].length();  
  
        // get the words' map  
        HashMap<String, Integer> words1 = new HashMap<String, Integer>();  
        for (String str : words) {  
            if (words1.containsKey(str)) {  
                words1.put(str, words1.get(str) + 1);  
            } else {  
                words1.put(str, 1);  
            }  
        }  
  
        for (int i = 0; i < wlen; ++i) {  
            int left = i, count = 0;  
            HashMap<String, Integer> tmap = new HashMap<String, Integer>();  
  
            for (int j = i; j <= slen - wlen; j += wlen) {  
                String str = s.substring(j, j + wlen);  
  
                if (words1.containsKey(str)) {  
                    if (tmap.containsKey(str)) {  
                        tmap.put(str, tmap.get(str) + 1);  
                    } else {  
                        tmap.put(str, 1);  
                    }  
  
                    if (tmap.get(str) <= words1.get(str)) {  
                        count++;  
                    } else {  
                        // too many words, push the 'left' forward  
                        while (tmap.get(str) > words1.get(str)) {  
                            String tmps = s.substring(left, left + wlen);  
                            tmap.put(tmps, tmap.get(tmps) - 1);  
                            if (tmap.get(tmps) < words1.get(tmps)) {  
                                // if affect the count  
                                count--;  
                            }  
                            left += wlen;  
                        }  
                    }  
  
                    // get the answer  
                    if (count == llen) {  
                        ret.add(left);  
                        // it's better to push forward once  
                        String tmps = s.substring(left, left + wlen);  
                        tmap.put(tmps, tmap.get(tmps) - 1);  
                        count--;  
                        left += wlen;  
                    }  
                } else {  
                    // not any match word  
                    tmap.clear();  
                    count = 0;  
                    left = j + wlen;  
                }  
            }  
        }  
        return ret;  
    }
    
    
    
}