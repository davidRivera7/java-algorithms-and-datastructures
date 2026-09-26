//econtrar la ruta mas corta a una hoja, listo y facil.
package BST01;

import BST01.BST.TreeNode;

public class shortPath {
    
    static int shortestRouteLeaf(TreeNode r) {
        if (r == null) //no hay arbol
            return 0;                
                                              //estamos en nodo y partimos con la ruta mas corta hacia izq o der
        int left = shortestRouteLeaf(r.left); 
        int right = shortestRouteLeaf(r.right);
        
        if (left != 0 && right != 0) //tengo dos caminos para llegar a una hoja, decido la mas corta
            return 1 + ((left < right) ? left : right);
                
        return 1 + ((left != 0) ? left : right); //solo un camino para llegar a una hoja
    }
        
    public static void main(String[] args) {
        BST bst = new BST();        
        bst.root = bst.insert(bst.root, 10);
        bst.insert(bst.root, 6);
        bst.insert(bst.root, 8);
        bst.insert(bst.root, 7);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 15);
        bst.insert(bst.root, 12);
        bst.insert(bst.root, 30);
        
//        bst.inOrder(bst.root);
        
        System.out.println(shortestRouteLeaf(bst.root));
    }
}
