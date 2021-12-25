package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：不同的二叉搜索树 II
public class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
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


    class Solution {

        public List<TreeNode> generateTrees(int n) {
            return generate(1, n);
        }

        private List<TreeNode> generate(int start, int end) {
            List<TreeNode> allTrees = new ArrayList<>();
            if (start > end) {
                allTrees.add(null);
                return allTrees;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = generate(start, i - 1);
                List<TreeNode> right = generate(i + 1, end);
                for (TreeNode leftTree : left) {
                    for (TreeNode rightTree : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        allTrees.add(root);
                    }
                }
            }
            return allTrees;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}