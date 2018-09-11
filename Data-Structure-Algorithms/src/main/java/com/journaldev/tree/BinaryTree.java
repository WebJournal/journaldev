package com.journaldev.tree;

public class BinaryTree {

	public TreeNode root;

	public static class TreeNode {

		public TreeNode left;
		public TreeNode right;
		public Object data;

		public TreeNode(Object data) {
			this.data = data;
			left = right = null;
		}
	}
}