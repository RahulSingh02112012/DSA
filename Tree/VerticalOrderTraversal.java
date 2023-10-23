package Tree.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {
	TreeNode root;
	
	public VerticalOrderTraversal() {
		this.root = null;
	}
	
	public static void printVerticalOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		int hd =0;
		
		TreeMap<Integer,LinkedList<Integer>> m = new TreeMap<>();
		
		getVerticalOrder(root,hd,m);
		
		for(Map.Entry<Integer, LinkedList<Integer>> cm : m.entrySet()) {
			System.out.println(cm.getValue());
		}
	}
	
	

	private static void getVerticalOrder(TreeNode root, int hd, TreeMap<Integer, LinkedList<Integer>> m) {
		if(root == null) {
			return;
		}
		if(m.get(hd) == null) {
			LinkedList<Integer> l = new LinkedList<Integer>();
			l.add(root.data);
			m.put(hd, l);
		}else {
			LinkedList<Integer> l = m.get(hd);
			l.add(root.data);
			m.put(hd, l);
		}
		
		getVerticalOrder(root.left, hd-1, m);
		getVerticalOrder(root.right, hd+1, m);
		
	}

	public static void main(String[] args) {
		VerticalOrderTraversal tree = new VerticalOrderTraversal();
		
		tree.root = new TreeNode(2);
		tree.root.right = new TreeNode(5);
		tree.root.right.right = new TreeNode(9);
		tree.root.right.right.left = new TreeNode(4);
		
		
		tree.root.left = new TreeNode(7);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.right = new TreeNode(6);
		tree.root.left.right.left = new TreeNode(5);
		tree.root.left.right.right = new TreeNode(11);
		
		printVerticalOrder(tree.root);

	}

}

