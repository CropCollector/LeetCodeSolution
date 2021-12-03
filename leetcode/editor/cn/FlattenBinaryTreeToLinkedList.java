package leetcode.editor.cn;

import java.util.Stack;

//Java：二叉树展开为链表
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
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
        public void flatten(TreeNode root) {
            TreeNode faker = new TreeNode();
            TreeNode parentNode = faker;
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) {
                    System.out.println("null");
                    continue;
                }
                System.out.println(node.val);
                parentNode.left = null;
                parentNode.right = node;
                parentNode = parentNode.right;
                stack.add(node.right);
                stack.add(node.left);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}