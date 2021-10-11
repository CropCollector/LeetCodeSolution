package leetcode.editor.cn;

import java.util.ArrayList;

//Java：二叉搜索树中第K小的元素
public class KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();
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
        public int kthSmallest(TreeNode root, int k) {
            ArrayList<Integer> arr = new ArrayList<>();
            ldr(root, arr);
            return arr.get(k - 1);
        }

        private void ldr(TreeNode node, ArrayList<Integer> arr) {
            if (node == null) {
                return;
            }
            ldr(node.left, arr);
            arr.add(node.val);
            ldr(node.right, arr);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}