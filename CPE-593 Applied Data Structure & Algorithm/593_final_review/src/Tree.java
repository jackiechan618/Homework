import java.util.Queue;
import java.util.LinkedList;

public class Tree {
	private treeNode root;

	public Tree(int v) {
		root = new treeNode(v);
	}

	public void add(int v) {
		if (root == null)
			root = new treeNode(v);

		treeNode temp = root;
		while (temp != null) {
			if (v < temp.value) {
				if (temp.left != null)
					temp = temp.left;
				else {
					temp.left = new treeNode(v);
					break;
				}
			} else {
				if (temp.right != null)
					temp = temp.right;
				else {
					temp.right = new treeNode(v);
					break;
				}
			}
		}
	}
	
	public void delete(int n){
		if(search(n))
			return;
		if(root.value == n)
			root = null;
		
		treeNode temp = root;
		treeNode temp_p = root;
		while(temp != null){
			if(n < temp.value){
				temp_p = temp;
				temp = temp.left;
			}
			else if(n > temp.value){
				temp_p = temp;
				temp = temp.right;
			}
			else{
				temp_p = null;
			}
		}
	}

	public void recursivePreOrder(treeNode root) {
		if (root == null)
			return;
		System.out.print(root.value + ", ");
		recursivePreOrder(root.left);
		recursivePreOrder(root.right);
	}

	public void recursiveInOrder(treeNode root) {
		if (root == null)
			return;
		recursiveInOrder(root.left);
		System.out.print(root.value + ", ");
		recursiveInOrder(root.right);
	}

	public void recursivePostOrder(treeNode root) {
		if (root == null)
			return;
		recursivePostOrder(root.left);
		recursivePostOrder(root.right);
		System.out.print(root.value + ", ");
	}

	public void levelOrder() {
		Queue q = new LinkedList<Tree>();
		q.add(root);

		while (!q.isEmpty()) {
			treeNode temp = (treeNode) q.poll();
			System.out.print(temp.value + ", ");
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}
	
	public boolean search(int v){
		treeNode temp = root;
		while(temp != null){
			if(v < temp.value)
				temp = temp.left;
			else if(v > temp.value)
				temp = temp.right;
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Tree t = new Tree(5);
		t.add(3);
		t.add(8);
		t.add(2);
		t.add(4);
		t.add(7);
		t.add(9);
		t.add(1);
		t.add(6);
		t.add(10);
		t.levelOrder();
		System.out.println();
		t.recursivePreOrder(t.root);
		System.out.println();
		t.recursiveInOrder(t.root);
		System.out.println();
		t.recursivePostOrder(t.root);
		System.out.println();
		t.levelOrder();
		System.out.println();
		System.out.println(t.search(1));
		t.delete(1);
		System.out.println(t.search(1));
	}
}

class treeNode {
	public int value;
	public treeNode left;
	public treeNode right;

	public treeNode(int v) {
		value = v;
		left = right = null;
	}
}
