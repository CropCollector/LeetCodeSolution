package leetcode.editor.cn;

import java.util.*;

//Java：从上到下打印二叉树 III
public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root != null) {
                Queue<TreeNode> q = new ArrayDeque<>();
                q.add(root);
                int count = 1, level = 1;
                while (!q.isEmpty()) {
                    List<Integer> list = new ArrayList<>();
                    int nextCount = 0;
                    for (int i = 1; i <= count; i++) {
                        TreeNode node = q.poll();
                        if ((level & 1) == 1) {
                            list.add(node.val);
                        } else {
                            list.add(0, node.val);
                        }
                        if (node.left != null) {
                            q.add(node.left);
                            nextCount++;
                        }
                        if (node.right != null) {
                            q.add(node.right);
                            nextCount++;
                        }
                    }
                    ans.add(list);
                    count = nextCount;
                    level++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}