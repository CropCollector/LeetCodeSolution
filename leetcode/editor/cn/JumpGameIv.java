package leetcode.editor.cn;

import java.util.*;

//Java：跳跃游戏 IV
public class JumpGameIv {
    public static void main(String[] args) {
        Solution solution = new JumpGameIv().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minJumps(int[] arr) {
            int len = arr.length;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                List<Integer> list = map.getOrDefault(arr[i], new LinkedList<>());
                list.add(0 ,i);
                map.put(arr[i], list);
            }

            Set<Integer> flag = new HashSet<>();
            /**
             * poll[0] - 当前位置
             * poll[1] - step
             */
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{0, 0});
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                int curIndex = poll[0], step = poll[1];
                if (curIndex == len - 1) {
                    return step;
                }
                if (curIndex < 0 || curIndex == len) {
                    continue;
                }
                if (flag.contains(curIndex)) {
                    continue;
                }
                flag.add(curIndex);

                if (map.containsKey(arr[curIndex])) {
                    List<Integer> list = map.get(arr[curIndex]);
                    for (Integer index : list) {
                        if (index != curIndex) {
                            q.add(new int[]{index, step + 1});
                        }
                    }
                    map.remove(arr[curIndex]);
                }
                q.add(new int[]{curIndex + 1, step + 1});
                q.add(new int[]{curIndex - 1, step + 1});
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}