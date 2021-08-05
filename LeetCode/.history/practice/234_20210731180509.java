import java.io.*;
import java.util.*;



public class 234  {
    
    public static void main(String[] args) {
        
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
        
        while(head2.next != null ) {
            
            ListNode temp = head2.next;
            head2.next = pre;
            pre = head2;
            head2 = temp; 
            
        }
        
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