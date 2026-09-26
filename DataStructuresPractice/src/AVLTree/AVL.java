//all correct 
package AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {        
    private class Node {
        int value;
        Node left;
        Node right;
        
        Node(int value) {
            this.value = value;
        }                   
        
        @Override
        public String toString() {
            return value + "";
        }
    }
    
    Node root;
    
    Node insert(int value, Node r) {
        if (r == null)
            return new Node(value);
        
        if (value < r.value)
            r.left = insert(value, r.left);
        else 
            r.right = insert(value, r.right);
                        
        switch (getBalanceFactor(r)) {
            case 2: //cargado a la der                
                r = (getBalanceFactor(r.right) == 1) ? rightRightCase(r) : rightLeftCase(r); //1 o -1
                break;
                
            case -2:                
                r = (getBalanceFactor(r.left) == -1) ? leftLeftCase(r) : leftRightCase(r);//-1 o 1
                break;
        }
        
        return r;
    }
    
    int getHeight(Node r) {
        return height(r) - 1;
    }
    
    private int height(Node r) {
        if (r == null)
            return 0;
        
        int leftHeight = height(r.left);
        int rightHeight = height(r.right);        
        return 1 + ((leftHeight > rightHeight) ? leftHeight : rightHeight);
    }
    
    private int getBalanceFactor(Node r) {
        return getHeight(r.right) - getHeight(r.left);
    }
    
    String inOrder(Node r) {
        if (r == null)
            return "";                
        
        return r + " -> " + inOrder(r.left) + inOrder(r.right);
    }
    
    /**
     * Left rotate <--
     * @param r
     * @return new Subtree
     */
    private Node rightRightCase(Node r) {
        Node formerHead = r;
        r = r.right;
        Node formerLeft = r.left;
        r.left = formerHead;
        formerHead.right = formerLeft;
        
        return r;
    }
    
    /**
     * Right rotate -->
     * @param r
     * @return 
     */
    private Node leftLeftCase(Node r) {
        Node formerHead = r;
        r = r.left;
        Node formerRight = r.right;
        r.right = formerHead;
        formerHead.left = formerRight;
        
        return r;
    }
    
    /**
     * Left rotate <--
     * Right rotate -->
     * @param r
     * @return 
     */
    private Node leftRightCase(Node r) {
        r.left = rightRightCase(r.left);
        return leftLeftCase(r);        
    }
    
    /**
     * Right rotate -->
     * Left rotate <--
     * @param r
     * @return 
     */
    private Node rightLeftCase(Node r) {
        r.right = leftLeftCase(r.right);
        return rightRightCase(r);
    }
    
    Node search(Node r, int value) {
        if (r == null)
            return null;
        
        if (r.value == value)
            return r;
        
        if (value < r.value)
            return search(r.left, value);
        else 
            return search(r.right, value);
    }
    
    String pathSearch(Node r, int value) {
        if (r == null)
            return "Empty";
        
        if (r.value == value)
            return "Found: " + value;
        
        if (value < r.value)
            return "left -> " + pathSearch(r.left, value);
        else 
            return "right -> " + pathSearch(r.right, value);
    }
    
    Node remove(Node r, int value) {
        if (r == null)
            return r; //not found value
        
        if (r.value == value) { //remove
            
            if (isLeaf(r))
                return null; //There is nothing to balance
                
            if (r.left != null && r.right != null) {
                Node moreRightSubTreeLeft = r.left;
                
                while (moreRightSubTreeLeft.right != null)
                    moreRightSubTreeLeft = moreRightSubTreeLeft.right;
                
                r.value = moreRightSubTreeLeft.value;
                
                r.left = remove(r.left, r.value); //You have to balance if necessary                                
            } else             
                r = (r.left != null) ? r.left : r.right; //You have to balance if necessary
            
            
        } else if (value < r.value) //continue search
            r.left = remove(r.left, value);
        else
            r.right = remove(r.right, value);
        
        
        switch (getBalanceFactor(r)) { //balance
            case 2:
                r = (getBalanceFactor(r.right) >= 0) ? rightRightCase(r) : rightLeftCase(r);// >= 0 o < 0
                break;
                
            case -2:
                r = (getBalanceFactor(r.left) <= 0) ? leftLeftCase(r) : leftRightCase(r);
                break;
        }        
        
        return r;
    }
    
    private boolean isLeaf(Node r) {
        return r.left == null && r.right == null;
    }    
          
    String showLeafs(Node r) {
        if (r == null) 
            return "";
                                
        if (isLeaf(r))
            return r + " - ";
        
        return showLeafs(r.left) + showLeafs(r.right);        
    }
    
    void levelOrderTraversal(Node r) {
        if (r == null)
            return;
        
        Queue<Node> q = new LinkedList<>();
        q.add(r);
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            System.out.print(current + " -> ");
            
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
        } 
        System.out.println("");
    }
    
}
