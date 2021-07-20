package leetcode.editor.cn;

//Java：删除链表的倒数第 N 个结点
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nHead = new ListNode();
        nHead.next = head;
        ListNode f = nHead, s = nHead;
        int count = 0;
        while (f.next != null) {
            f = f.next;
            count ++;
            if (count > n) {
                s = s.next;
            }
        }
        if (s == nHead) {
            return s.next.next;
        }
        s.next = s.next.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}