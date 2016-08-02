package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {-1,0,1,2,-1,-4};
		int target = -1;
		Solution18 solu = new Solution18() {
		};
		System.out.println(solu.fourSum(nums, target));
	}

}
class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
		// 快速排序
		Arrays.sort(nums);// 从小到大
		int sum = 0;
		int point_3=0,point_4=0;//开始位置与结束位置指针
		for (int point_1 = 0; point_1 < nums.length - 3; point_1++) {
			
			if(point_1>0&&nums[point_1]==nums[point_1-1])
			{
				continue;
			}
			for (int point_2 = point_1+1; point_2 < nums.length - 2; point_2++) {
			
				if(point_2>point_1+1&&nums[point_2]==nums[point_2-1])
				{
					continue;
				}
			
			
			point_3=point_2+1;
			point_4=nums.length-1;
			while(point_3<point_4)
			{
				int sum_temp = nums[point_1] + nums[point_2] + nums[point_3]+nums[point_4];
					if ((point_3!=point_2+1&&nums[point_3]==nums[point_3-1])||target-sum_temp > 0) {
						point_3++;
					} else if ((point_4!=nums.length-1&&nums[point_4]==nums[point_4+1])||target-sum_temp < 0) {
						point_4--;
					} else if (target-sum_temp == 0) {
						List<Integer> temp = new ArrayList<Integer>();
						// 按从小到大的顺序排列add
						temp.add(nums[point_1]);
						temp.add(nums[point_2]);
						temp.add(nums[point_3]);
						temp.add(nums[point_4]);
						ans.add(temp);
						point_3++;
						point_4--;
					} 				
				}
		}}
		return ans;
		
        
    }
}