package leetcode.editor.cn;

//Java：翻转二叉树
public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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
        public TreeNode invertTree(TreeNode root) {
            invert(root);
            return root;
        }

        private void invert(TreeNode node) {
            if (node == null) {
                return;
            }
            invert(node.left);
            invert(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}