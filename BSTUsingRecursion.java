package Tree;

public class BSTUsingRecursion {
static TreeNode root;
	
	public BSTUsingRecursion(){
		this.root = null;
	}
	
	public static void insertRec(int data) {
		root = insert(root,data);
	}
	
	public static TreeNode insert(TreeNode root,int data) {
		if(root == null) {
			root = new TreeNode(data);
			return root;
		}else {
			if(data>root.data) {
				root.right = insert(root.right, data);
			}else {
				root.left = insert(root.left, data);
			}
		}
		return root;
	}
	

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(10);
		bst.insert(5);
		bst.insert(12);
		bst.insert(4);
		bst.insert(6);
		bst.insert(7);
		preOrder(bst.root);
		//System.out.println(bst);
	}
	public static void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		preOrder(root.left);
		System.out.println(root.data);
		preOrder(root.right);
	}

	

}

