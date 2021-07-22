package leetcode.editor.cn;

import java.util.HashMap;

//Java：复制带随机指针的链表
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
*/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {

    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        HashMap<Integer, Node> copyMap = new HashMap<>();

        Node p = head;
        Node fakerHead = new Node(0);
        Node cp = fakerHead;
        int i;
        for (i = 1; p != null; i++, p = p.next, cp = cp.next) {
            map.put(p, i);
            cp.next = new Node(p.val);
            copyMap.put(i, cp.next);
        }
        map.put(null, i);
        cp.next = null;
        copyMap.put(i, null);

        for (cp = fakerHead, p = head; p != null; p = p.next, cp = cp.next) {
            cp.next.random = copyMap.get(map.get(p.random));
        }
        return fakerHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}