package Tree.Tree;

public class PrintNodeKDistance {
	TreeNode root;
	
	public PrintNodeKDistance() {
		this.root = null;
	}
	
	
	
	public static void main(String[] args) {
		PrintNodeKDistance tree = new PrintNodeKDistance();

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		
		getNodeKDistanceFromRoot(tree.root,1);
	}



	private static void getNodeKDistanceFromRoot(TreeNode root,int k) {
		if(root == null) {
			return;
		}
		if(k==0) {
			System.out.println(root.data);
		}
		getNodeKDistanceFromRoot(root.left, k-1);
		getNodeKDistanceFromRoot(root.right, k-1);
	}

}

