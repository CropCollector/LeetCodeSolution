package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：复杂链表的复制
public class FuZaLianBiaoDeFuZhiLcof {
    public static void main(String[] args) {
        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
            // 通过node拿到index，然后用index去cpMap中用index换对应的Node
            Map<Node, Integer> map = new HashMap<>();
            Map<Integer, Node> cpMap = new HashMap<>();

            Node faker = new Node(-1);
            Node p = head, cp = faker;
            int i = 0;
            while (p != null) {
                map.put(p, i);
                cp.next = new Node(p.val);
                cpMap.put(i, cp.next);

                i++;
                p = p.next;
                cp = cp.next;
            }

            p = head;
            cp = faker;
            while (p != null) {
                cp.next.random = cpMap.get(map.get(p.random));
                p = p.next;
                cp = cp.next;
            }
            return faker.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}