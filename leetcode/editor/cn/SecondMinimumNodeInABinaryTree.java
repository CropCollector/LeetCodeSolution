package leetcode.editor.cn;

import com.sun.media.sound.DLSRegion;

import java.util.ArrayDeque;
import java.util.Queue;

//Java：二叉树中第二小的节点
public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
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
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        Long second = Long.MAX_VALUE;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val > root.val) {
                second = Math.min(second, node.val);
            } else {
                if (node.left != null) {
                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }
        return second == Long.MAX_VALUE ? -1 : second.intValue();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}