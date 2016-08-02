package leetcode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(1);
		ListNode temp;
		ListNode head = new ListNode(1);
		temp=head;
		ListNode head1 = new ListNode(2);
		head.next=head1;
		head=head.next;
		ListNode head2 = new ListNode(3);
		head.next=head2;
		head=head.next;
		Solution21 solu = new Solution21(){};
		System.out.println(solu.mergeTwoLists(l1, temp));
	}

}
class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	/*
    	ListNode ans = new ListNode(0);
    	ListNode temp = new ListNode(0);
    	ListNode l = new ListNode(0);
    	if(l1==null&&l2==null)
    	{
    		return l1;
    	}
    	else if(l1==null&&l2!=null)
    	{
    		return l2;
    	}
    	else if(l1!=null&&l2==null)
    	{
    		return l1;
    	}
    	else{
    	if(l1.val>=l2.val)
    	{
    		ans=l2;
    		l=ans;
    	}
    	else{
    		ans=l1;
    		l=ans;
    	}
    	while(true){
    		if(l1.val>=l2.val)
    		{
    	while(l2!=null&&l1.val>=l2.val)
    	{
    		l=l2;
    		l=l.next;
    		temp=l2;
    		l2=l2.next;
    	}if(l2==null)
    		{
    			l=l1;
    			l2=l1;
    			return ans;
    		}   		
    	else{
    		
    		temp.next=l1;
    	}
    		
    		}
    	else{
    		while(l1!=null&&l1.val<l2.val)
        	{
    			l=l1;
    			l=l.next;
        		temp=l1;
        		l1=l1.next;
        	}
    		if(l1==null)
    		{
    			l=l2;
    			l1=l2;
    			return ans;
    		}  
    		else{
        		
        		temp.next=l2;
        	}
        		
        		}
    	
    	}
    	}
    	*/
        
    	/*
    	ListNode ans = new ListNode(0);
    	ListNode temp = new ListNode(0);
    	
    	if(l1==null&&l2==null)
    	{
    		return l1;
    	}
    	else if(l1==null&&l2!=null)
    	{
    		return l2;
    	}
    	else if(l1!=null&&l2==null)
    	{
    		return l1;
    	}else
    	{
    	
    	if(l1.val>=l2.val)
    	{
    		temp=l2;
    		ans.next=temp;
    		l2=l2.next;
    		temp=temp.next;
    		if(l2==null)
    		{
    			temp=l1;
    			return ans.next;
    		}
    	}else
    	{
    		temp=l1;
    		ans.next=temp;
    		l1=l1.next;
    		temp=temp.next;
    		if(l1==null)
    		{
    			temp=l2;
    			return ans.next;
    		}
    	}
    	
    	
    	while(true)
    	{
    		if(l1.val>=l2.val)
    		{
    			temp=l2;
    			l2=l2.next;
    			temp=temp.next;
    			if(l2==null)
    			{
    				temp=l1;
    				return ans.next;
    			}
    			
    		}else
    		{
    			temp=l1;
    			l1=l1.next;
    			temp=temp.next;
    			if(l1==null)
    			{
    				temp=l2;
    				return ans.next;
    			}
    		}
    	}
    	
    	}
    	*/
    	
    	 ListNode p,q,r,head;  
         if(l1 == null && l2 == null){  
            return null;  
         }  
          if(l1 == null){  
              return l2;  
         }  
          if(l2 == null){  
             return l1;  
         }  
         // if(p == null && q == null){  
         //     return l1;  
         // }  
         p = l1;  
         q = l2;  
         head = null;  
         if(p.val <= q.val){  
                // r->next = p;  
                 head = p;  
                 p = p.next;  
             }  
         else{  
                 head = q;  
                 q = q.next;  
                 // r->next = q;  
                 // r-next = p;  
             }  
             r = head;  
         while(p != null && q != null){  
             if(p.val <= q.val){  
                // r->next = p;  
                 r.next = p;  
                 r = p;  
                 p = p.next;  
             }  
             else{  
                 r.next = q;  
                 r = q;  
                   
                 q = q.next;  
                 // r->next = q;  
                 // r-next = p;  
                   
             }  
         }  
         if(p == null){  
             while(q != null){  
                 r.next = q;  
                 r = q;  
                 q = q.next;  
             }  
         }  
         else{  
             while(p != null){  
                 r.next = p;  
                 r = p;  
                 p = p.next;  
             }  
         }  
         return head;  
    }
}