package leetcode.editor.cn;

import java.util.List;

//Java：回文链表
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // TO TEST
        ListNode n4 = new PalindromeLinkedList().new ListNode(1);
        ListNode n3 = new PalindromeLinkedList().new ListNode(2, n4);
        ListNode n2 = new PalindromeLinkedList().new ListNode(2, n3);
        ListNode n1 = new PalindromeLinkedList().new ListNode(1, n2);
        System.out.println(solution.isPalindrome(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
        public boolean isPalindrome(ListNode head) {
            ListNode halfHead = getHalfHead(head);
            ListNode newHead = reverseHead(halfHead);
            while (newHead != null) {
                if (head.val != newHead.val) {
                    return false;
                }
                head = head.next;
                newHead = newHead.next;
            }
            return true;
        }

        private ListNode reverseHead(ListNode head) {
            ListNode p = head;
            while (p.next != null) {
                ListNode next = p.next;
                p.next = p.next.next;
                next.next = head;
                head = next;
            }
            return head;
        }

        private ListNode getHalfHead(ListNode head) {
            ListNode f = head, s = head;
            while (f != null) {
                if (f.next == null) {
                    break;
                }
                f = f.next.next;
                s = s.next;
            }
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
