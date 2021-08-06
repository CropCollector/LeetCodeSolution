package leetcode.editor.cn;

import java.util.*;

//Java：网络延迟时间
public class NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();
        // TO TEST
        System.out.println(solution.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int MAX_VALUE = 10000000;
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], MAX_VALUE);
        }
        for (int i = 0; i < times.length; i++) {
            graph[times[i][0]][times[i][1]] = times[i][2];
        }

        boolean[] flag = new boolean[n + 1];
        int[] dis = new int[n + 1];
        Arrays.fill(dis, MAX_VALUE);
        dis[k] = 0;

        for (int round = 1; round <= n - 1; round++) {
            int min = MAX_VALUE, index = -1;
            for (int i = 1; i < dis.length; i++) {
                // 寻找dis中的最小值
                if (!flag[i] && dis[i] < min) {
                    min = dis[i];
                    index = i;
                }
            }
            if (index == -1) {
                break;
            }
            flag[index] = true;
            for (int i = 1; i < graph[index].length; i++) {
                dis[i] = Math.min(graph[index][i] + dis[index], dis[i]);
            }
        }

        int ans = 0;
        for (int i = 1; i < dis.length; i++) {
            if (dis[i] == MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dis[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}