package Tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOfANode {
	TreeNode root;
	
	public LevelOfANode() {
		this.root = null;
	}
	
	public static void getLevelOfNode(TreeNode root, int val,int hd) {
		if(root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			if(temp == null) {  //See this logic
				if(q.peek()!=null) {
					q.add(null);
				}
				hd++;
			}else {
			if(temp.data == val) {
				System.out.println("Level is "+hd);
				System.out.println("Data is "+temp.data);
			}
			
			
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
			}	
			
		}
		
	}

	public static void main(String[] args) {
		LevelOfANode tree = new LevelOfANode();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		
		getLevelOfNode(tree.root, 3,0);
	}

}
