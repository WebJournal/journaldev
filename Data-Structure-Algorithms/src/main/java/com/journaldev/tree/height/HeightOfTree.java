package com.journaldev.tree.height;

import java.util.LinkedList;
import java.util.Queue;

import com.journaldev.tree.BinaryTree;
import com.journaldev.tree.BinaryTree.TreeNode;

public class HeightOfTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        /**
         * Binary Tree in our example, height = 2
         * 		1		(Root)
         * 	  2	  3		(Level 1)
         *  4    5		(Level 2)
         */
        binaryTree.root = new TreeNode(1);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.left.left = new TreeNode(4);
        binaryTree.root.right.left = new TreeNode(5);

        int heightOfTree = heightIteratively(binaryTree.root);
        System.out.printf("Height of tree is %d\n", heightOfTree);

        heightOfTree = heightRecursively(binaryTree.root);
        System.out.printf("Height of tree is %d", heightOfTree);
    }

    public static int heightRecursively(TreeNode root) {

        if (root == null)
            return -1;

        int leftHeight = heightRecursively(root.left);
        int rightHeight = heightRecursively(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int heightIteratively(TreeNode root) {

        if (root == null)
            return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            height++;

            while (size > 0) {
                TreeNode treeNode = queue.remove();

                if (treeNode.left != null)
                    queue.add(treeNode.left);

                if (treeNode.right != null)
                    queue.add(treeNode.right);

                size--;
            }
        }
        return height;
    }
}
