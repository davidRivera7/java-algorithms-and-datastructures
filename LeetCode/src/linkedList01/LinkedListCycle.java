//it is perfect 
package linkedList01;

import linkedList01.List.ListNode;

public class LinkedListCycle {
    
    public static boolean hasCycle(ListNode head) {
        
        if (head == null)
            return false;                
        
        ListNode current = head;               
                
        while (current != current.next && current.next != null) { //compruebo que no exista un ciclo de el nodo actual a el mismo y con la segunda ... || (aqui) -> compruebo si ya es null, eso quiere decir que no es una lista circular
            
            ListNode pointer = head;
            
            while (pointer != current) {
                if (current.next == pointer)
                    return true;
                
                pointer = pointer.next;
            }
                
            
            current = current.next;
        }
                                                                    
        return current == current.next;        
    }
    
    public static void main(String[] args) {
        List list = new List();
        
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);               
        
        list.end.next = list.head.next;
        
        System.out.println(hasCycle(list.head));
    }
    
}
