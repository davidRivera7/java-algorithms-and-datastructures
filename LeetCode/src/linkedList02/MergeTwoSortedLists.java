//it is correct
package linkedList02;

import linkedList01.List;
import linkedList01.List.ListNode;

public class MergeTwoSortedLists {
    
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    
        if (list1 == null || list2 == null)
            return (list1 == null) ? list2 : list1;
                    
        ListNode newHead;
        if (list1.val < list2.val) {//colocamos cabeza
            newHead = list1;
            list1 = list1.next;
        } else {
            newHead = list2;
            list2 = list2.next;
        }
        
        ListNode pointerHead = newHead;
        
        while (list1 != null && list2 != null) { //comprobar quien sigue
            
            if (list1.val < list2.val) {
                
                newHead.next = list1;
                newHead = newHead.next;
                list1 = list1.next;                
            } else {
                
                newHead.next = list2;
                newHead = newHead.next;
                list2 = list2.next;
            }
            
        }
        
        ListNode more = (list1 != null) ? list1 : list2; //terminar de enlazar lo faltante
        while (more != null) {
            newHead.next = more;
            newHead = newHead.next;
            more = more.next;
        }
                
        return pointerHead;        
    }
    
    public static void main(String[] args) {
        List list1 = new List();        
        list1.insertEnd(-9);
        list1.insertEnd(3);
        
        List list2 = new List();
        list2.insertEnd(5);
        list2.insertEnd(7);
        
        List.print(mergeTwoLists(list1.head, list2.head));
    }
    
}
