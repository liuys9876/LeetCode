package leetcode;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		int k=0;
		Solution61 solu = new Solution61();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.rotateRight(head, k));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));
	}

}
class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        return head;
    }
}
							