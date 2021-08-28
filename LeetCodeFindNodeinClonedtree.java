package Tree;

public class LeetCodeFindNodeinClonedtree {
	TreeNode root;
	
	public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null || cloned == null ){
            return null;
        }
        int lev =0;
        TreeNode res = null;
        int level = getLevelOfNode(original,target,lev);
        if(level !=-1) {
        	 lev =0;
        	 res =getTargetNode(cloned,target,level,lev);
        }
		return res;
    }

	private static TreeNode getTargetNode(TreeNode root, TreeNode target, int level,int lev) {
		if(root == null) {
			return null;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			if(temp == null && q.peek() !=null) {
				q.add(null);
				lev++;
			}else {
				if(temp.data == target.data && level == lev) {
					return temp;
				}
				
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
				
			
			}
		}
		return null;
	}

	private static int getLevelOfNode(TreeNode root, TreeNode target, int lev) {
		if(root == null) {
			return -1;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			if(temp == null && q.peek() !=null) {
				q.add(null);
				lev++;
			}else {

				if(temp.data == target.data) {
					return lev;
				}
				
				
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
				
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		LeetCodeFindNodeinClonedtree tree = new LeetCodeFindNodeinClonedtree();
		
		tree.root = new TreeNode(7);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(3);
		
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(19);
		
		System.out.println(getTargetCopy(tree.root, tree.root, new TreeNode(3)).data);
		
	}

}
