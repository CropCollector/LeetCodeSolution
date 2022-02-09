package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//Java：二叉树每层的最大值
public class HPov7L {
    public static void main(String[] args) {
        Solution solution = new HPov7L().new Solution();
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root != null) {
                Queue<TreeNode> q = new ArrayDeque<>();
                q.add(root);
                int count = 1;
                while (!q.isEmpty()) {
                    int nextCount = 0, max = Integer.MIN_VALUE;
                    for (int i = 1; i <= count; i++) {
                        TreeNode node = q.poll();
                        max = Math.max(max, node.val);
                        if (node.left != null) {
                            q.add(node.left);
                            nextCount ++;
                        }
                        if (node.right != null) {
                            q.add(node.right);
                            nextCount ++;
                        }
                    }
                    count = nextCount;
                    ans.add(max);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}