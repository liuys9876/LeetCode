package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates={};
		int target=0;
		Solution39 solu = new Solution39();
		System.out.println(solu.combinationSum(candidates,target));

	}

}



class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer>  temp = new ArrayList<Integer>();
    	return ans;
    }
}