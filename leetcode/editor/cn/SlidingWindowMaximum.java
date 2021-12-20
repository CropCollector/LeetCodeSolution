package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：滑动窗口最大值
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        // TO TEST
        System.out.println(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length, ansLen = len - k + 1;
            int[] ans = new int[ansLen];

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            for (int i = 0; i < k; i++) {
                pq.add(new int[]{nums[i], i});
            }
            for (int i = 0; i < ansLen; i++) {
                while (pq.peek()[1] < i || pq.peek()[1] >= i + k) {
                    pq.poll();
                }
                ans[i] = pq.peek()[0];
                if (i != ansLen - 1) {
                    pq.add(new int[]{nums[i + k], i + k});
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}