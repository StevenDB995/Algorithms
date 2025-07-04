package tree.binarytree.traversal;

import tree.binarytree.TreeNode;

import java.util.*;

public class PreOrderTraversal {

    public static List<Integer> traverseRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseRecursion(root, result);
        return result;
    }

    private static void traverseRecursion(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            traverseRecursion(node.left, result);
            traverseRecursion(node.right, result);
        }
    }

    public static List<Integer> traverseStack(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        pushAll(root, stack, result);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            pushAll(node.right, stack, result);
        }

        return result;
    }

    private static void pushAll(TreeNode node, Deque<TreeNode> stack, List<Integer> result) {
        while (node != null) {
            result.add(node.value);
            stack.push(node);
            node = node.left;
        }
    }

}
