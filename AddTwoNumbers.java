package leetcode;
/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	ListNode p1 = l1;
	        ListNode p2 = l2;
	        ListNode p3 = new ListNode(0);
	        ListNode re =p3;
	        int carry=0;
	        
	        while(p1!=null||p2!=null)
	        {
	           
	        if(p1!=null)
	        {
	          carry+= p1.val;
	          p1=p1.next;
	        }
	        
	        if(p2!=null)
	        {
	          carry+= p2.val;
	          p2=p2.next;
	        }
	        re.next= new ListNode(carry%10);
	        re=re.next;
	        carry/=10;
	        }
	        
	        if(carry==1)
	        re.next = new ListNode(1);
	        
	        return p3.next;
	        
	    }
	}
}
