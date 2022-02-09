package leetcode.editor.cn.contest;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class ContestSolution {
    public static void main(String[] args) {
        Solution solution = new ContestSolution().new Solution();
        System.out.println(solution.minimumDifference(new int[]{7,9,5,8,1,3}));

    }

    class Solution {
        public long minimumDifference(int[] nums) {
            int m = nums.length;
            int n = m / 3;
            PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
            long sum = 0;
            for (int i = m - n; i < m; i++) {
                minPQ.add(nums[i]);
                sum += nums[i];
            }
            long[] sufMax = new long[m - n + 1]; // 后缀最大和
            sufMax[m - n] = sum;
            for (int i = m - n - 1; i >= n; --i) {
                minPQ.add(nums[i]);
                sum += nums[i] - minPQ.poll();
                sufMax[i] = sum;
            }

            PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
            long preMin = 0L; // 前缀最小和
            for (int i = 0; i < n; ++i) {
                maxPQ.add(nums[i]);
                preMin += nums[i];
            }
            long ans = preMin - sufMax[n];
            for (int i = n; i < m - n; ++i) {
                maxPQ.add(nums[i]);
                preMin += nums[i] - maxPQ.poll();
                ans = Math.min(ans, preMin - sufMax[i + 1]);
            }
            return ans;
        }
    }
}