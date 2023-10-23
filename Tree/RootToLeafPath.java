package Tree.Tree;

public class RootToLeafPath {
	TreeNode root;
	
	public static boolean[] getRootToLeafPath(TreeNode root,int sum) {
		if(root == null) {
			return new boolean[] {false};
		}
		
		int[] pathArray = new int[1000];
		int path =0;
		boolean[] result = new boolean[1000] ;
		int i=0;
		return getPathArray(root,pathArray,path,sum,result,i);
	}
	
	
	
	private static boolean[] getPathArray(TreeNode root, int[] pathArray,int path,int sum,boolean[] result,int i) {
		if(root == null) {
			return new boolean[] {false};
		}
		pathArray[path]=root.data;
		path++;
		
		
		if(root.left == null && root.right==null) {
			printThePath(pathArray,path);
			if(getTheSum(pathArray,path,sum)) {
				result[i]	= true;
				i++;
				}
		}
		else {
			getPathArray(root.left, pathArray, path,sum,result,i);
			getPathArray(root.right, pathArray, path,sum,result,i);
		}
		return result;
		
	}



	private static boolean getTheSum(int[] pathArray, int path,int sum) {
		int add =0;
		for(int i=0;i<path;i++) {
			add = add+pathArray[i];
		}
		if(add == sum ) {
			return true;
		}
		return false;
	}



	private static void printThePath(int[] pathArray, int path) {
		System.out.println("Size of the path is "+path);
		for(int i=0;i<path;i++) {
			System.out.println(pathArray[i]);
		}
		System.out.println("**************");
	}



	public RootToLeafPath() {
		this.root = null;
	}

	public static void main(String[] args) {
		RootToLeafPath tree = new RootToLeafPath();
		
		tree.root = new TreeNode(5); 
        tree.root.left = new TreeNode(4); 
        tree.root.right = new TreeNode(8); 
        
        tree.root.left.left = new TreeNode(11); 
        tree.root.left.left.left = new TreeNode(7);
        
        tree.root.left.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(13);
        tree.root.right.right= new TreeNode(4);
        tree.root.right.right= new TreeNode(1);
       boolean[] res = getRootToLeafPath(tree.root,22);
		for(int i =0;i<res.length;i++) {
			if(res[i]) {
				System.out.println(res[i]);
			}
		}

	}

}
