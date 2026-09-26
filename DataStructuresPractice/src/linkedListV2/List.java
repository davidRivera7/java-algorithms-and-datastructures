
package linkedListV2;

public class List {
    public class Node {
        int value;
        Node next;
        
        public Node(int value) {
            this.value = value;
        }
                        
        @Override
        public String toString() {
            return value + "";
        }
    }
    
    private Node head;
    private int size;    
    
    public void insertStart(int value) {
        Node newNode = new Node(value);
        if (head != null) 
            newNode.next = head;
        
        head = newNode;        
        size++;        
    }
    
    public void insertEnd(int value) {
        if (head == null) 
            head = new Node(value);
        else {
            Node pointer = head;
            
            while (pointer.next != null)
                pointer = pointer.next;
            
            pointer.next = new Node(value);
        }            
        size++;
    }
    
    public void insertAt(int pos, int value) {
        if (pos == 0) {
            insertStart(value);
            return;
        }
        
        if (pos > size - 1) {
            insertEnd(value);
            return;
        }
            
        Node pointer = head;                
        int i = 0;
        
        while(i < pos - 1) {
            pointer = pointer.next;
            i++;
        }
        
        Node nodeContinue = pointer.next;
        Node newNode = new Node(value);
        pointer.next = newNode;
        newNode.next = nodeContinue;
        size++;
    }
    
    public void deleteStart() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }
    
    public void deleteEnd() {            
        if (size == 0)
            return;
        
        if (size == 1) {
            head = null;
            size = 0;
            return;
        }
        
        Node pointer = head;
        int i = 1;
        while (i < size - 1) {
           pointer = pointer.next;
           i++;
        }
            
        pointer.next = null;  
        size--;
    }
    
    public void deleteAt(int pos) {
        if (pos == 0) {
            deleteStart();
            return;
        }
        
        if (pos >= size - 1) {
            deleteEnd();
            return;
        }
        
        Node pointer = head;
        int i = 0;
        
        while (i < pos - 1) {
            pointer = pointer.next;
            i++;
        }
        
        pointer.next = pointer.next.next;
        size--;
    }

    public int getSize() {
        return size;
    }
    
    public void printList() {
        Node pointer = head;
        
        while (pointer != null) {
            System.out.print(pointer + " ");
            pointer = pointer.next;
        }
    }
    
    public static void main(String[] args) {
        List list = new List();
        
        list.insertAt(0, 1);
        list.insertAt(0, 2);
        list.insertAt(0, 3);
        list.insertAt(0, 4);
        list.insertAt(10, 5);
        list.printList();
        list.insertAt(4, 6);
        System.out.println("");
        list.printList();
        list.insertAt(2, 8);
        System.out.println("");
        list.printList();
//        list.insertAt(0, 4);
//        list.insertAt(0, 4);      
        System.out.println("\nSize: " + list.getSize());
        
        list.deleteAt(3);
        list.printList();
        list.deleteAt(2);
        System.out.println("");
        list.printList();
        list.deleteAt(1);
        System.out.println("");
        list.printList();
        System.out.println("\nSize: " + list.getSize());
        
        //lista correcta
    }
}
