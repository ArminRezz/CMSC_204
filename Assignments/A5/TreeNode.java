
public class TreeNode<T> {
	
	 private TreeNode<T> left;
	 private TreeNode<T> right;
	 private T data;
	
	TreeNode(T data) {
		this.left = null;
		this.right = null;
		this.data = data;
		
	}
	
	TreeNode(TreeNode<T> node) {
		if (node == null) {
            return;
        }
        this.left = node.left == null ? null : new TreeNode<T>(node.left);
        this.right = node.right == null ? null : new TreeNode<T>(node.right);
        this.data = node.data;
	}
	
	public T getData() {
		return data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}
	
	public TreeNode<T> getRight() {
		return right;
	}

	public void setLeft(TreeNode<T> treeNode) {
		this.left = treeNode;
	}
	
	public void setRight(TreeNode<T> treeNode) {
		this.right = treeNode;
	}

	public void setData(T data) {
		this.data = data;
	}

}
