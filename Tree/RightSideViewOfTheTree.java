package Tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewOfTheTree {
	TreeNode root;

	public RightSideViewOfTheTree() {
		this.root = null;
	}

	public static List<Integer> getRightSideView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		System.out.println(root.data);
		List<Integer> list = new ArrayList<>();
		list.add(root.data);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp == null) {
				if (q.peek() != null) {
					System.out.println(q.peek().data);
					list.add(q.peek().data);
					q.add(null);
				}

			} else {

				if (temp.right != null) {
					q.add(temp.right);
				}
				if (temp.left != null) {
					q.add(temp.left);
				}

			}
		}
		return list;
	}

	public static void main(String[] args) {

		RightSideViewOfTheTree tree = new RightSideViewOfTheTree();

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);

		/*
		 * tree.root.left.left = new TreeNode(4); tree.root.left.left.left = new
		 * TreeNode(8); tree.root.left.left.right = new TreeNode(9);
		 * tree.root.left.left.right.right = new TreeNode(21);
		 * tree.root.left.left.right.right.right = new TreeNode(18);
		 */

		tree.root.left.right = new TreeNode(5);

		//tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(4);

		/*
		 * tree.root.right.right.left = new TreeNode(10); tree.root.right.right.right =
		 * new TreeNode(11);
		 * 
		 * tree.root.right.right.right.right = new TreeNode(12);
		 */

		getRightSideView(tree.root);

	}

}
