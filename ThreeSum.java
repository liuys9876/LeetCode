package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
		Solution15 solu = new Solution15() {
		};
		System.out.println(solu.threeSum(nums));
	}

}

class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
		/*
		 * method1
		 * 20ms
		 * 
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		// 快速排序
		Arrays.sort(nums);// 从小到大
		int sum = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				break;
			}
			if(i>0&&nums[i]==nums[i-1])
			{
				continue;
			}
			for (int j = i + 1; j < nums.length-1; j++) {
			if(j>i+1&&nums[j]==nums[j-1])
			{
				continue;
			}
				if(nums[i] + nums[j] + nums[j+1]>0)
				{break;}
				else
				{
				for (int k = j + 1; k < nums.length; k++) {
				if(k>j+1&&nums[k]==nums[k-1])
			{
				continue;
			}
					if (nums[k] < 0) {
						continue;
					} else {
						int sum_temp = nums[i] + nums[j] + nums[k];
						if (sum_temp < 0) {
							continue;
						} else if (sum_temp == 0) {
							List<Integer> temp = new ArrayList<Integer>();
							// 按从小到大的顺序排列add
							temp.add(nums[i]);
							temp.add(nums[j]);
							temp.add(nums[k]);
							Collections.sort(temp);
							ans.add(temp);
							break;
						} else {
							break;
						}
					}
				}
				}
			}

		}
		return ans;
			*/
		
		
		/*
		 * method2
		 * 10ms
		 */
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		// 快速排序
		Arrays.sort(nums);// 从小到大
		int sum = 0;
		int s_point=0,e_point=0;//开始位置与结束位置指针
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				break;
			}
			if(i>0&&nums[i]==nums[i-1])
			{
				continue;
			}
			s_point=i+1;
			e_point=nums.length-1;
			while(s_point<e_point&&nums[e_point] >=0)
			{
				int sum_temp = nums[i] + nums[s_point] + nums[e_point];
					if ((s_point!=i+1&&nums[s_point]==nums[s_point-1])||sum_temp < 0) {
						s_point++;
					} else if ((e_point!=nums.length-1&&nums[e_point]==nums[e_point+1])||sum_temp > 0) {
						e_point--;
					} else if (sum_temp == 0) {
						List<Integer> temp = new ArrayList<Integer>();
						// 按从小到大的顺序排列add
						temp.add(nums[i]);
						temp.add(nums[s_point]);
						temp.add(nums[e_point]);
						ans.add(temp);
						s_point++;
						e_point--;
					} 				
				}
		}
		return ans;
	}
}