package leetcode.editor.cn;

import java.util.PriorityQueue;

//Java：K 次取反后最大化的数组和
public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new MaximizeSumOfArrayAfterKNegations().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 1; i <= k; i++) {
            pq.add(- pq.poll());
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}