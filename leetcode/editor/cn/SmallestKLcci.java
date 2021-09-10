package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.PriorityQueue;

//Java：最小K个数
public class SmallestKLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            ans.add(pq.poll());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}