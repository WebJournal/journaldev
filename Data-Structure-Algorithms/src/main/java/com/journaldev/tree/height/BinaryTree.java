package com.journaldev.tree.height;

public class BinaryTree {

	TreeNode root;

	public static class TreeNode {

		TreeNode left;
		TreeNode right;
		Object data;

		TreeNode(Object data) {
			this.data = data;
			left = right = null;
		}
	}
}