package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {

TreeNode root;
	
	public ZigZagTraversal() {
		this.root =null;
	}

	public static void main(String[] args) {
		ZigZagTraversal tree = new ZigZagTraversal();
		
		tree.root = new TreeNode(1);
		tree.root.right = new TreeNode(2);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		
		tree.root.left = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		
		System.out.println(zigzagTraversalLeet(tree.root));

	}
	
	public static void zigzagTraversal(TreeNode root) {
		if(root == null)
			return;
		
		Stack<TreeNode> st1= new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		
		st1.push(root);
		while(!st1.isEmpty() || !st2.isEmpty()) {
		while(!st1.isEmpty()) {
			TreeNode temp = st1.pop();
			System.out.println(temp.data);
			if(temp.left!=null) {
				st2.push(temp.left);
			}
			if(temp.right!=null) {
				st2.push(temp.right);
			}
		}
			while (!st2.isEmpty()) {
				TreeNode temp1 = st2.pop();
				System.out.println(temp1.data);
				if(temp1.right!=null) {
					st1.push(temp1.right);
				}
				if(temp1.left!=null) {
					st1.push(temp1.left);
				}
			}
		}
		
	}
	
	
	public static List<List<Integer>> zigzagTraversalLeet(TreeNode root) {
	if(root == null)
		return null;
	
	Queue<TreeNode> st1= new LinkedList<>();
	Queue<TreeNode> st2 = new LinkedList<>();
	
	List<List<Integer>> list = new ArrayList<>();
	List<Integer> levelNodes = new ArrayList<>();
	
	
	st1.add(root);
	st1.add(null);
	while(!st1.isEmpty() || !st2.isEmpty()) {
	while(!st1.isEmpty()) {
		TreeNode temp = st1.poll();
		if(temp == null) {  //See this logic
			
			
			list.add(new ArrayList<>(levelNodes));
			levelNodes.clear();
			continue;
		}else {
		
			levelNodes.add(temp.data);
		}	
		//System.out.println(temp.data);
		if(temp.left!=null) {
			st2.add(temp.left);
		}
		if(temp.right!=null) {
			st2.add(temp.right);
		}
	}
		while (!st2.isEmpty()) {
			TreeNode temp1 = st2.poll();
			//System.out.println(temp1.data);
			if(temp1 == null) {  //See this logic
				/*
				 * if(st2.peek()==null) { st2.add(null); }
				 */
				
				list.add(new ArrayList<>(levelNodes));
				levelNodes.clear();
				continue;
			}else {
			
				levelNodes.add(temp1.data);
			}	
			if(temp1.right!=null) {
				st1.add(temp1.right);
			}
			if(temp1.left!=null) {
				st1.add(temp1.left);
			}
		}
	}
	return list;
	}


}
