package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//Java：任务调度器
public class TaskScheduler {
    public static void main(String[] args) {
        Solution solution = new TaskScheduler().new Solution();
        // TO TEST
        System.out.println(solution.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> map = new HashMap<>();
            for (char task : tasks) {
                map.put(task, map.getOrDefault(task, 0) + 1);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            for (Character c : map.keySet()) {
                pq.add(new int[]{c, map.get(c)});
            }

            int ans = 0;
            Set<int[]> tmp = new HashSet<>();
            while (!pq.isEmpty()) {
                for (int i = 1; i <= n + 1; i++) {
                    if (pq.isEmpty() && tmp.isEmpty()) {
                        break;
                    }
                    ans ++;
                    if (!pq.isEmpty()) {
                        int[] pair = pq.poll();
                        pair[1] --;
                        if (pair[1] != 0) {
                            tmp.add(pair);
                        }
                    }
                }
                pq.addAll(tmp);
                tmp.clear();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}