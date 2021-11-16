package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Stack;

//Java：路径总和 III
public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
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

        int ans;
        int targetSum;

        public int pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            dfs(root, 0, new Stack<Integer>());
            return ans;
        }

        private void dfs(TreeNode node, int sum, Stack<Integer> nodeList) {
            if (node == null) {
                return;
            }
            sum += node.val;
            if (sum == targetSum) {
                ans ++;
            }
            int tmp = sum;
            for (Integer i : nodeList) {
                if (tmp - i == targetSum) {
                    ans ++;
                }
                tmp -= i;
            }
            nodeList.add(node.val);
            dfs(node.left, sum, nodeList);
            dfs(node.right, sum, nodeList);
            nodeList.pop();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}