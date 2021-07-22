package leetcode.editor.cn;

//Java：两个链表的第一个公共节点
public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
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
        ListNode pShort, pLong;
        if (pa == null) {
            pShort = headA;
            pLong = headB;
            while (pb != null) {
                pb = pb.next;
                pLong = pLong.next;
            }
        } else {
            pShort = headB;
            pLong = headA;
            while (pa != null) {
                pa = pa.next;
                pLong = pLong.next;
            }
        }
        while (pLong != null) {
            if (pShort == pLong) {
                return pLong;
            }
            pShort = pShort.next;
            pLong = pLong.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}