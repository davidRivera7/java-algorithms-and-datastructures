package binaryTree;

public class BST implements IBST<Employee>{

    private Employee value;
    private BST left;
    private BST right;
    private BST father;
    
    @Override
    public boolean isLeaf() {
        return value != null && left == null && right == null;
    }

    @Override
    public boolean isEmpty() {
        return value == null;
    }
    
    @Override
    public void insert(Employee empl) {
        insertImpl(empl, null); //caso al instanciar raiz
    }
    
    private void insertImpl(Employee empl, BST father) {
        if (value == null) {
            value = empl;
            this.father = father;
            
        } else if (empl.compareTo(value) < 0) {            
            if (left == null) left = new BST();                        
            left.insertImpl(empl, this);
            
        } else if (empl.compareTo(value) > 0) {            
            if (right == null) right = new BST();
            right.insertImpl(empl, this);
            
        } else {
            throw new RuntimeException("Se intenta almacenar una llave repetida");
        }
    }

    @Override
    public boolean exist(int id) {
        boolean exist = false;

        if (value != null) {
            exist = value.getId() == id;

            if (!exist && left != null) {
                exist = left.exist(id);
            }

            if (!exist && right != null) {
                exist = right.exist(id);
            }
        }

        return exist;
    }

    @Override
    public Employee get(int id) {
        Employee e = null;
        if (value != null) {
            if (value.getId() == id) {
                e = value;
            } else {
                if (e == null && left != null) {
                    e = left.get(id);
                }
                if (e == null && right != null) {
                    e = right.get(id);
                }                
            }                
        }            
        return e;        
    }   

    /**
     * raiz, izq, der
     */
    @Override
    public void preorder() {
        if (value != null) {                
            System.out.print(value.getId() + " - ");
            if (left != null) {
                left.preorder();
            }
            if (right != null) {
                right.preorder();
            }                            
        }            
    }

    /**
     * izq, raiz, der
     */
    @Override
    public void inorder() {
        if (value != null) {
            if (left != null) {
                left.inorder();
            }
            System.out.print(value.getId() + " - ");
            if (right != null) {
                right.inorder();
            }
        }
    }

    /**
     * izq, der, raiz
     */
    @Override
    public void postorder() {
        if (value != null) {
            if (left != null) {
                left.postorder();
            }
            if (right != null) {
                right.postorder();
            }
            System.out.print(value.getId() + " - ");
        }
    }

    @Override
    public void eliminate(int id) {
        if (value != null) {
            if (value.getId() == id) {
                eliminateImpl();
            } else if (id < value.getId() && left != null) {
                left.eliminate(id);
            } else if (id > value.getId() && right != null) {
                right.eliminate(id);
            }
        }
    }
    
    private void eliminateImpl() {
        if (left != null && right != null) {
            BST max = left.max();
            this.value = max.value;
            left.eliminate(max.value.getId());
            
        } else if (left != null || right != null) {
            BST substitute = left != null ? left : right;
            this.value = substitute.value;
            this.left = substitute.left;
            this.right = substitute.right;
            
        } else {
            if (father != null) {
                if (this == father.left) father.left = null;
                if (this == father.right) father.right = null;
                father = null;
            }            
            value = null;
        }
    }
    
    private BST max() {
        if (right != null) {
            return right.max();
        } else {
            return this;
        }        
    }    
    
    @Override
    public int depth() {        
        int l = 0;
        int r = 0;
        if (value != null) {            
            if (left != null) l = 1 + left.depth();
            if (right != null) r = 1 + right.depth();
            
            return (l > r) ? l : r;            
        } else {
            return 0;
        }
        
    }
    
    @Override
    public int totalNodes() {        
        if (value != null) {
            int total = 1;                                    
            if (left != null) {
                total += left.totalNodes();
            }
            if (right != null) {
                total += right.totalNodes();
            }
            return total;
        } else {            
            return 0;
        }        
    }
        
    @Override
    public int totalLeafs() {
        if (value != null) {                             
            int total = 0;
            if (left == null && right == null) {
                return 1;
            }                                
            total += (left != null) ? left.totalLeafs() : 0;
            total += (right != null) ? right.totalLeafs() : 0;
            return total;
        } else {
            return 0;
        }            
    }
        
    
}
