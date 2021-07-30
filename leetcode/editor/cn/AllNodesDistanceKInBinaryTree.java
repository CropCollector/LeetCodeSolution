package leetcode.editor.cn;

import java.util.*;

//Java：二叉树中所有距离为 K 的结点
public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 *  */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    HashMap<TreeNode, TreeNode> map = new HashMap<>();

    List<Integer> list = new LinkedList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dlr(root);
        bfs(target, k);
        return list;
    }

    private void bfs(TreeNode target, int k) {
        HashMap<TreeNode, Integer> floorMap = new HashMap<>();
        HashSet<TreeNode> set = new HashSet<>();
        floorMap.put(target, 0);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(target);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            set.add(node);
            int floor = floorMap.get(node);
            if (floor == k) {
                list.add(node.val);
            } else {
                if (node.left != null && !set.contains(node.left)) {
                    q.add(node.left);
                    floorMap.put(node.left, floor + 1);
                }
                if (node.right != null&& !set.contains(node.right)) {
                    q.add(node.right);
                    floorMap.put(node.right, floor + 1);
                }
                TreeNode parentNode = map.get(node);
                if (parentNode != null && !set.contains(parentNode)) {
                    q.add(parentNode);
                    floorMap.put(parentNode, floor + 1);
                }
            }
        }
    }

    private void dlr(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
           map.put(node.left, node);
        }
        if (node.right != null) {
            map.put(node.right, node);
        }
        dlr(node.left);
        dlr(node.right);
    }

}


//leetcode submit region end(Prohibit modification and deletion)

}