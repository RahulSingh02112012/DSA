package Tree.Tree;

import java.util.ArrayList;

public class isValidBST {
	
	TreeNode root;
	private static Integer prev = null;
	public isValidBST() {
       this.root = null;	
	}
	
	 public static boolean isvalidBST(TreeNode root) {
		 prev = null;
		 return inOrder(root);
		 
	 }
	
	public static void main(String[] args) {
		isValidBST tree = new isValidBST();
		
		tree.root = new TreeNode(0);
		//	tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode (-1);
		//tree.root.right.left = new TreeNode (3);
		//tree.root.right.right = new TreeNode (6);
		
		System.out.println(isvalidBST(tree.root));

	}


//Approach 1 Inorder with prev value
	private static boolean inOrder(TreeNode root) {
		if(root == null) {
			return true;
		}
		if(!isvalidBST(root.left)) return false;
		if(prev !=null && root.data<=prev) {
			return false;
		}
		prev = root.data;
		return isvalidBST(root.right);
		
		
	}
	
	//DFS - Call from Main using null, null for low and high
	private static boolean dfs(TreeNode root,Integer low,Integer high) {
	  if (root == null) {
          return true;
      }
      // The current node's value must be between low and high.
      if ((low != null && root.data <= low) || (high != null && root.data >= high)) {
          return false;
      }
      // The left and right subtree must also be valid.
      return dfs(root.right, root.data, high) && dfs(root.left, low, root.data);
  }

}

