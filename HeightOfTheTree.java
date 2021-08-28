package Tree;

public class HeightOfTheTree {
	TreeNode root;
	
	public HeightOfTheTree() {
		this.root = null;
	}
	
	public static int heightoftheTree(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = 1+heightoftheTree(root.left);
			int rightHeight =1+ heightoftheTree(root.right);

			if (leftHeight > rightHeight) {
				return  leftHeight;
			} else {
				return  rightHeight;
			}
		}
	}

	public static void main(String[] args) {
		HeightOfTheTree tree = new HeightOfTheTree();
		
		tree.root = new TreeNode(3);
		tree.root.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(4);
		tree.root.right.right = new TreeNode(6);
		tree.root.right.right.right = new TreeNode(7);
		
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(5);
		
		System.out.println("Height of the tree is :"+heightoftheTree(tree.root));
		System.out.println("Height of the tree using Edges is :"+getHeightUsingEdges(tree.root));
	}
	
	public static int getHeightUsingEdges(TreeNode root) {
		if(root == null) {
			return -1;
		}
		if(root.left == null && root.right == null) { //IMPORTANT LOGIC FOR EDGES
			return 0;
		}
		int leftHeight= getHeightUsingEdges(root.left);
		int rightHeight = getHeightUsingEdges(root.right);
		
		if (leftHeight > rightHeight) {
			return  1+leftHeight;
		} else {
			return  1+rightHeight;
		}
	}

}
