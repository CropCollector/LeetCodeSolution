package leetcode.editor.cn;

//Java：二叉树的坡度
public class BinaryTreeTilt {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeTilt().new Solution();
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

        private int ans = 0;

        public int findTilt(TreeNode root) {
            lrd(root);
            return ans;
        }

        private int lrd(TreeNode n) {
            if (n == null) {
                return 0;
            }
            int l = lrd(n.left);
            int r = lrd(n.right);
            ans += Math.abs(l - r);
            return l + r + n.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}