package leetcode.editor.cn;

import java.util.HashMap;

//Java：从前序与中序遍历序列构造二叉树
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // TO TEST
        System.out.println(solution.buildTree(new int[]{1,2,3}, new int[]{3,2,1}));
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

        private HashMap<Integer, Integer> preorderMap = new HashMap<>();

        private HashMap<Integer, Integer> inorderMap = new HashMap<>();

        private int[] preorder;

        private int[] inorder;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;

            int len = preorder.length;
            for (int i = 0; i < len; i++) {
                preorderMap.put(preorder[i], i);
                inorderMap.put(inorder[i], i);
            }
            return createNode(0, len - 1, 0, len - 1);
        }

        private TreeNode createNode(int pStart, int pEnd, int iStart, int iEnd) {
            if (iStart > iEnd || pStart > pEnd) {
                return null;
            }
            // val - 当前创建的节点值，indexInorder - 当前节点值在中序中的index
            int val = preorder[pStart], indexInorder = inorderMap.get(val);
            // 这里直接计算左边节点的个数，从而避免了通过中序中左右两个子数组的起始节点再到前序中找前序子数组的位置的操作，避免了很多边界情况
            int leftSize = indexInorder - iStart;
            TreeNode node = new TreeNode(val);
            node.left = createNode(pStart + 1, pStart + leftSize, iStart, indexInorder - 1);
            node.right = createNode(pStart + leftSize + 1, pEnd, indexInorder + 1, iEnd);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}