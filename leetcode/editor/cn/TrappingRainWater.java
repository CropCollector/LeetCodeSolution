package leetcode.editor.cn;

import java.util.Stack;

//Java：接雨水
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        // TO TEST
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Bean {
            int index;
            int height;

            public Bean(int index, int height) {
                this.index = index;
                this.height = height;
            }
        }


        public int trap(int[] height) {
            int ans = 0;
            Stack<Bean> stack = new Stack<>();
            int n = height.length;
            for (int i = 0; i < n; i++) {
                int curH = height[i];
                while (!stack.isEmpty() && curH > stack.peek().height) {
                    Bean bean = stack.pop();
                    int h = bean.height;
                    if (stack.isEmpty()) {
                        break;
                    }
                    Bean lBean = stack.peek();
                    int lIndex = lBean.index, lH = lBean.height;
                    ans += (Math.min(lH, curH) - h) * (i - lIndex - 1);
                }
                stack.add(new Bean(i, curH));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}