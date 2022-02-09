package leetcode.editor.cn;

import java.util.*;

//Java：查找和最小的K对数字
public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
        // TO TEST
        System.out.println(solution.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3111));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int len1 = nums1.length, len2 = nums2.length;

            PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> nums1[a.get(0)] + nums2[a.get(1)] - nums1[b.get(0)] - nums2[b.get(1)]);
            for (int i = 0; i < len2; i++) {
                pq.add(Arrays.asList(0, i));
            }

            List<List<Integer>> ans = new ArrayList<>();
            while (!pq.isEmpty() && ans.size() < k) {
                List<Integer> list = pq.poll();
                int c = list.get(0), r = list.get(1);
                ans.add(Arrays.asList(nums1[c], nums2[r]));
                if (c + 1 == len1) {
                    continue;
                } else {
                    pq.add(Arrays.asList(c + 1, r));
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}