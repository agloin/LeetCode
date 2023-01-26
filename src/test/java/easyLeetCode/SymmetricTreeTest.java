package easyLeetCode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;


// https://leetcode.com/problems/symmetric-tree/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;

        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();

        stackLeft.push(root.left);
        stackRight.push(root.right);

        while (!stackLeft.empty() && !stackRight.empty()) {
            TreeNode treeNodeLeft = stackLeft.pop();
            TreeNode treeNodeRight = stackRight.pop();

            if (treeNodeLeft.val != treeNodeRight.val) return false;
            if (treeNodeLeft.left != null && treeNodeRight.right != null) {
                stackLeft.push(treeNodeLeft.left);
                stackRight.push(treeNodeRight.right);
            } else if (treeNodeLeft.left == null && treeNodeRight.right == null) {} else return false;

            if (treeNodeLeft.right != null && treeNodeRight.left != null) {
                stackLeft.push(treeNodeLeft.right);
                stackRight.push(treeNodeRight.left);
            } else if (treeNodeLeft.right == null && treeNodeRight.left == null) {} else return false;

        }
        return stackLeft.empty() && stackRight.empty();
    }
}


public class SymmetricTreeTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'[1,2,2,3,4,4,3]', true",
                    "'[1,2,2,3,4,4,3,5,6,7,8,8,7,6,5]', true",
                    "'[1,2,2,null,3,null,3]', false",
                    "'[1,null,null]', true",
                    "'[1,2,null]', false"

            }
    )
    void sameTreeTest(String sp, boolean res) {
        TreeNode root;
        SymmetricTree sameTree = new SymmetricTree();

        root = toTreeNode(sp);

        Assertions.assertEquals(res, sameTree.isSymmetric(root));
    }

    TreeNode toTreeNode(String s) {
        if (s.charAt(0) == '[') s = s.substring(1, s.length() - 1);
        List<TreeNode> nodes = Arrays.stream(s.split(",")).map(i -> i.trim().equals("null") ? null : new TreeNode(Integer.parseInt(i.trim()))).toList();
        int ln = 1;
        int idx = 0;
        while (idx < nodes.size()) {
            int cnt = 0;
            for (int i = 0; i < ln && idx + i < nodes.size(); i++) {
                TreeNode node = nodes.get(idx + i);
                if (node == null) continue;
                int leftIndex = idx + ln + cnt * 2;
                int rightIndex = leftIndex + 1;
                cnt++;
                if (leftIndex < nodes.size() && nodes.get(leftIndex) != null) {
                    node.left = nodes.get(leftIndex);
                }
                if (rightIndex < nodes.size() && nodes.get(rightIndex) != null) {
                    node.right = nodes.get(rightIndex);
                }
            }
            idx += ln;
            ln = cnt * 2;
        }
        return nodes.get(0);
    }
}
