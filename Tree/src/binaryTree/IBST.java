
package binaryTree;

public interface IBST<T extends Comparable> {
    
    void insert(T empl);
    
    boolean exist(int id);
    
    T get(int id);
    
    boolean isLeaf();
    
    boolean isEmpty();
    
    void preorder();
    
    void inorder();
    
    void postorder();
    
    void eliminate(int id);
    
    int depth();
    
    int totalNodes();
    
    int totalLeafs();
    
}
