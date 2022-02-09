package leetcode.editor.cn;

//Java：相交链表
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pa = headA, pb = headB;
            while (pa != null && pb != null) {
                pa = pa.next;
                pb = pb.next;
            }
            ListNode pa2 = headA, pb2 = headB;
            if (pa == null) {
                while (pb != null) {
                    pb = pb.next;
                    pb2 = pb2.next;
                }
            } else {
                while (pa != null) {
                    pa = pa.next;
                    pa2 = pa2.next;
                }
            }
            while (pa2 != null && pb2 != null) {
                if (pa2 == pb2) {
                    return pa2;
                }
                pa2 = pa2.next;
                pb2 = pb2.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}