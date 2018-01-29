package com.patel.ds.binarytree;

public class BinaryTree {
	private TreeNode treeNode;
	
	public BinaryTree() {
	}
	
	public void display() {
		display(treeNode, 0);
	}
	
	private void display(TreeNode node, int level) {
		int i;
		if(node == null) {
			return;
		}
		display(node.rchild, level+1);
		System.out.println();
		
		for(i = 0; i < level; i++) {
			System.out.println("  ");
		}
		System.out.println(node.info);
		
		display(node.lchild, level+1);
	}
	
	public void inOrder() {
		inOrder(treeNode);
		System.out.println();
	}
	
	private void inOrder(TreeNode node) {
		if(node == null) return;
		System.out.print(node.info + " ");
		inOrder(node.lchild);
		inOrder(node.rchild);
	}
	
	public void preOrder() {
		preOrder(treeNode);
		System.out.println();
	}
	
	private void preOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		preOrder(node.lchild);
		System.out.print(node.info + " ");
		preOrder(node.rchild);
	}
	
	public void postOrder() {
		postOrder(treeNode);
		System.out.println();
	}
	
	private void postOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		postOrder(node.lchild);
		postOrder(node.rchild);
		System.out.print(node.info + " ");
	} 
	
	public void createTree() {
		treeNode = new TreeNode('P');
		treeNode.lchild = new TreeNode('Q');
		treeNode.rchild = new TreeNode('R');
		treeNode.lchild.lchild = new TreeNode('A');
		treeNode.lchild.rchild = new TreeNode('B');
		treeNode.rchild.lchild = new TreeNode('X');
	}
	
}
