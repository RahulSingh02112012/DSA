package Tree;

public class TopViewOfTheTree {
	TreeNode root;
	
	public TopViewOfTheTree() {
		this.root = null;
	}

	public static void printTopViewTree(TreeNode root) {
		if(root == null) {
			return;
		}
		int hd=0;
		
		TreeMap<Integer,Integer> m = new TreeMap<>();
		
		getTopViewOfTree(root,m,hd);
		
		for(Map.Entry<Integer,Integer> cm:m.entrySet()) {
			System.out.println(cm.getValue());
		}
	}
	
	private static void getTopViewOfTree(TreeNode root,TreeMap<Integer,Integer> m,int hd) {
		if(root == null) {
			return;
		}
		if(m.get(hd) == null) {
			m.put(hd, root.data);
		}
		
		getTopViewOfTree(root.left,m,hd-1);
		getTopViewOfTree(root.right, m, hd+1);
		
	}

	public static void main(String[] args) {
		TopViewOfTheTree tree = new TopViewOfTheTree();
		
		tree.root = new TreeNode(1);
		tree.root.right = new TreeNode(2);
		tree.root.right.right = new TreeNode(5);
		
		tree.root.right.right.left = new TreeNode(3);
		tree.root.right.right.right = new TreeNode(6);
		
		//1 14 3 7 4 5 15 6 13 10 11 2 12 8 9
		//tree.root.right.left = new TreeNode(5);
		tree.root.right.right.left.right = new TreeNode(4);
		
		printTopViewTree(tree.root);
	}

}

