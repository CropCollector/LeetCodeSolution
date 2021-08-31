package leetcode.editor.cn;

import java.util.Arrays;

//Java：完成任务的最少工作时间段
public class MinimumNumberOfWorkSessionsToFinishTheTasks {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfWorkSessionsToFinishTheTasks().new Solution();
        // TO TEST
        System.out.println(solution.minSessions(new int[]{1,2,3}, 3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length, status = 1 << n;

        boolean[] flag = new boolean[status];
        for (int i = 0; i < status; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int mask = 1 << j;
                if ((i & mask) == mask) {
                    sum += tasks[j];
                }
            }
            if (sum <= sessionTime) {
                flag[i] = true;
            }
        }

        int[] dp = new int[status];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < status; i++) {
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (flag[j]) {
                    dp[i] = Math.min(dp[i], dp[i ^ j] + 1);
                }
            }
        }
        return dp[status - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}