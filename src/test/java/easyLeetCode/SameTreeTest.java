package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

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

class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        var tmpQ = new TreeNode();
        var tmpP = new TreeNode();

        tmpQ.right = q;
        tmpP.right = p;
        while (p != null && q != null) {
            if (p.val != q.val) return false;
            p = p.left;
            q = q.left;
        }
        if (p != null || q != null) return false;

        while (tmpQ.right != null && tmpP.right != null) {
            if (tmpQ.right.val != tmpP.right.val) return false;
            tmpQ.right = tmpQ.right.right;
            tmpP.right = tmpP.right.right;
        }
        return tmpQ.right == null && tmpP.right == null;
    }
}

public class SameTreeTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    """
                            '[390,255,2266,-273,337,1105,3440,-425,4113,null,null,600,1355,3241,4731,-488,-367,16,null,565,780,1311,1755,3075,3392,4725,4817,null,null,null,null,
                              -187,152,395,null,728,977,1270,null,1611,1786,2991,3175,3286,null,164,null,null,4864,-252,-95,82,null,391,469,638,769,862,1045,1138,null,1460,1663,
                              null,1838,2891,null,null,null,null,3296,3670,4381,null,4905,null,null,null,-58,null,null,null,null,null,null,null,null,734,null,843,958,null,null,
                              null,1163,1445,1533,null,null,null,2111,2792,null,null,null,3493,3933,4302,4488,null,null,null,null,null,null,819,null,null,null,null,1216,null,null
                              ,1522,null,1889,2238,2558,2832,null,3519,3848,4090,4165,null,4404,4630,null,null,null,null,null,null,1885,2018,2199,null,2364,2678,null,null,null,
                              3618,3751,null,4006,null,null,4246,null,null,4554,null,null,null,1936,null,null,null,null,2444,2642,2732,null,null,null,null,null,null,null,4253,
                              null,null,null,null,2393,2461,null,null,null,null,4250,null,null,null,null,2537]',    '[390,255,2266,-273,337,1105,3440,-425,4113,null,null,600,1355,
                              3241,4731,-488,-367,16,null,565,780,1311,1755,3075,3392,4725,4817,null,null,null,null,-187,152,395,null,728,977,1270,null,1611,1786,2991,3175,3286,
                              null,164,null,null,4864,-252,-95,82,null,391,469,638,769,862,1045,1138,null,1460,1663,null,1838,2891,null,null,null,null,3296,3670,4381,null,4905,
                              null,null,null,-58,null,null,null,null,null,null,null,null,734,null,843,958,null,null,null,1163,1445,1533,null,null,null,2111,2792,null,null,null,
                              3493,3933,4302,4488,null,null,null,null,null,null,819,null,null,null,null,1216,null,null,1522,null,1889,2238,2558,2832,null,3519,3848,4090,4165,
                              null,4404,4630,null,null,null,null,null,null,1885,2018,2199,null,2364,2678,null,null,null,3618,3751,null,4006,null,null,4246,null,null,4554,null,
                              null,null,1936,null,null,null,null,2444,2642,2732,null,null,null,null,null,null,null,4253,null,null,null,null,2461,2393,null,null,null,null,4250,
                              null,null,null,null,2537]'"""
            }
    )
    void test(String sp, String sq) {
        TreeNode p;
        TreeNode q;
        SameTree sameTree = new SameTree();

        p = toTreeNode(sp);
        q = toTreeNode(sq);

        Assertions.assertFalse(sameTree.isSameTree(p, q));

    }

    TreeNode toTreeNode(String s) {
        if (s.charAt(0) == '[') s = s.substring(1, s.length() - 1);
        List<TreeNode> nodes = Arrays.stream(s.split(","))
                .map(i -> i.trim().equals("null") ? null : new TreeNode(Integer.parseInt(i.trim())))
                .toList();
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
