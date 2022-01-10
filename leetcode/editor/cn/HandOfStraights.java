package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

//Java：一手顺子
public class HandOfStraights {
    public static void main(String[] args) {
        Solution solution = new HandOfStraights().new Solution();
        // TO TEST
        System.out.println(solution.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            Arrays.sort(hand);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : hand) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            for (int i : hand) {
                if (!map.containsKey(i)) {
                    continue;
                }
                int count = map.get(i);
                for (int j = 0; j < groupSize; j++) {
                    int nextCount = map.getOrDefault(i + j, 0);
                    if (nextCount < count) {
                        return false;
                    } else {
                        if (nextCount - count == 0) {
                            map.remove(i + j);
                        } else {
                            map.put(i + j, nextCount - count);
                        }
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}