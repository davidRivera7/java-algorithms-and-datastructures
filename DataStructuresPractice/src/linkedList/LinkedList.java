
package linkedList;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;
        
        Node(int value) {
            this.value = value;
            next = null;
        }
        
        @Override
        public String toString() {
            return value + "";
        }        
    }
    
    private Node start;
    
    void insertStart(int value) {
        if (start == null) {
            start = new Node(value);
            return;
        }
        
        Node newNode = new Node(value);
        newNode.next = start;
        start = newNode;
    }
        
    void insertEnd(int value) {
        if (start == null) {
            start = new Node(value);
            return;
        }
        
        Node pointer = start;
        while (pointer.next != null) 
            pointer = pointer.next;
        
        pointer.next = new Node(value);
    }
    
    void insertAt(int pos, int value) { 
        if (pos == 0) {
            insertStart(value);
            return;
        }
        
        Node pointer = start;
        int i = 0;
        
        while (i < pos - 1 && pointer.next != null) {
            i++;
            pointer = pointer.next;
        }

        if (pointer == null) {
            insertEnd(value);
            return;
        }

        Node nodeContinue = pointer.next;
        Node newNode = new Node(value);
        pointer.next = newNode;
        newNode.next = nodeContinue;
    }
    
    void deleteStart() {
        if (start == null)
            return;
        
        start = start.next;
    }            
    
    void deleteEnd() {
        if (start == null)
            return;
        
        Node pointer = start;
        while(pointer.next != null && pointer.next.next != null)
            pointer = pointer.next;
        
        if (pointer == start) {
            start = null;
            return;
        }
            
        pointer.next = null;
    }
    
    void deleteAt(int pos) {
        if (start == null)
            return;
        
        if (pos == 0) {
            deleteStart();
            return;
        }
        
        int i = 0;
        Node pointer = start;
        
        while (i < pos - 1 && pointer.next != null) {
            pointer = pointer.next;
            i++;
        }
        
        if (pointer.next == null)
            return;
        
        pointer.next = pointer.next.next;        
    }
    
    void travelList() {
        Node pointer = start;
        while (pointer != null) {
            System.out.print(pointer + " ");
            pointer = pointer.next;
        }
    }        
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.insertAt(0, 1);
        list.insertAt(0, 2);
        list.insertAt(0, 3);
        list.insertAt(10, 4);
        list.insertAt(2, 5);                
        list.insertStart(9);
        list.insertAt(4, 5);
        list.insertEnd(111);
                                
        list.travelList();
        System.out.println("");
//        list.deleteAt(0);
//        list.deleteAt(0);
        list.deleteAt(1);        
        list.travelList();        
        list.deleteAt(5);
        System.out.println("");
        list.travelList();        
        list.deleteAt(4);
        System.out.println("");
        list.travelList();        
        list.deleteAt(4);
        System.out.println("");
        list.travelList();        
    }
    
}
