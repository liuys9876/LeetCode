package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { -1, 2, 1, -4 };
		int target = 1;
		Solution16 solu = new Solution16() {
		};
		System.out.println(solu.threeSumClosest(nums, target));

	}

}

class Solution16 {
	public int threeSumClosest(int[] nums, int target) {
		int ans = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		int s_point = 0, e_point = 0;// 开始位置与结束位置指针
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			s_point = i + 1;
			e_point = nums.length - 1;
			while (s_point < e_point) {
				int sum_temp = nums[i] + nums[s_point] + nums[e_point];
				if ((s_point != i + 1 && nums[s_point] == nums[s_point - 1]) || target - sum_temp > 0) {
					s_point++;
					if (Math.abs(target - sum_temp) < Math.abs(target-ans)) {
						ans = sum_temp;
					}
				} else if ((e_point != nums.length - 1 && nums[e_point] == nums[e_point + 1])
						|| target - sum_temp < 0) {
					e_point--;
					if (Math.abs(target - sum_temp) < Math.abs(target-ans)) {
						ans = sum_temp;
					}
				} else if (target - sum_temp == 0) {
					ans = target;
					return ans;
				}
			}
		}
		return ans;

	}
}