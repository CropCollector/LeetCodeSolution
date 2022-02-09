package leetcode.editor.cn;

//Java：二叉树的最大深度
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
        public int maxDepth(TreeNode root) {
            return dfs(root);
        }

        private int dfs(TreeNode node) {
            return node == null ? 0 : Math.max(dfs(node.left), dfs(node.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}