
package linkedList01;

public class List {
    public class ListNode {
        public int val;
        public ListNode next;
        
        ListNode(int value) {
            this.val = value;
            next = null;
        }

        @Override
        public String toString() {
            return val + "";
        }                
    }
    
    public ListNode head;
    public ListNode end;    
    
    public void insertEnd(int x) {
        if (head == null) {
            head = end = new ListNode(x);
            return;
        }
        
        end.next = new ListNode(x);
        end = end.next;
    }
    
    public static void print(ListNode head) {        
        
        while (head != null) {
            System.out.print(head + ", ");
            head = head.next;
        }
        
        System.out.println("");             
    }
    
}
