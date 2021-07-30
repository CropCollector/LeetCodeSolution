package leetcode.editor.cn;

//Java：填充每个节点的下一个右侧节点指针
public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
*/

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}



class Solution {
    public Node connect(Node root) {
        if (root != null) {
            LDR(root);
        }
        return root;
    }

    private void LDR(Node node) {
        if (node.left == null) {
            return;
        }
        node.left.next = node.right;
        if (node.next == null) {
            node.right.next = null;
        } else {
            node.right.next = node.next.left;
        }
        LDR(node.left);
        LDR(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}