package org.example.tree;

import org.example.queue.ArrayQueue;

/**
 * 二叉树计数
 *
 * @className: SizeOfBinaryTree
 * @author: Max Solider
 * @date: 2023-06-11 16:26
 */
public class SizeOfBinaryTree {

    /**
     * 递归遍历计数二叉树结点数
     *
     * @param root 根结点
     * @return 结点个数
     */
    public static int countBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return countBinaryTree(root.getLeft()) + 1 + countBinaryTree(root.getRight());
    }

    /**
     * 层次遍历二叉树 计数
     *
     * @param root 根结点
     * @return 结点个数
     */
    public static int countBinaryTreeWithLevelOrder(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayQueue queue = new ArrayQueue(20);
        queue.enQueue(root);
        int count = 1;
        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = (BinaryTreeNode) queue.deQueue();
            count++;
            if (tmp.getLeft() != null) {
                queue.enQueue(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.enQueue(tmp.getRight());
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        System.out.println(countBinaryTree(node1));
        System.out.println(countBinaryTreeWithLevelOrder(node1));
    }
}
