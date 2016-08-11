package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={2,3};
		Solution46 solu = new Solution46();
		long timestart=System.currentTimeMillis();
		System.out.println(solu.permute(nums));
		long timeend = System.currentTimeMillis();
		System.out.println("s:"+timestart+"e:"+timeend+"t:"+(timeend-timestart));
	
	}

}



class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        List<List<Integer>> ll = new  ArrayList<List<Integer>>();
        nums[nums.length-1]=(Integer) null;
   	 	ll=permute(nums);
        for(int i = 0 ;i<ll.size();i++)
        {
        	 
        }
        return ll;
    }
   
}


