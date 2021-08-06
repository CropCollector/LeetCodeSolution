package leetcode.editor.cn;

import java.util.*;

//Java：二叉树的垂序遍历
public class VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerticalOrderTraversalOfABinaryTree().new Solution();
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        dlr(root, map, 0, 0);
        for (TreeMap<Integer, List<Integer>> value : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (List<Integer> tmp : value.values()) {
                Collections.sort(tmp);
                list.addAll(tmp);
            }
            ans.add(list);
        }
        return ans;
    }

    private void dlr(TreeNode node, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, int x, int y) {
        TreeMap<Integer, List<Integer>> tmpMap = map.getOrDefault(x, new TreeMap<>());
        List<Integer> tmpList = tmpMap.getOrDefault(y, new ArrayList<>());
        tmpList.add(node.val);
        tmpMap.put(y, tmpList);
        map.put(x, tmpMap);
        if (node.left != null) {
            dlr(node.left, map, x - 1, y + 1);
        }
        if (node.right != null) {
            dlr(node.right, map, x + 1, y + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}