package com.journaldev.tree.binarysearchtree.BSTOperations;

import com.journaldev.tree.BinaryTree;
import com.journaldev.tree.BinaryTree.TreeNode;

public class SearchInsertRemoveFromTree {

	public static void main(String[] args) {

		/**
		 *   Our Example Binary Search Tree
		 *       10
		 *     5    20
		 *   4  8  15 25
		 */
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(5);
		tree.root.right = new TreeNode(20);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(8);
		tree.root.right.left = new TreeNode(15);
		tree.root.right.right = new TreeNode(25);
		printInorderTraversal(tree.root);
		
		System.out.println("\nSearch Value 2 is in tree? " + searchRecursively(tree.root, 2));
		System.out.println("Search Value 10 in tree? " + searchRecursively(tree.root, 10));

		System.out.println("Search Value 20 is in tree? " + searchIteratively(tree.root, 20));
		System.out.println("Search Value 11 in tree? " + searchIteratively(tree.root, 11));

		System.out.println("**INSERT NODE RECURSIVELY**");

		tree.root = insertionRecursive(tree.root, 24);
		tree.root = insertionRecursive(tree.root, 2);

		/*
		 * tree.root = insertionIterative(tree.root, 24); 
		 * tree.root = insertionIterative(tree.root, 2);
		 */

		printInorderTraversal(tree.root);

		System.out.println("\n**DELETE NODE RECURSIVELY**");

		tree.root = deleteRecursively(tree.root, 4);
		tree.root = deleteRecursively(tree.root, 20);

		printInorderTraversal(tree.root);

		/*
		 * System.out.println("**DELETE NODE ITERATIVELY");
		 * 
		 * tree.root = deleteNodeIteratively(tree.root, 4);
		 * tree.root = deleteNodeIteratively(tree.root, 20);
		 * 
		 * printInorderTraversal(tree.root);
		 */
	}

	public static boolean searchRecursively(TreeNode root, int value) {

		if (root == null)
			return false;

		if ((int) root.data == value)
			return true;

		if (value < (int) root.data)
			return searchRecursively(root.left, value);

		else if (value > (int) root.data)
			return searchRecursively(root.right, value);

		return false;
	}

	public static boolean searchIteratively(TreeNode root, int value) {

		while (root != null) {
			if ((int) root.data == value)
				return true;

			if (value < (int) root.data)
				root = root.left;

			else
				root = root.right;
		}

		return false;
	}

	public static TreeNode insertionRecursive(TreeNode root, int value) {

		if (root == null)
			return new TreeNode(value);

		if (value < (int) root.data) {
			root.left = insertionRecursive(root.left, value);
		} else if (value > (int) root.data) {
			root.right = insertionRecursive(root.right, value);
		}

		return root;

	}

	public static TreeNode insertionIterative(TreeNode root, int value) {

		TreeNode current, parent;

		TreeNode tempNode = new TreeNode(value);

		if (root == null) {
			root = tempNode;
			return root;
		} else {
			current = root;
		}

		while (true) {
			parent = current;

			if (value < (int) current.data) {
				current = current.left;
				if (current == null) {
					parent.left = tempNode;
					return root;
				}

			} else if (value > (int) current.data) {
				current = current.right;

				if (current == null) {
					parent.right = tempNode;
					return root;
				}
			}

		}
	}

	public static void printInorderTraversal(TreeNode root) {
		if (root != null) {
			printInorderTraversal(root.left);
			System.out.print(root.data + " ");
			printInorderTraversal(root.right);
		}
	}

	public static TreeNode deleteRecursively(TreeNode root, int value) {

		if (root == null)
			return root;

		if (value < (int) root.data) {
			root.left = deleteRecursively(root.left, value);
		} else if (value > (int) root.data) {
			root.right = deleteRecursively(root.right, value);
		} else {

			if (root.left == null) {
				return root.right;
			} else if (root.right == null)
				return root.left;

			root.data = inOrderSuccessor(root.right);

			root.right = deleteRecursively(root.right, (int) root.data);
		}

		return root;

	}

	public static int inOrderSuccessor(TreeNode root) {
		int minimum = (int) root.data;
		while (root.left != null) {
			minimum = (int) root.left.data;
			root = root.left;
		}
		return minimum;
	}

	public static TreeNode deleteNodeIteratively(TreeNode root, int value) {
		TreeNode parent = null, current = root;
		boolean hasLeft = false;

		if (root == null)
			return root;

		while (current != null) {
			if ((int) current.data == value) {
				break;
			}

			parent = current;
			if (value < (int) current.data) {
				hasLeft = true;
				current = current.left;
			} else {
				hasLeft = false;
				current = current.right;
			}
		}

		if (parent == null) {
			return deleteNodeIteratively(current);
		}

		if (hasLeft) {
			parent.left = deleteNodeIteratively(current);
		} else {
			parent.right = deleteNodeIteratively(current);
		}

		return root;
	}

	private static TreeNode deleteNodeIteratively(TreeNode node) {

		if (node != null) {
			if (node.left == null && node.right == null) {
				return null;
			}

			if (node.left != null && node.right != null) {
				TreeNode inOrderSuccessor = deleteInOrderSuccessorDuplicate(node);
				node.data = inOrderSuccessor.data;
			} else if (node.left != null) {
				node = node.left;
			} else {
				node = node.right;
			}
		}

		return node;
	}

	private static TreeNode deleteInOrderSuccessorDuplicate(TreeNode node) {
		TreeNode parent = node;
		node = node.right;
		boolean rightChild = node.left == null;

		while (node.left != null) {
			parent = node;
			node = node.left;
		}

		if (rightChild) {
			parent.right = node.right;
		} else {
			parent.left = node.right;
		}

		node.right = null;
		return node;
	}

}
