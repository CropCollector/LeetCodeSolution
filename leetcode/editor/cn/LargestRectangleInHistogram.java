package leetcode.editor.cn;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int[] newHeights = new int[heights.length + 2];
            for (int i = 1; i <= heights.length; i++) {
                newHeights[i] = heights[i - 1];
            }

            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < newHeights.length; i++) {
                while (!stack.isEmpty()) {
                    Integer curCal = stack.peek();
                    if (newHeights[curCal] > newHeights[i]) {
                        stack.pop();
                        int left = stack.peek();
                        int area = (i - left - 1) * newHeights[curCal];
                        ans = Math.max(ans, area);
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
