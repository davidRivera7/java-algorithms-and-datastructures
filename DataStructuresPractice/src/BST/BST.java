
package BST;

public class BST {
    private class Node {
        private int value;
        private Node left;
        private Node right;
        
        public Node(int value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value + "";
        }        
    }
    
    private Node root;
            
    public Node insert(int value, Node root) {
        if (root == null) 
            return new Node(value);
        
        if (value <= root.value) 
            root.left = insert(value, root.left);
        else 
            root.right = insert(value, root.right);
        
        return root;
    }
    
    public String inOrder(Node root) {
        if (root == null) 
            return "";
        else 
            return root.value + " -> " + inOrder(root.left) + inOrder(root.right);        
    }
        
    public Node delete(Node root, int value) {
        if (root == null)
            return null;
        
        if (root.value == value) {
            
            if (isLeaf(root))
                return null;
            
            if (root.left != null && root.right != null) {
                Node moreRight = root.left;
                while (moreRight.right != null) 
                    moreRight = moreRight.right;                

                root.value = moreRight.value;
                root.left = delete(root.left, moreRight.value);

                return root;
            }
            
            return (root.left != null) ? root.left : root.right;
            
        } else {
            if (value < root.value)
                root.left = delete(root.left, value);
            else 
                root.right = delete(root.right, value);
            
            return root;
        }                
    }
    
    public boolean isLeaf(Node r) {
        return r.left == null && r.right == null;
    }
    
    public int sumNodes(Node r) {
        if (r == null) 
            return 0;
        else 
            return 1 + sumNodes(r.left) + sumNodes(r.right);        
    }
    
    public int sumLeafs(Node r) {
        if (r == null) 
            return 0;
        
        if (r.left == null && r.right == null) 
            return 1;

        return sumLeafs(r.left) + sumLeafs(r.right);        
    }
    
    public String showLeafs(Node r) {
        if (r == null) 
            return "";
                                
        if (isLeaf(r))
            return r + " - ";
        
        return showLeafs(r.left) + showLeafs(r.right);        
    }
    
    public boolean search(Node r, int value) {
        if (r == null) 
            return false;
        
        if (r.value == value)
            return true;
        
        if (value < r.value)
            return search(r.left, value);
        else 
            return search(r.right, value);                
    }
    
    public String rootSearch(Node r, int value) {
        if (r == null) 
            return null;
        
        if (r.value == value) 
            return r.value + "";            
        
        if (value < r.value)
            return "left -> " + rootSearch(r.left, value);
        else 
            return "right -> " + rootSearch(r.right, value);
    }
    
    public static void main(String[] args) {
        BST bst = new BST();
        
        bst.root = bst.insert(1, bst.root);
                        
        System.out.println(bst.inOrder(bst.root));        
    }
}
