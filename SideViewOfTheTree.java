package Tree;

//See 13th December Video
public class SideViewOfTheTree {
	TreeNode root;
	
	public SideViewOfTheTree() {
		this.root = null;
	}
	
	

	public static void main(String[] args) {
		SideViewOfTheTree tree = new SideViewOfTheTree();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		
		tree.root.left.left = new TreeNode(4);
		tree.root.left.left.left = new TreeNode(8);
		tree.root.left.left.right = new TreeNode(9);
		
		tree.root.left.right = new TreeNode(5);
		
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		
		tree.root.right.right.left = new TreeNode(10);
		tree.root.right.right.right = new TreeNode(11);
		
		tree.root.right.right.right.right = new TreeNode(12);
		
		getSideViewOfTree(tree.root);
	}



	private static void getSideViewOfTree(TreeNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();	
		q.add(root);
		q.add(null);
		System.out.println(root.data);
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			if(temp == null) {//SEE THIS LOGIC
				if(q.peek()!=null) {
					System.out.println(q.peek().data);
					q.add(null);
				}
			}else {
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
		}}
	}

}
