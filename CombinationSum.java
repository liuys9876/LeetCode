package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates={8,3,2,3,6,3,7};
		int target=7;
		Solution39 solu = new Solution39();
		System.out.println(solu.combinationSum(candidates,target));

	}

}



class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	//去重排序
    	Set<Integer> s = new TreeSet<Integer>();
    	for(int i : candidates)
    	{
    		s.add(i);
    	}
    	int[] can = new int[s.size()];
    	int j=0;
    	for(int i :s)
    	{
    		can[j++]=i;
    	}
    	
    	
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer>  temp = new ArrayList<Integer>();//记录可能成为和为target的数组
    	List<Integer>  tempPoint = new ArrayList<Integer>();//记录temp中每个元素在candidates的位置
    	int len = can.length;
    	if(len==0)
    	{
    		return ans;
    	}
    	int sum = 0; //临时记录temp和值
    	if(temp.isEmpty())
    	{
    		temp.add(can[len-1]);
    		sum+=can[len-1];
    		tempPoint.add(len-1);
    	}
    	while(1==1){
    		int tempSizeSub = temp.size()-1;
    		int tempPointSizeSub = tempPoint.size()-1;
    	if(sum<target)
    	{
    		temp.add(temp.get(tempSizeSub));
    		sum+=temp.get(tempSizeSub);
    		tempPoint.add(tempPoint.get(tempPointSizeSub));
    	}
    	else 
    	{
    		if(sum==target)
    		{
    			List<Integer> tempAnsAdd = new ArrayList<Integer>(temp);
    			ans.add(tempAnsAdd);
    		
    		}
    		for(int i =tempPointSizeSub;i>=0;i--)
    		{
    			tempSizeSub = temp.size()-1;
    			tempPointSizeSub = tempPoint.size()-1;
    			if(tempPoint.get(i)>0)
    			{
    				int pointNew = tempPoint.get(tempPointSizeSub)-1;
    				sum-=can[pointNew+1];
        			sum+=can[pointNew];
        			temp.remove(tempSizeSub);
        			tempPoint.remove(tempPointSizeSub);
        			temp.add(can[pointNew]);
        			tempPoint.add(pointNew);
        			break;
    			}
    			else
    			{
    				if(i==0)
    				{
    					return ans;
    				}else
    				{
    					sum-=can[0];
    					temp.remove(tempSizeSub);
    					tempPoint.remove(tempPointSizeSub);
    				}
    			}
    			
    		}
    	}
    	}
    }
    
    
}
/*
class Solution39 {  
        List<List<Integer>> ans = new ArrayList<List<Integer>>();  
        int[] cans = {};  
          
        public List<List<Integer>> combinationSum(int[] candidates, int target) {  
            this.cans = candidates;  
            Arrays.sort(cans);  
            backTracking(new ArrayList(), 0, target);  
            return ans;  
        }  
          
        public void backTracking(List<Integer> cur, int from, int target) {  
            if (target == 0) {  
                List<Integer> list = new ArrayList<Integer>(cur);  
                ans.add(list);  
            } else {  
                for (int i = from; i < cans.length && cans[i] <= target; i++) {  
                    cur.add(cans[i]);  
                    backTracking(cur, i, target - cans[i]);  
                    cur.remove(new Integer(cans[i]));  
                }  
            }  
        }  
    } 
    */ 