package leetcode.editor.cn;

//Java：扁平化多级双向链表
public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenAMultilevelDoublyLinkedList().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Solution {

    private Node ans;
    private Node p;

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        ans = new Node();
        p = ans;
        dfs(head);
        p.next = null;
        ans.next.prev = null;
        return ans.next;
    }

    public void dfs(Node n) {
        if (n == null) {
            return;
        }
        Node nn = new Node();
        nn.val = n.val;
        p.next = nn;
        nn.prev = p;
        p = p.next;
        dfs(n.child);
        dfs(n.next);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}