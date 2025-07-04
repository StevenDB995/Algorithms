package tree.binarytree.traversal;

import tree.binarytree.TreeNode;

import java.util.*;

public class PostOrderTraversal {

    public static List<Integer> traverseRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseRecursion(root, result);
        return result;
    }

    private static void traverseRecursion(TreeNode node, List<Integer> result) {
        if (node != null) {
            traverseRecursion(node.left, result);
            traverseRecursion(node.right, result);
            result.add(node.value);
        }
    }

    public static List<Integer> traverseStack(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        TreeNode prev = null; // The last node added to the result list
        pushAll(root, stack);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            // Add the node to the result list if
            // 1. it does not have a right child, or;
            // 2. its right child is the last element in the result list,
            // i.e. its entire right subtree has been processed.
            if (node.right == null || node.right == prev) {
                node = stack.pop();
                result.add(node.value);
                prev = node;
            } else {
                pushAll(node.right, stack);
            }
        }

        return result;
    }

    private static void pushAll(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

}
