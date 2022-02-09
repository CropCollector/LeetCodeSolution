package leetcode.editor.cn;

import java.util.Stack;

//Java：每日温度
public class IIQa4I {
    public static void main(String[] args) {
        Solution solution = new IIQa4I().new Solution();
        // TO TEST
        System.out.println(solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int len = temperatures.length;
            int[] ans = new int[len];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int index = stack.pop();
                    ans[index] = i - index;
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                ans[stack.pop()] = 0;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}