package leetcode.editor.cn;

//Java：盛最多水的容器
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     *  Smax = min(index1, index2) * length
     *  开始让index1 = 0， index2 = 数组最后一位，每次移动index1，index2中较短的一边，直到1，2重合，其间最大值即为最后的结果
     *  因为每次移动影响min(index1, index2)的1，2中较短的一边，若移动较长的一边，min(index1, index2)只可能变小，length必定变小，所以移动长边没有意义，
     *  移动较短的一边才有可能让结果变大
     */
    public int maxArea(int[] height) {
        int s = 0;
        for (int i1 = 0, i2 = height.length - 1; i1 <= i2;) {
            int curS = (i2 - i1) * Math.min(height[i1], height[i2]);
            if (curS > s) {
                s = curS;
            }
            if (height[i1] < height[i2]) {
                i1 ++;
            } else {
                i2 --;
            }
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}