package leetcode.editor.cn;

import java.util.Stack;

//Java：每日温度
public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty()) {
                int index = stack.peek();
                if (temp > temperatures[index]) {
                    ans[index] = i - index;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}