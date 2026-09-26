//esta mejor el otro pero este tambien esta correcto.
package treeavl;

public class TreeAVL {
    private class NodeAVL {

        private int number;

        private NodeAVL father;
        private NodeAVL left;
        private NodeAVL right;

        public NodeAVL(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public String toString() {
            return number + "";
        }
    }
    
    private NodeAVL root;

    public void insert(int number) {
        if (root == null) {
            root = new NodeAVL(number);
            
        } else if (number < root.number) {
            if (root.left == null) {
                root.left = new NodeAVL(number);
                root.left.father = root;
                                
            } else 
                insert(number, root.left);
           
        } else if (number > root.number) {
            if (root.right == null) {
                root.right = new NodeAVL(number);
                root.right.father = root;
                                
            } else 
                insert(number, root.right);
        }
                
    }
    
    private void insert(int number, NodeAVL root) {
        if (number < root.number) {  
            
            if (root.left == null) {
                root.left = new NodeAVL(number);
                root.left.father = root;
                                              
            } else 
                insert(number, root.left);
            
        } else if (number > root.number) {            
            
            if (root.right == null) {
                root.right = new NodeAVL(number);
                root.right.father = root;
                                
            } else 
                insert(number, root.right);
        }
        
        balance(root.father, root);
                
    }
    
    public void inOrder() {
        if (root != null) {
            System.out.print(root.number + " ");
            inOrder(root.left);
            inOrder(root.right);
        }        
    }
    
    private void inOrder(NodeAVL r) {
        if (r != null) {
            System.out.print(r.number + " ");
            inOrder(r.left);
            inOrder(r.right);
        }
    }
    
    public int depth() {
        if (root != null) {
            int l = 0;
            int r = 0;
            
            if (root.left != null) 
                l = 1 + depth(root.left);
            
            if (root.right != null) 
                r = 1 + depth(root.right);            
            
            return (l > r) ? l : r;
        }
        return 0;
    }
    
    private int depth(NodeAVL root) {
        if (root != null) {
            int l = 0;
            int r = 0;
            
            if (root.left != null) 
                l = 1 + depth(root.left);
            
            if (root.right != null) 
                r = 1 + depth(root.right);            
            
            return (l > r) ? l : r;
        }                
        return -1;
    }
    
    public int getFE(NodeAVL r) {
        return (1 + depth(r.right)) - (1 + depth(r.left));                                                
    }
    
    public void balance(NodeAVL father, NodeAVL son) {
        int f = getFE(father);
        int s = getFE(son);
        
        if (f == -2 && s == -1) {
            System.out.println("Simple Der");
            simpleRight(father, son);
        }
        
        if (f == 2 && s == 1) {
            System.out.println("Simple Izq");
            simpleLeft(father, son);
        }
        
        if (f == 2 && s == -1) {
            System.out.println("Doble izq");
            dobleLeft(father, son);
        }
        
        if (f == -2 && s == 1) {
            System.out.println("Doble der");
            dobleRight(father, son);
        }
        
    }
    
    private void simpleRight(NodeAVL father, NodeAVL son) {
        NodeAVL sonR = son.right;
        
        son.father = father.father;
        if (son.father != null) {
            if (son.father.number > son.number) {
                son.father.left = son;
            } else {
                son.father.right = son;
            }           
        } else {
            root = son;
        }
        
        son.right = father;
        father.father = son;
        father.left = sonR;
        if (sonR != null) {
            sonR.father = father;
        }
    }
    
    public void simpleLeft(NodeAVL father, NodeAVL son) {
        NodeAVL sonsLeft = son.left;
        
        son.father = father.father;
        if (son.father != null) {
            if (son.father.number > son.number) {
                son.father.left = son;
            } else {
                son.father.right = son;
            }                        
        } else {
            root = son; //main root
        }
        
        son.left = father;
        father.father = son;
        father.right = sonsLeft;
        if (sonsLeft != null) {
            sonsLeft.father = father;
        }
        
    }        
    
    private void dobleRight(NodeAVL father, NodeAVL son) {
        NodeAVL r = son.right;
        
        r.father = father;
        father.left = r;
        r.left = son;
        son.father = r;
        son.right = null;
        
        simpleRight(r.father, r);
    }
    
    private void dobleLeft(NodeAVL father, NodeAVL son) {
        NodeAVL l = son.left;
        
        l.father = father;
        father.right = l;
        l.right = son;
        son.father = l;
        son.left = null;
        
        simpleLeft(l.father, l);        
    }
    
    
        
}
