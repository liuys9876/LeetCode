package leetcode;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 2 };
		Solution26 solu = new Solution26() {
		};
		System.out.println(solu.removeDuplicates(nums));

	}

}

class Solution26 {
	public int removeDuplicates(int[] nums) {
		int ans = 1;
		if (nums.length == 0) {
			ans = 0;
		} else {
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] != nums[i - 1]) {
					nums[ans]=nums[i];
					ans++;
				}
			}
		}
		return ans;

	}
}