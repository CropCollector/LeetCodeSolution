package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树中和为某一值的路径
public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
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

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root != null) {
                dfs(root, target, 0, new ArrayList<>());
            }
            return ans;
        }

        private void dfs(TreeNode node, int target, int sum, List<Integer> path) {
            sum += node.val;
            path.add(node.val);
            if (node.left == null && node.right == null) {
                if (target == sum) {
                    ans.add(new ArrayList<>(path));
                }
            } else {
                if (node.left != null) {
                    dfs(node.left, target, sum, path);
                }
                if (node.right != null) {
                    dfs(node.right, target, sum, path);
                }
            }
            path.remove(path.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}