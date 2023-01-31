package easyLeetCode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        return count;
    }

}

public class MaximumDepthOfBinaryTreeTest {


    @ParameterizedTest
    @CsvSource(
            value = {
                    "'[3,9,20,null,null,15,7]', 3",
                    "'[1,null,2]', 2",
                    "'0,2,4,1,null,3,-1,5,1,null,6,null,8', 4"
            }
    )
    void test(String root, int countOfDepth) {
        TreeNode treeNode = toTreeNode(root);
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();

        int i = maximumDepthOfBinaryTree.maxDepth(treeNode);

        Assertions.assertEquals(countOfDepth, i);
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
