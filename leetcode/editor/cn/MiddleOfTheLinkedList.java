package leetcode.editor.cn;

//Java：链表的中间结点
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}