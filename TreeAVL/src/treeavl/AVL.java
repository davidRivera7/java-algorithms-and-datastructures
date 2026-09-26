//arbol correcto AVL recursivo.
package treeavl;

public class AVL {
    private class Node {
        private int key;        

        private Node left;
        private Node right;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "key: " + key;
        }
    }

    private Node root;
    
    public Node insert(Node node, int key) {
        
        if (node == null) 
            return new Node(key);        
        
        if (key < node.key) 
            node.left = insert(node.left, key);
        else if (key > node.key) 
            node.right = insert(node.right, key);
        else 
            return node; //llave duplicada
        
        int balanceFactor = getBalanceFactor(node);
        
        if (balanceFactor < -1 && key < node.left.key) {            
            //left left case
            return leftLeftCase(node);
        }
        
        if (balanceFactor > 1 && key > node.right.key) {
            //right right case           
            return rightRightCase(node);
        }
        
        if (balanceFactor < -1 && key > node.left.key) {
            //left right case
            node.left = rightRightCase(node.left);
            return leftLeftCase(node);
        }                
        
        if (balanceFactor > 1 && key < node.right.key) {
            //right left case
            node.right = leftLeftCase(node.right);
            return rightRightCase(node);            
        }
        
        return node;
        
    }
    
    /*
    subArbol der - subArbol izq
    */
    public int getBalanceFactor(Node root) {
        if (root == null) {
            return 0;
        }
        
        int l = depth(root.left) + 1;
        int r = depth(root.right) + 1;
        
        return r - l;
    }
    
    public int depth(Node node) {
        if (node != null) {
            int l = 0;
            int r = 0;
            
            if (node.left != null) 
                l = 1 + depth(node.left);
            
            
            if (node.right != null) 
                r = 1 + depth(node.right);
            
            return (l > r) ? l : r;
        }
        return -1;
    }
    
    private Node leftLeftCase(Node pointerHead) {
        Node midler = pointerHead.left;
        Node T1 = midler.right;
        
        midler.right = pointerHead;
        pointerHead.left = T1;
        
        return midler;
    }
    
    private Node rightRightCase(Node pointerHead) {
        Node midler = pointerHead.right;
        Node T1 = midler.left;
        
        midler.left = pointerHead;
        pointerHead.right = T1;
        
        return midler;
    }
    
    public void inOrder(Node r) {
        if (r != null) {
            System.out.print(r.key + ", ");
            inOrder(r.left);
            inOrder(r.right);
        }
    }
    
    public Node search(int key, Node r) {
        if (r != null) {
            if (r.key == key) 
                return r;                        
            
            if (key < r.key) 
                return search(key, r.left);
            
            if (key > r.key) 
                return search(key, r.right);                
        }
        return null;
    }
            
    public Node deleteNode(int key, Node r) {
        if (r == null) 
            return null; 
        
        if (key < r.key) 
            r.left = deleteNode(key, r.left);
        else if (key > r.key)
            r.right = deleteNode(key, r.right);
        else  //llave encontrada
            r = removeCase(r);                        
                            
        r = balance(r);                                                
        
        return r;                                                        
    }
    
    private Node removeCase(Node r) { //tres casos de eliminacion y retornamos el arbol modificado
        if (isLeaf(r))             
            return null;
        else if (r.left != null && r.right != null) {
            
            Node moreRight = r.left;
            
            while (moreRight.right != null) {
                moreRight = moreRight.right;
            }
            
            r.key = moreRight.key;
            r.left = deleteNode(r.key, r.left);
            
        } else {
            Node substitute = (r.left != null) ? r.left : r.right;
            
            r.key = substitute.key;
            r.left = substitute.left;
            r.right = substitute.right;
        }      
        
        return r;
    }
    
    private Node balance(Node r) { //casos de balanceo
        if (r == null) 
            return null;        

        int balanceFactor = getBalanceFactor(r);

        if (balanceFactor < -1) { //left left case or left right case

            int leftBalanceFactor = getBalanceFactor(r.left);

            if (leftBalanceFactor <= 0) //left left                                
                return leftLeftCase(r);
            
            else {//left right                    
                r.left = rightRightCase(r.left);
                return leftLeftCase(r);
            }
        }

        if (balanceFactor > 1) {
            int rightBalanceFactor = getBalanceFactor(r.left);

            if (rightBalanceFactor >= 0) //right right            
                return rightRightCase(r);
            
            else { //right left 
                r.right = leftLeftCase(r.right);
                return rightRightCase(r);
            }
        }

        return r;//aqui el arbol no necesita balanceo
    }
    
    public boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }    
    
    public int countLeafs(Node r) {
        if (r == null) 
            return 0;        
        
        if (isLeaf(r))             
            return 1;
        
        
        int sum = 0;
        
        if (r.left != null) 
            sum = countLeafs(r.left);        
        
        if (r.right != null) 
            sum += countLeafs(r.right);        
        
        return sum;
    }
	    
    public static void main(String[] args) {
         AVL tree = new AVL(); 
         
        tree.root = tree.insert(tree.root, 9); 
        tree.root = tree.insert(tree.root, 5); 
        tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 0); 
        tree.root = tree.insert(tree.root, 6); 
        tree.root = tree.insert(tree.root, 11);         
        tree.root = tree.insert(tree.root, 1); 
        tree.root = tree.insert(tree.root, 2); 
                 
        tree.inOrder(tree.root); 
 
        tree.root = tree.deleteNode(10, tree.root); 
         
        System.out.println("\n"); 
        
        tree.inOrder(tree.root);
                
        System.out.println("\ntotal leafs: " + tree.countLeafs(tree.root));                
    }
    
}
