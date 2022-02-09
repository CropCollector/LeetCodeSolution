package leetcode.editor.cn;

//Java：验证二叉搜索树
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValid(TreeNode node, long min, long max) {
            if (node == null) {
                return true;
            }
            return isValid(node.left, min, node.val)
                    && isValid(node.right, node.val, max)
                    && (node.val > min && node.val < max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}