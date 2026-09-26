
package AVLTree;

public class Main {
    
    public static void main(String[] args) {
        AVL avl = new AVL();
        
        avl.root = avl.insert(9, avl.root);                
        avl.root = avl.insert(90, avl.root);                
        avl.root = avl.insert(200, avl.root);                
        avl.root = avl.insert(1, avl.root);                
        avl.root = avl.insert(2, avl.root);                
        avl.root = avl.insert(6, avl.root);                
        avl.root = avl.insert(50, avl.root);                
        avl.root = avl.insert(88, avl.root);                
        avl.root = avl.insert(77, avl.root);                
        avl.root = avl.insert(70, avl.root);                
        avl.root = avl.insert(201, avl.root);                
        avl.root = avl.insert(202, avl.root);                
        avl.root = avl.insert(203, avl.root);                
        avl.root = avl.insert(204, avl.root);                
        avl.root = avl.insert(205, avl.root);                
        avl.root = avl.insert(206, avl.root);                
        avl.root = avl.insert(207, avl.root);                
        avl.root = avl.insert(208, avl.root);                        
        
        avl.levelOrderTraversal(avl.root);
//        System.out.println("Search: " + avl.search(avl.root, 9));
//        System.out.println("Path Search: " + avl.pathSearch(avl.root, 9));
    }
    
}
