package Tree.Tree;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
	
	TreeNode root;
	
	public BinaryTree() {
		this.root =null;
	}
	
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.root = new TreeNode(10);
		tree.root.right = new TreeNode(30);
		tree.root.left = new TreeNode(20);
		
		tree.root.left.left = new TreeNode(40);
		tree.root.left.right = new TreeNode(50);
		
		//postOrder(tree.root);
		System.out.println("Post Order Interative");
		postOrderItr(tree.root);
	}
	
	
	public static void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public static void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
	
	public static List<Integer> postOrderItr(TreeNode root) {
		LinkedList<Integer> ans = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) return ans;
		
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			ans.addFirst(cur.data);
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			} 
		}
		Iterator<Integer> its = ans.iterator();
		while(its.hasNext()) {
			System.out.println(its.next());
		}
		return ans;	
	}
	
	
	

}

