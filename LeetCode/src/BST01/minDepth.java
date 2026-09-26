//funciona perfectamente
package BST01;

import BST01.BST.TreeNode;

public class minDepth {                
        
    public static int minDepth(TreeNode r) {
        if (r == null) return 0;
                        
        int left = maxDepth(r.left);
        int right = maxDepth(r.right);
        
        if (left != 0 && right != 0)                    
            return 1 + ((left < right) ? left : right);
        
        return 1 + ((left == 0) ? right : left);
    }
    
    public static int maxDepth(TreeNode r) {
        if (r == null) {
            return 0;
        } else {
            int left = maxDepth(r.left);
            int right = maxDepth(r.right);
            return 1 + ((left > right) ? left : right);
        }
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
        
        System.out.println(minDepth(bst.root));
    }
}
