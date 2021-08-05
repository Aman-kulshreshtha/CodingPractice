class Main  {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }


     public static boolean isPalindrome(ListNode head) {
      
        int n = 0;
        ListNode ptr = head;
        
        while(ptr != null) {
            
            n++;
            ptr = ptr.next;
            
        }
        if(n<=1) return true;
        
        int mid = (n%2 == 0)? (n-1)/2:(n/2);
        //System.out.println(n+" "+ mid);
        
        ListNode m = head;
        
        
        for(int i =0 ; i < mid; i++) {
            
            m = m.next;
           
            
        }
       
        
        ListNode head2 = m.next;
        m.next = null;
        
        
        ListNode pre = null;
        ListNode ptr = head2;
        
        while(ptr.next != null ) {
            
            ListNode temp = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = temp; 
            
        }
        head2 = pre;
        
        while(head != null && head2 != null) {
            System.out.println(head.val+" "+ head2.val);
            if(head.val != head2.val) return false;
            
            else {
                
                head = head.next;
                head2 = head2.next;
                
            }
        }
     
    
        
        
        return true;
        
    }


}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
