package leetcode.editor.cn;

//Java：二叉树的最近公共祖先
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
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

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p, q);
            return ans;
        }

        private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return false;
            }
            boolean left = dfs(node.left, p, q);
            boolean right = dfs(node.right, p, q);
            if ((left && right ) || ((p.val == node.val || q.val == node.val) && (left || right))) {
                ans = node;
            }
            return left || right || p.val == node.val || q.val == node.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}