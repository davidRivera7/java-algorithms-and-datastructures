
package torreshanoi;

public class Stack {    
    private class Node{
        private int number;
        private Node next;        

        public Node(int element) {
            this.number = element;            
        }                      
    }
    
    private Node head;    
    private int size;
    
    public boolean insert(int number) {
        Node node = new Node(number);
        if (head == null) {
            head = node;
            size++;
            return true;
        } else if (head.number > number) {
            node.next = head;
            head = node;
            size++;
            return true;
        }
        return false;
    }
    
    public Node getHead() {
        if (head != null) 
            return head;
        return null;
    }
    
    public int getValue() {
        return head.number;
    }
        
    public int unstack() {
        if (head != null) {
            Node eliminate = head;
            head = head.next;            
            size--;
            return eliminate.number;
        }
        return 0;
    }        
    
    public int getSize() {
        return size;
    }
    
    @Override
    public String toString() {        
        String s = "";
        Node pointer = head;
        while (pointer != null) {
            s += pointer.number + "\n";
            pointer = pointer.next;
        }                
        return s;
    }
    
}
