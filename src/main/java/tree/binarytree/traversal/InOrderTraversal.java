package tree.binarytree.traversal;

import tree.binarytree.TreeNode;

import java.util.*;

public class InOrderTraversal {

    public static List<Integer> traverseRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseRecursion(root, result);
        return result;
    }

    private static void traverseRecursion(TreeNode node, List<Integer> result) {
        if (node != null) {
            traverseRecursion(node.left, result);
            result.add(node.value);
            traverseRecursion(node.right, result);
        }
    }

    public static List<Integer> traverseStack(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        pushAll(root, stack);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.value);
            pushAll(node.right, stack);
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
