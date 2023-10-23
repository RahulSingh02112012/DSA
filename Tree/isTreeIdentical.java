package Tree.Tree;

public class isTreeIdentical {
	
	TreeNode root;
	
	public isTreeIdentical() {
		root = null;
	}

	public static void main(String[] args) {
	  BSTUsingRecursion bst = new BSTUsingRecursion();
	  bst.insertRec(1);
	  bst.insertRec(2);
	  bst.insertRec(3);
	  bst.insertRec(4);
	  
	  BSTUsingRecursion bst1 = new BSTUsingRecursion();
	  bst1.insertRec(1);
	  bst1.insertRec(2);
	  bst1.insertRec(5);
	  bst1.insertRec(4);
	  
	  bst.preOrder(bst.root);
	  boolean result = isIdentical( bst.root, bst1.root);
	  System.out.println(result);

	}

	private static boolean isIdentical(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null ) {
			return true;
		}
		if(root1.data == root2.data) {
			return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
		}
		
		return false;
	}
	//Is Mirror
	private static boolean isMirror(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null ) {
			return true;
		}
		if(root1.data == root2.data) {
			return isIdentical(root1.left, root2.right) && isIdentical(root1.right, root2.left);
		}
		
		return false;
	}

}
