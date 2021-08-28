package Tree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BST {
	static TreeNode root;

	public BST() {
		this.root = null;
	}

	// Insert
	public void insert(int data) {
		TreeNode temp = new TreeNode(data);
		if (root == null) {
			root = temp;
		} else {
			TreeNode current = root;
			TreeNode previous = null;
			while (true) {
				if (data < current.data) {
					previous = current;
					current = current.left;
					if (current == null) {
						previous.left = temp;
						break;
					}
				} else {
					previous = current;
					current = current.right;
					if (current == null) {
						previous.right = temp;
						break;
					}
				}
			}
		}

	}

	// Search

	public void search(int data) {
		TreeNode node = searchRec(root, data);
		if (node != null) {
			System.out.println(node.data);
		} else {
			System.out.println("Node not found");
		}
	}

	public static TreeNode searchRec(TreeNode root, int data) {
		if (root == null || root.data == data) {
			return root;
		}
		if (data < root.data) {
			return searchRec(root.left, data);
		} else {
			return searchRec(root.right, data);
		}
	}

	// Count number of nodes

	public static void countNodes() {
		System.out.println("Total number of nodes : " + countNumberOfNode(root));
	}

	public static int countNumberOfNode(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + countNumberOfNode(root.left) + countNumberOfNode(root.right);
	}

	// Count leaf Nodes

	public static void countLeafNodes() {
		System.out.println("Leaf nodes are :" + countLeafNode(root));
	}

	private static int countLeafNode(TreeNode root) {
		if (null == root) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		return countLeafNode(root.left) + countLeafNode(root.right);
	}

	// Count half leaf Node( Nodes which have only one child

	public static void countHalfLeaveNodes() {
		System.out.println("Half leaf nodes are :" + countHalfLeaveNode(root));
	}

	private static int countHalfLeaveNode(TreeNode root) {
		if (root == null) {
			return 0;
		}
		//int count = 0;
		if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
			//count++;
			return 1;
		}
		//count = count + countHalfLeaveNode(root.left) + countHalfLeaveNode(root.right);
		return countHalfLeaveNode(root.left) + countHalfLeaveNode(root.right);
		//return count;
	}

	// Count Full Nodes
	public static void countFullLeafNode() {
		System.out.println("Full leaf Nodes are :" + countFullLeafNode(root));
	}

	private static int countFullLeafNode(TreeNode root2) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right != null) {
			return 1;
		}

		return countFullLeafNode(root.left) + countFullLeafNode(root.right);
	}

	// Sum of the tree Nodes
	public static void getSumOfNodes() {
		System.out.println("The sum of all Nodes is : " + getNodeSum(root));
	}

	public static int getNodeSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		sum = root.data + getNodeSum(root.left) + getNodeSum(root.right);
		return sum;

	}

	public static void main(String[] args) {
		BST bst = new BST();
		/*
		 * bst.insert(10); bst.insert(5); bst.insert(12); bst.insert(4); bst.insert(2);
		 */

	//	bst.insert(8);
		/*
		 * bst.insert(3); bst.insert(1);
		 */
		bst.insert(4);
		bst.insert(2);
		bst.insert(7);
		bst.insert(1);
		bst.insert(3);
		bst.insert(6);
		//inOrder(root);
		/*
		 * bst.insert(7); bst.insert(1);
		 */
		// inOrder(bst.root);
		// bst.search(18);
		bst.countNodes();
		// bst.countLeafNodes();
	//	bst.countHalfLeaveNodes();
		// bst.countFullLeafNode();
		// bst.getSumOfNodes();
	//	 preOrder(root);
		// System.out.println("Pre Order Iterative");
		// preOrderIterative(root);
		//inOrder(root);
		//System.out.println("IN Order Iterative");
		//inOrderIterative(root);
		//System.out.println(inOrderIterativeListReturn(root));
		// levelOrder(root);
		// System.out.println(bst);
	}

	// INORDER -> USED in BST traversal Left->root->Right
	public static void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	// PRE-ORDER ->Root->Left->Right
	public static void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	// POST ORDER -> Left->Right->Root
	public static void postOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
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

	// PREORDER Iterative
	public static void preOrderIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode temp = st.pop();
			System.out.println(temp.data + " ");
			if (temp.right != null) {
				st.push(temp.right);
			}
			if (temp.left != null) {
				st.push(temp.left);
			}
		}
	}

	// Inorder ITERATIVE
	public static void inOrderIterative(TreeNode root) {
		if (root == null) {
			return;
		} else {
			Stack<TreeNode> st = new Stack<>();
			boolean finished = false;
			TreeNode current = root;
			while (!finished) {
				if (current != null) {
					st.push(current);
					current = current.left;
				} else {
					if (st.isEmpty()) {
						finished = true;
					} else {
						current = st.pop();
						System.out.println(current.data);
						current = current.right;
					}
				}

			}

		}
	}
	
	public static List<Integer> inOrderIterativeListReturn(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return new ArrayList<>();
		} else {
			
			Stack<TreeNode> st = new Stack<>();
			boolean finished = false;
			TreeNode current = root;
			while (!finished) {
				if (current != null) {
					st.push(current);
					current = current.left;
				} else {
					if (st.isEmpty()) {
						finished = true;
					} else {
						current = st.pop();
						list.add(current.data);
						current = current.right;
					}
				}

			}

		}
		return list;
	}
	
	public static boolean searchInBinaryTree(TreeNode root,int data) {
		if(root == null) {
			return false;
		}
		if(root.data == data) {
			return true;
		}
		searchInBinaryTree(root.left, data);
		searchInBinaryTree(root.right, data);
		return false;
		
	}
	
	/*
	 * if (root == null) { return new ArrayList<>(); } List<Integer> list = new
	 * ArrayList<>(); return getPreOrder(root,list);
	 * 
	 * }
	 * 
	 * private static List<Integer> getPreOrder(TreeNode root,List<Integer> list){
	 * if (root == null) { return new ArrayList<>(); }
	 * 
	 * list.add(root.val); getPreOrder(root.left,list);
	 * getPreOrder(root.right,list); return list;
	 */
	//POST order Iterative
	public static void postOrderIterative(TreeNode root) {
		if(root == null )return;
		LinkedList<Integer> res = new LinkedList<Integer>();
		Stack<TreeNode> stk = new Stack<>();
		
		stk.push(root);
		while(!stk.isEmpty()) {
			TreeNode temp = stk.pop();
			System.out.println(temp.data);
			res.addFirst(temp.data);
			if(temp.left!=null) {
				stk.push(temp.left);
			}
			if(temp.right!=null) {
				stk.push(temp.right);
			}
		}
		
	}
	
}

