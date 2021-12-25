package leetcode.editor.cn;

//Java：排序链表
public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        // TO TEST
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(solution.sortList(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
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
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            return merge(head);
        }

        private ListNode merge(ListNode node) {
            if (node.next == null) {
                return node;
            }
            ListNode halfNode = devideByhalf(node);
            return mergeList(merge(node), merge(halfNode));
        }

        private ListNode devideByhalf(ListNode node) {
            ListNode f = node, s = node;
            while (f != null && f.next != null && f.next.next != null) {
                f = f.next.next;
                s = s.next;
            }
            ListNode res = s.next;
            s.next = null;
            return res;
        }

        private ListNode mergeList(ListNode n1, ListNode n2) {
            ListNode head = new ListNode(), p = head;
            while (n1 != null && n2 != null) {
                if (n1.val < n2.val) {
                    p.next = n1;
                    n1 = n1.next;
                } else {
                    p.next = n2;
                    n2 = n2.next;
                }
                p = p.next;
            }
            p.next = n1 == null ? n2 : n1;
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}