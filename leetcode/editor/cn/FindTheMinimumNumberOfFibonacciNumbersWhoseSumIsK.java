package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：和为 K 的最少斐波那契数字数目
public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    public static void main(String[] args) {
        Solution solution = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinFibonacciNumbers(int k) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            int next;
            while ((next = list.get(list.size() - 2) + list.get(list.size() - 1)) <= k) {
                list.add(next);
            }

            int ans = 0, i = list.size() - 1;
            while (k != 0) {
                if (k >= list.get(i)) {
                    ans ++;
                    k -= list.get(i);
                } else {
                    i --;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}