package leetcode;

public class NextPermutation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2,2,7,5,4,3,2,2,1};
		Solution31 solu = new Solution31();
		System.out.println(solu.nextPermutation(nums));
	}
}

/**
 * 
 * @author ys
 * @param 41321 right 与 right-1 比对 ，之后right 与 left 双指针 比对
 */
class Solution31 {
	public int[] nextPermutation(int[] nums) {

		int right = nums.length - 1;
		while (right > 0) {
			if (nums[right] > nums[right - 1]) {
				if (right == nums.length - 1) {
					nums=ChangeOrder(nums, right-1, right );
					return nums;
				} else {
					int left = right - 1;
					right += 1;
					int count = 0; // 记录nums[left]与nums[right]相等次数
					while (right < nums.length) {

						if (nums[left] > nums[right]) {
							int temp = 0;
							temp = nums[right - 1 - count];
							nums[right - 1 - count] = nums[left];
							nums[left] = temp;
							nums=ChangeOrder(nums, left + 1, nums.length - 1);
							return nums;
						} else {
							if (nums[left] == nums[right]) {
								count++;
							}
						}
						right++;
						if (right == nums.length) {
							if (nums[left] < nums[right - 1]) {
								int temp = 0;
								temp = nums[right - 1];
								nums[right - 1] = nums[left];
								nums[left] = temp;
							} else {
								int temp = 0;
								temp = nums[right - count - 1];
								nums[right - count - 1] = nums[left];
						 		nums[left] = temp;
							}
							nums=ChangeOrder(nums, left + 1, nums.length - 1);
							return nums;
						}

					}

				}
			} else {
				right--;
			}
		}
		if (right == 0) 
			nums=ChangeOrder(nums, 0, nums.length - 1);
		return nums;
	}
	private int[] ChangeOrder(int[] nums,int beginNum,int endNum)
	{
		for (int i = 0; i < (endNum - beginNum +1) / 2; i++) {
			int temp;
			temp = nums[i + beginNum];
			nums[i + beginNum] = nums[endNum - i];
			nums[endNum - i] = temp;
		}
		
		
		return nums;
	}
}
