
package doblelist;

public class DobleList {
    private class Node{
        private final int number;
        private Node next;        
        private Node former;

        public Node(int number) {
            this.number = number;
        }      

        @Override
        public String toString() {
            return number + "";
        }               
    }
    
    private Node start;
    private Node end;
    private int size;
    
    public void insertAtStart(int number) {
        Node node = new Node(number);
        if (start == null) {
            start = end = node;             
        } else {
            node.next = start;
            start.former = node;
            start = node;            
        }        
        size++;
    }
    
    public void insertAtEnd(int number) {
        Node node = new Node(number);
        if (start == null) {
            start = end = node;                        
        } else {
            end.next = node;
            node.former = end;
            end = node;                        
        }
        size++;
    }
    
    public void insertAt(int pos, int value) {
        if (pos >= 0) {
            if (pos == 0 || start == null) {
                insertAtStart(value);
            } else if (pos >= size) {
                insertAtEnd(value);
            } else {
                Node node = new Node(value);
                int current = 1;
                Node pointer = start;       
                Node middle;
                
                while (current < pos) {
                    pointer = pointer.next;
                    current++;
                }
                
                middle = pointer.next;
                
                node.next = middle;
                middle.former = node;
                
                pointer.next = node;
                node.former = pointer;                                
                size++;
            }            
        }        
    }        
    
    public void travelAtStart() {
        Node pointer = start;
        while (pointer != null) {
            System.out.print(pointer + " - ");
            pointer = pointer.next;
        } 
        System.out.println("");
    }
    
    public void travelAtEnd() {
        Node pointer = end;
        while(pointer != null) {
            System.out.print(pointer + " - ");
            pointer = pointer.former;
        }
        System.out.println("");
    }
    
    public void removeStart() {
        if (start != null) {
            Node remove = start;
            
            start = start.next;
            remove.next = null;
                                
            size--;
            
            if (start != null) start.former = null;    
            else end = null;                                                                 
        }       
    }
    
    public void removeEnd() {
        if (start != null) {            
            end = end.former;
            if (end != null) end.next = null;
            else start = null;
            size--;
        }
    }
    
    public void removeAt(int pos) {
        if (start != null && pos >= 0 && pos <= size) {
            if (pos == 0) {
                removeStart();
            } else if (pos == size) {
                removeEnd();
            } else {
                Node remove;
                Node pointer = start;
                int current = 1;
                
                while (current < pos) {
                    pointer = pointer.next;
                    current++;
                }
                
                remove = pointer.next;
                
                pointer.next = remove.next;
                
                remove.next.former = pointer;
                
                size--;
            }                
        }        
    }

    public int getSize() {
        return size;
    }                              
           
}
