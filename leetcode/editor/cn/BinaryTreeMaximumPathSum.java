package leetcode.editor.cn;

//Java：二叉树中的最大路径和
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
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
        int ans = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftValue = Math.max(dfs(node.left), 0);
            int rightValue = Math.max(dfs(node.right), 0);
            int curValue = node.val + leftValue + rightValue;
            ans = Math.max(ans, curValue);
            return node.val + Math.max(leftValue, rightValue);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}