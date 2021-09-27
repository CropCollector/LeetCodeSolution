package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

//Java：K 站中转内最便宜的航班
public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        Solution solution = new CheapestFlightsWithinKStops().new Solution();
        // TO TEST
        System.out.println(solution.findCheapestPrice(3, new int[][]{{0,1,100}, {1,2,100}, {0,2,500}}, 0, 2, 1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 10000 * 101 + 1;

        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][src] = 0;
        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                dp[t][i] = Math.min(dp[t][i], dp[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, dp[t][dst]);
        }
        return (ans == INF ? -1 : ans);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}