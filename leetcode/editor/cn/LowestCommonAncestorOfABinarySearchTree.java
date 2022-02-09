package leetcode.editor.cn;

//Java：二叉搜索树的最近公共祖先
public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        private TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return dfs(root, p, q);
        }

        private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
            if (node.val > p.val && node.val > q.val) {
                return dfs(node.left, p, q);
            }
            if (node.val < p.val && node.val < q.val) {
                return dfs(node.right, p, q);
            }
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}