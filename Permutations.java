package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4 };
		Solution46 solu = new Solution46();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.permute(nums));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));

	}

}

class Solution46 {

	public List<List<Integer>> permute(int[] nums) {
		List<Integer> l = new ArrayList<Integer>();
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return ll;
		}
		if (nums.length == 1) {
			l.add(nums[0]);
			ll.add(l);
			return ll;
		}
		// nums 转 list
		for (int i : nums) {
			l.add(i);
		}

		HashSet<List<Integer>> s = new HashSet<List<Integer>>();
		swapNext(0, l.size(), l, s);

		//Set<List<Integer>> s = new HashSet<List<Integer>>(ll);
		ll.clear();
		ll.addAll(s);

		return ll;

	}

	// 交换两数位置
	private void swap(int point1, int point2, List<Integer> l) {
		int temp = l.get(point1);
		l.set(point1, l.get(point2));
		l.set(point2, temp);
	}

	// 树形依次交换startPoint位置之后的位置数值,第i位依次与其之后的位置进行数值交换
	private void swapNext(int startPoint, int endPoint, List<Integer> l, HashSet<List<Integer>> ll) {
		if (startPoint < endPoint) {
			int point = startPoint;
			for (int i = point; i < endPoint; i++) {
				List<Integer> tempListl = new ArrayList<Integer>(l);
				swap(startPoint, i, tempListl);
				ll.add(tempListl);
				swapNext(startPoint + 1, endPoint, tempListl, ll);
			}
		}
	}

}
