package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：合并二叉树
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        LDRWithMerge(root1, root2);
        return root1;
    }

    private void LDRWithMerge(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return;
        }
        root1.val += root2.val;
        if (root1.left != null) {
            LDRWithMerge(root1.left, root2.left);
        } else if (root2.left != null) {
            root1.left = root2.left;
        }

        if (root1.right != null) {
            LDRWithMerge(root1.right, root2.right);
        } else if (root2.right != null) {
            root1.right = root2.right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}