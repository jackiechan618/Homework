
public class Red_Black_Tree {
	BR_TreeNode root;
	BR_TreeNode Nil;
	
	public void LeftRotate(BR_TreeNode x, Red_Black_Tree T){
		BR_TreeNode y = x.right;
		x.right = y.left;
		
		if(y.left != T.Nil)
			y.left.parent = x;
		
		y.parent = x.parent;
		
		if(x.parent == T.Nil)
			T.root = y;
		else if(x == x.parent.left)
			x.parent.left = y;
		else
			x.parent.right = y;
		x.parent = y;
	}
	
	public void RightRotate(BR_TreeNode x, Red_Black_Tree T){
		BR_TreeNode y = x.left;
		x.left = y.right;
		
		if(y.right != T.Nil)
			y.right.parent = x;
		
		y.parent = x.parent;
		
		if(x.parent == T.Nil)
			T.root = y;
		else if(x == x.parent.left)
			x.parent.left = y;
		else
			x.parent.right = y;
		x.parent = y;
	}
}

class BR_TreeNode{
	public int value;
	public BR_TreeNode left;
	public BR_TreeNode right;
	public BR_TreeNode parent;
	public char color;
	
	public BR_TreeNode(int v, BR_TreeNode l, BR_TreeNode r, BR_TreeNode p, char c){
		value = v;
		left = l;
		right = r;
		parent = p;
		color = c;
	}
}

