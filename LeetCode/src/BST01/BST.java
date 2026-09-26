
package BST01;

public class BST {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

        @Override
        public String toString() {
            return val + "";
        }            
  }
  
  public TreeNode root;
  
  public TreeNode insert(TreeNode r, int x) {
      if (r == null)
          return new TreeNode(x);
      
      if (x < r.val)
          r.left = insert(r.left, x);
      else 
          r.right = insert(r.right, x);
      
      return r;
  }   
  
  public void inOrder(TreeNode r) {
      if (r != null) {              
          System.out.print(r + ", ");
          inOrder(r.left);
          inOrder(r.right);
      }
  }
    
}
