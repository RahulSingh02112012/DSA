package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Reference Dec 6th,2020 (16 Cls)
//https://www.youtube.com/watch?v=bkQDYz_e-_w
public class DiameterOfTree {
	TreeNode root;
	
	public DiameterOfTree() {
		this.root = null;
	}
	
	public static int heightOfTree(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		
		if(leftHeight>rightHeight) {
			return 1+leftHeight;
		}else {
			return 1+rightHeight;
		}
	}
	
	public static int diameter(TreeNode root) {
		if(root== null) {
			return 0;
		}
		
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		//if diameter calculated using root node
		int diameter1= 1+leftHeight+rightHeight;
		
		// if diamter calc without using root node
		int leftDiameter = diameter(root.left);
		int rightDiamter = diameter(root.right);
		
		int diamter2 = Math.max(leftDiameter, rightDiamter);
		
		return Math.max(diameter1, diamter2);
	}

	public static void main(String[] args) {
		
		DiameterOfTree tree = new DiameterOfTree();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		
		
		/*
		 * tree.root.left.left.left = new TreeNode(7); tree.root.left.left.left.left =
		 * new TreeNode(8);
		 */
		
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(4);
		//tree.root.right.left = new TreeNode(6);
	//	tree.root.right.right = new TreeNode(7);
		
	//	System.out.println(diameter(tree.root));
		levelOrder(tree.root);

	}
	
	// Level order Traversal
		public static List<List<Integer>> levelOrder(TreeNode root) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> levelList = new ArrayList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode temp = queue.poll();
				System.out.println(temp.data);
				if (temp.right != null) {
					queue.add(temp.right);
				}
				if (temp.left != null) {
					queue.add(temp.left);
				}
			}
			return result;
		}

}
