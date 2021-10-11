package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//Java：二叉树的序列化与反序列化
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBinaryTree().new Codec();
        // TO TEST
        System.out.println(solution.serialize(solution.deserialize("#")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            ldr(root, sb);
            return sb.toString();
        }

        private void ldr(TreeNode node, StringBuffer sb) {
            if (node == null) {
                sb.append("#").append(" ");
                return;
            }
            sb.append(node.val).append(" ");
            ldr(node.left, sb);
            ldr(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(" ");
            Queue<String> q = new ArrayDeque<>();
            for (String s : arr) {
                q.add(s);
            }

            String firstNodeVal = q.poll();
            if (firstNodeVal.equals("#")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(firstNodeVal));
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            TreeNode cur = root;
            boolean isLeft = true;
            while (!q.isEmpty()) {
                String nextNodeVal = q.poll();
                if (nextNodeVal.equals("#")) {
                    if (isLeft) {
                        isLeft = false;
                    } else {
                        cur = stack.pop();
                    }
                } else {
                    TreeNode node = new TreeNode(Integer.parseInt(nextNodeVal));
                    if (isLeft) {
                        stack.add(cur);
                        cur.left = node;
                    } else {
                        cur.right = node;
                    }
                    cur = node;
                    isLeft = true;
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}