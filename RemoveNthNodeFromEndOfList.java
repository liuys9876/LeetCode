package leetcode;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		ListNode temp;
		ListNode head = new ListNode(1);
		temp=head;
		ListNode head1 = new ListNode(2);
		head.next=head1;
		head=head.next;
		ListNode head2 = new ListNode(3);
		head.next=head2;
		head=head.next;
		Solution19 solu = new Solution19() {
		};
		ListNode temp2=solu.removeNthFromEnd(temp, n);
		do{
			System.out.println(temp2.val);
			temp2=temp2.next;
		}
		while(temp2.next!=null);
		System.out.println(temp2.val);

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		 ListNode p1 = head;  
	        ListNode p2 = head;  
	        ListNode removeNode = head;  
	        int i = 0;  
	        while(p1!=null){  
	            p1 = p1.next;  
	            i++;  
	            if(i > n){  
	                p2 = removeNode;  
	                removeNode = removeNode.next;  
	            }  
	        }  
	          
	        if(removeNode == head){  
	            head = head.next;  
	        }else{  
	            p2.next = removeNode.next;  
	        }  
	        return head;  
		
		/*
		ListNode end = head;
		ListNode pre =head;
		ListNode temp =head;
		if(head==null)
		{
			return head;
		}
		//求出链表长度
		int count=0;
       if(head.next!=null)
       {
    	   count++;
    	   head=head.next;
       }
       if(n>count+1)
       {
    	   return null;
       }
       else
       {
    	   for(int i =0 ;i<(count+1-n) ; i++)
    	   {
    		   pre.next=end;
    		   temp=pre;	
    		   end=end.next;
    	   }
    	   
    	   pre.next=end.next;
       
       }return pre.next;
        
        
        
        */
    }
}