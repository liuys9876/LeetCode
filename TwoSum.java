package leetcode;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solu = new Solution() {
		};
		int[] nums = new int[] { 11,15 , 2,  7};
		int target = 9;
		int[] ans = new int[2];
		ans=solu.twoSum(nums, target);
		System.out.println(ans[0]);
		System.out.println(ans[1]);

	}

}

class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		int NumsLength = nums.length;
		loop: {
			for (int i = 0; i < NumsLength - 1; i++) {
				for (int j = i + 1; j < NumsLength; j++) {
					if (target == (nums[i] + nums[j])) {
						ans[0] = i;
						ans[1] = j;
						break loop;
					} else {
						continue;
					}
				}
			}

		}

		return ans;

	}
}