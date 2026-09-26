
package tree;

public class BinaryTree {

    private class TreeNode {

        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    private TreeNode root;

    public void travelTree(TreeNode r) {
        if (r != null) {
            System.out.print(r + " ");
            travelTree(r.left);
            travelTree(r.right);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length);
    }

    public TreeNode createBST(int[] nums, int start, int end) {

        if (start == end) {
            return null;
        } else {
            TreeNode t = new TreeNode(nums[(start + end) / 2]);            
            t.left = createBST(nums, start, (start + end) / 2);
            t.right = createBST(nums, ((start + end) / 2 ) + 1, end);

            return t;
        }                        
    }
    
    public int depth(TreeNode root) {
        
        if (root != null) {
            int l = 0;
            int r = 0;
                        
            if (root.left != null) {                
                l = 1 + depth(root.left);                
            }
            
            if (root.right != null) {                
                r = 1 + depth(root.right);                
            }
            
            return (l > r) ? l : r;            
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        BinaryTree tree = new BinaryTree();
        tree.root = tree.sortedArrayToBST(arr);        
        tree.travelTree(tree.root);
                
        System.out.println("\nAltura: " + tree.depth(tree.root));
    }
}
