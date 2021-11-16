package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：数组中的第K个最大元素
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = pq.poll();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}