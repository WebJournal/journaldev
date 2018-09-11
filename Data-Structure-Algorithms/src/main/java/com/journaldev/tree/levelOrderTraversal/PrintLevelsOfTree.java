package com.journaldev.tree.levelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

import com.journaldev.tree.BinaryTree;
import com.journaldev.tree.BinaryTree.TreeNode;


public class PrintLevelsOfTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        /**
         * Binary Tree in our example, height = 2
         * 		1		(Root)
         * 	  2	  3		(Level 1)
         *  4    5		(Level 2)
         */
        binaryTree.root = new BinaryTree.TreeNode(1);
        binaryTree.root.left = new BinaryTree.TreeNode(2);
        binaryTree.root.right = new BinaryTree.TreeNode(3);
        binaryTree.root.left.left = new BinaryTree.TreeNode(4);
        binaryTree.root.right.left = new BinaryTree.TreeNode(5);

        printLevelsRecursively(binaryTree.root);
        printLevelsIteratively(binaryTree.root);
    }

    private static void printLevelsRecursively(TreeNode root) {
        int height = heightOfTree(root);

        for (int i = 1; i <= height; i++) {
            System.out.print("Level " + i + " : ");
            printSingleLevelRecursively(root, i);
            System.out.println();

        }
    }


    public static void printLevelsIteratively(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {


            TreeNode node = queue.peek();
            if (node != null) {
                System.out.print(node.data + " ");
                queue.remove();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

        }

    }


    private static int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static void printSingleLevelRecursively(TreeNode root, int level) {
        if (root == null)
            return;

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printSingleLevelRecursively(root.left, level - 1);
            printSingleLevelRecursively(root.right, level - 1);
        }
    }
}
