
package DobleList;

public class List {
    private class Node {
        private int value;
        private Node next;
        private Node former;
        
        Node(int value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value + "";
        }
    }
    
    private Node head;
    private Node end;
    private int size;
    
    void insertHead(int value) {
        if (head == null) 
            head = end = new Node(value);                    
        else {
            Node newNode = new Node(value);
            newNode.next = head;
            head.former = newNode;
            head = newNode;
        }                    
        size++;
    }
    
    void insertEnd(int value) {
        if (head == null)
            head = end = new Node(value);
        else {
            Node newNode = new Node(value);
            newNode.former = end;
            end.next = newNode;
            end = newNode;
        }
        size++;
    }
    
    void insertAt(int pos, int value) {
        if (pos == 0) {
            insertHead(value);
            return;
        }
        
        if (pos > size - 1) {
            insertEnd(value);
            return;
        }
        
        int i = 0;
        Node pointer = head;
        
        while (i < pos) {
            pointer = pointer.next;
            i++;
        }
        
        Node newNode = new Node(value);
        newNode.next = pointer;
        newNode.former = pointer.former;
        
        newNode.former.next = newNode;
        newNode.next.former = newNode;
        size++;
    }
    
    void headToEnd() {
        Node pointer = head;
        
        while (pointer != null) {
            System.out.print(pointer + " -> ");
            pointer = pointer.next;
        }        
        System.out.println("");
    }
    
    void endToHead() {
        Node pointer = end;
        
        while (pointer != null) {
            System.out.print(pointer + " -> ");
            pointer = pointer.former;
        }
        System.out.println("");
    }
    
    int getSize() {
        return size;
    }
    
    void deleteHead() {
        if (head == null)
            return;
            
        if (head == end) {
            head = end = null;
            size = 0;
            return;
        }
            
        head = head.next;
        head.former = null;         
        size--;        
    }
    
    void deleteEnd() {
        if (head == null)
            return;
        
        if (head == end) {
            head = end = null;
            size = 0;
            return;
        }
            
        end = end.former;
        end.next = null;
        size--;
    }
    
    void deleteAt(int pos) {
        if (head == null) 
            return;
        
        if (pos == 0) {
            deleteHead();
            return;
        }
        
        if (pos >= size - 1) {
            deleteEnd();
            return;
        }
        
        int i = 0;
        Node pointer = head;
        
        while (i < pos) {
            pointer = pointer.next;
            i++;
        }
        
        pointer.former.next = pointer.next;
        pointer.next.former = pointer.former;
        size--;
    }
    
    int getFirstPosElement(int value) {
        int i = 0;
        Node pointer = head;
        
        while (pointer != null && pointer.value != value) {
            pointer = pointer.next;
            i++;
        }
        
        return (pointer == null) ? -1 : i;
    }
    
    String getPosElement(int e) {
        int i = 0;
        String elements = "";
        Node pointer = head;
        
        while (pointer != null) {            
            if (pointer.value == e)
                elements += i + " - ";   
            
            pointer = pointer.next;
            i++;
        }
        
        return elements;        
    }
    
    public static void main(String[] args) {
        List l = new List();
        
        l.insertHead(1);
        l.insertHead(2);
        l.insertHead(3);
        l.insertHead(4);
        l.insertHead(5);                
        l.insertHead(3);  
        l.insertEnd(2);
        l.insertEnd(5);
        l.insertEnd(9);
        l.insertEnd(8);
                       
        l.headToEnd();
        l.endToHead();
        System.out.println("Size: " + l.getSize());
        
        l.insertAt(3, 8);
        l.headToEnd();
        l.endToHead();
        System.out.println("Size: " + l.getSize());
        
        l.deleteAt(2);        
        l.headToEnd();        
        System.out.println("Size: " + l.getSize());
        int searchElement = 5;
        System.out.println("Position of '" + searchElement + "': " + l.getFirstPosElement(searchElement));
        System.out.println("Positions of '" + searchElement + "': " + l.getPosElement(searchElement));
    }
}
