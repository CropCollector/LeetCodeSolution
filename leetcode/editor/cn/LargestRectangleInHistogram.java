package leetcode.editor.cn;

//Java：柱状图中最大的矩形
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        // TO TEST
        System.out.println(solution.largestRectangleArea(new int[]{2,1,2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int area = heights[i];
            for (int j = i; j > 0 && heights[j] >= heights[j - 1]; j--) {
                area = Math.max(area, heights[j - 1] * (i - j + 2));
            }
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}