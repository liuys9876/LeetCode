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
    	//»•÷ÿ≈≈–Ú
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
    	List<Integer>  temp = new ArrayList<Integer>();
    	int MaxIntPoint = can.length-1;
    	int Point = MaxIntPoint;
    	int sum=0;
    	while(MaxIntPoint>=0)
    	{
    	
    		if(temp.isEmpty())
    		{
    			if(can[MaxIntPoint]>target)
    			{
    				MaxIntPoint--;
    				Point--;
    			}
    			else if(can[MaxIntPoint]==target)
    			{
    				temp.add(can[MaxIntPoint]);
    				ans.add(temp);
    				temp.clear();
    				MaxIntPoint--;
    				Point--;
    			}
    			else
    			{
    				temp.add(can[MaxIntPoint]);
    				sum+=can[MaxIntPoint];
    			}
    		}
    		else
    		{
    			if(sum+can[Point)
    		}
    	}    	
    	return ans;
    }
    
    
    private List<List<Integer>> chargeSum (int[] candidates, int target,List<List<Integer>> ansList,int sum,List<Integer> tempList,int startPoint,int endPoint)
    {
    	if(startPoint<0)
    	{
    		
    	}else
    	{
    	if(sum+candidates[startPoint]<target)
    	{
    		sum+=candidates[startPoint];
    		tempList.add(candidates[startPoint]);
    	ansList=chargeSum(candidates, target, ansList, sum, tempList,startPoint,endPoint);	
    	}
    	else if(sum+candidates[startPoint]==target)
    	{
    		for(int i=startPoint-1;i>0;i--)
    		{
    		if(candidates[i]!=candidates[startPoint])
    		{
    			sum-=candidates[startPoint];
    			tempList.add(candidates[startPoint]);
    			ansList.add(tempList);
    			tempList.remove(tempList.size()-1);
    			sum+=candidates[i];
    			tempList.add(candidates[i]);
    			startPoint=i-1;
    			ansList=chargeSum(candidates, target, ansList, sum, tempList, startPoint, endPoint);
    			break;
    		}
    		}
    		
    		
    	}
    	else
    	{
    		
    	}
    	}
    	return ansList;
    }
}