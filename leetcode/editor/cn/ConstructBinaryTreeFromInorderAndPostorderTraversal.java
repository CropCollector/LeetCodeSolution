//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 638 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        System.out.println(solution.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
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

        private HashMap<Integer, Integer> inorderMap = new HashMap<>();

        private int[] inorder;

        private int[] postorder;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;
            int len = inorder.length;
            for (int i = 0; i < len; i++) {
                inorderMap.put(inorder[i], i);
            }
            return createNode(0, len - 1, 0, len - 1);
        }

        private TreeNode createNode(int pStart, int pEnd, int iStart, int iEnd) {
            if (iStart > iEnd) {
                return null;
            }
            int val = postorder[pEnd], index = inorderMap.get(val);
            int size = iEnd - index;
            TreeNode node = new TreeNode(val);
            node.left = createNode(pStart, pEnd - size - 1, iStart, index - 1);
            node.right = createNode(pEnd - size, pEnd - 1, index + 1, iEnd);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
