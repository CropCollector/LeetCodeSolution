package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的中序遍历
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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

        private List<Integer> ans = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            ldr(root);
            return ans;
        }

        private void ldr(TreeNode node) {
            if (node == null) {
                return;
            }
            ldr(node.left);
            ans.add(node.val);
            ldr(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}