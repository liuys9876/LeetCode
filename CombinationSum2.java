package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class CombinationSum2 {

	public static void main(String[] args) {
		int[] candidates={2,4,1,5,5,4,1,2,4};
		int target=10;
		Solution40 solu = new Solution40();
		System.out.println(solu.combinationSum2(candidates,target));

	}

}


/*
 //30ms+
class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	//排序
    	Arrays.sort(candidates);
    	
    	
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer>  temp = new ArrayList<Integer>();//记录可能成为和为target的数组
    	List<Integer>  tempPoint = new ArrayList<Integer>();//记录temp中每个元素在candidates的位置
    	int len = candidates.length;
    	if(len==0)
    	{
    		return ans;
    	}
    	int sum = 0; //临时记录temp和值
    	if(temp.isEmpty())
    	{
    		temp.add(candidates[len-1]);
    		sum+=candidates[len-1];
    		tempPoint.add(len-1);
    	}
    	while(1==1){
    		int tempSizeSub = temp.size()-1;
    		int tempPointSizeSub = tempPoint.size()-1;
    	if(sum<target)
    	{
    		
    		if(tempPoint.get(tempPointSizeSub)>0)
    	{
    		temp.add(candidates[tempPoint.get(tempPointSizeSub)-1]);
    		sum+=candidates[tempPoint.get(tempPointSizeSub)-1];
    		tempPoint.add(tempPoint.get(tempPointSizeSub)-1);
    		
    	}else
    	{
    		if(tempPointSizeSub==0)
    		{
    			//去重
	    		List<List<Integer>> ansNew = new ArrayList<List<Integer>>();
	        	for(List<Integer> j : ans)
	        	{
	        		if(!ansNew.contains(j))
	        		{
	        			ansNew.add(j);
	        		}
	        	}
	        	
	        	
	    		return ansNew;
    		}
    		for(int i =tempPointSizeSub-1;i>=0;i--)
    		{
    			if(tempPoint.get(i)==(tempPointSizeSub-i))
    			{
    				if(i==0)
    				{
    					//去重
    		    		List<List<Integer>> ansNew = new ArrayList<List<Integer>>();
    		        	for(List<Integer> j : ans)
    		        	{
    		        		if(!ansNew.contains(j))
    		        		{
    		        			ansNew.add(j);
    		        		}
    		        	}
    		        	
    		        	
    		    		return ansNew;
    				}
    				continue;
    			}
    			else
    			{
    				int pointNew = tempPoint.get(i)-1;
    				for(int k =tempPointSizeSub;k >= i;k--)
    				{
    					sum-=temp.get(k);
    					temp.remove(k);
    					tempPoint.remove(k);
    				}
        			sum+=candidates[pointNew];
        			temp.add(candidates[pointNew]);
        			tempPoint.add(pointNew);
        			break;
    			}
    		}
    		
    		
    	}
    		}
    		
    	
    	else 
    	{
    		if(sum==target)
    		{
    			List<Integer> tempAnsAdd = new ArrayList<Integer>(temp);
    			ans.add(tempAnsAdd);
    		
    		}
    		int tempPointSizeSub1=tempPointSizeSub;
    		for(int i =tempPointSizeSub;i>=0;i--)
    		{
    			tempSizeSub = temp.size()-1;
    			tempPointSizeSub = tempPoint.size()-1;
    			if(tempPoint.get(i)>tempPointSizeSub1-i)
    			{
    				int pointNew = tempPoint.get(tempPointSizeSub)-1;
    				sum-=candidates[pointNew+1];
        			sum+=candidates[pointNew];
        			temp.remove(tempSizeSub);
        			tempPoint.remove(tempPointSizeSub);
        			temp.add(candidates[pointNew]);
        			tempPoint.add(pointNew);
        			break;
    			}
    			else
    			{
    				if(i==0)
    				{
    					
    					//去重
    		    		List<List<Integer>> ansNew = new ArrayList<List<Integer>>();
    		        	for(List<Integer> j : ans)
    		        	{
    		        		if(!ansNew.contains(j))
    		        		{
    		        			ansNew.add(j);
    		        		}
    		        	}
    		        	
    		        	
    		        	
    					return ansNew;
    				}else
    				{
    					sum-=candidates[tempPoint.get(i)];
    					temp.remove(tempSizeSub);
    					tempPoint.remove(tempPointSizeSub);
    				}
    			}
    			
    		}
    	}
    	}
    }
    
    
}
*/
//10ms+
class Solution40 {  
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> curr = new ArrayList<Integer>();
    Arrays.sort(candidates);
    helper(result, curr, 0, target, candidates);
    return result;
}
 
public void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates){
    if(target==0){
        result.add(new ArrayList<Integer>(curr));
        return;
    }
    if(target<0){
        return;
    }
 
    int prev=-1;
    for(int i=start; i<candidates.length; i++){
        if(prev!=candidates[i]){ // each time start from different element
            curr.add(candidates[i]);
            helper(result, curr, i+1, target-candidates[i], candidates); // and use next element only
            curr.remove(curr.size()-1);
            prev=candidates[i];
        }
    }
}
} 
