package leetcode.editor.cn;

import java.util.HashMap;

//Java：统计不开心的朋友
public class CountUnhappyFriends {
    public static void main(String[] args) {
        Solution solution = new CountUnhappyFriends().new Solution();
        // TO TEST
        System.out.println(solution.unhappyFriends(4, new int[][]{{1,3,2},{2,3,0},{1,3,0},{0,2,1}},
                new int[][]{{1,3},{0,2}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] map = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                map[i][preferences[i][j]] = n - j;
            }
        }

        HashMap<Integer, Integer> pairMap = new HashMap<>();
        for (int[] i : pairs) {
            int x = i[0], y = i[1];
            pairMap.put(x, y);
            pairMap.put(y, x);
        }

        int ans = 0;
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j <= 1; j++) {
                int x = pairs[i][j], y = pairMap.get(x);
                //找到大于x对y的好感值的u
                for (int k = 0; map[x][preferences[x][k]] > map[x][y]; k++) {
                    int u = preferences[x][k];
                    int v = pairMap.get(u);
                    if (map[u][x] > map[u][v]) {
                        ans ++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}