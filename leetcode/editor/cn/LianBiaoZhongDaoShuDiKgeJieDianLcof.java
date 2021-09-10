package leetcode.editor.cn;

//Java：链表中倒数第k个节点
public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
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
        }
    }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode f = head, s = head;
            for (int i = 1; f != null; i++) {
                if (i > k) {
                    s = s.next;
                }
                f = f.next;
            }
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}