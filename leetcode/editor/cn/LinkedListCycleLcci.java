package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Java：环路检测
public class LinkedListCycleLcci {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleLcci().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode n = head;
        while (n != null) {
            if (set.contains(n)) {
                return n;
            }
            set.add(n);
            n = n.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}